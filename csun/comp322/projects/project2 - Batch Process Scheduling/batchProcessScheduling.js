let procNum = null; let p = [];
const FLAG = { FIFO: 2, SJF: 3, SRT: 4 };
let clk = 0;
const makeBest = () => ({index: -1, value: Infinity}); 
const ask = (q) => new Promise((res) => r1.question(q, res)); 
const readLine = require('readline'); 
const r1 = readLine.createInterface({ input: process.stdin, output: process.stdout }); 

function getSel(){ 
  return new Promise((resolve) => { r1.question('Enter selection: ', (selection) => { 
    resolve(parseInt(selection, 10)); });
  }); 
 }


async function enterFunc(i = 0) {
  if (i === 0) p = [];          

  if (i >= procNum) {
    reset();
    printTable(p);
    return;                      
  }

  const proc = { done: 0, start: -1, end: -1, turnaround: -1 };

  await new Promise(res => r1.question('Enter process id: ', (id) => {
    proc.id = parseInt(id, 10);
    res();
  }));

  await new Promise(res => r1.question(`Enter arrival cycle for process P[${proc.id}]: `, (arrival) => {
    proc.arrival = parseInt(arrival, 10);
    res();
  }));

  await new Promise(res => r1.question(`Enter total cycles for process P[${proc.id}]: `, (total) => {
    proc.total = parseInt(total, 10);
    proc.totalRem = proc.total;  // for SRT later
    res();
  }));

  p.push(proc);
  await enterFunc(i + 1);
}


function printTable(list) {
  console.log("\nID      Arrival Total   Start   End     Turnaround");
  console.log("--------------------------------------------------");
  const val = (x) => (x === -1 || x == null ? "" : String(x));
  for (const row of list) {
    console.log(
      `${String(row.id).padEnd(8)}${String(row.arrival).padEnd(8)}${String(row.total).padEnd(8)}${val(row.start).padEnd(8)}${val(row.end).padEnd(8)}${val(row.turnaround)}`
    );
  }
  console.log();
}

function reset() {
  for (let i = 0; i < p.length; i++) {
    p[i].done = 0;
    p[i].start = -1;
    p[i].end = -1;
    p[i].turnaround = -1;
    p[i].totalRem = p[i].total;
  }
  clk = 0;
}
function compare(best, flag, i, table){
  let value; 

  switch(flag){
    case FLAG.FIFO: value = table[i].arrival; break;
    case FLAG.SJF: value = table[i].total; break;
    case FLAG.SRT: value = table[i].totalRem; break;
    default: value = Infinity;
  }
  if (value < best.value) return { index: i, value };

  if (value === best.value){
    if(best.index === -1 || table[i].arrival < table[best.index].arrival) {
      return { index: i, value};
    }
  }
  return best;
}

function isAllowed(flag, i, clk, table){
  const pr = table[i];
  switch(flag){
    case FLAG.FIFO:
      return pr.done == 0;
    case FLAG.SJF:
      return pr.done == 0 && pr.arrival <= clk;
    case FLAG.SRT:
      return pr.done == 0 && pr.arrival <= clk && pr.totalRem > 0;
    default:
      return false;
  }
}

function scan(flag, table, clk){
  let best = makeBest();
  for(let i = 0; i < table.length; i++){
    if(isAllowed(flag, i, clk, table)){
      best = compare(best, flag, i, table);
    }
  }
  return best;
}

function fifoOnce(table) {
  const best = scan(FLAG.FIFO, table, clk);
  if (!best || best.index === -1) return false;   // guard

  const pr = table[best.index];
  pr.start = Math.max(pr.arrival, clk);
  pr.end = pr.start + pr.total;
  pr.turnaround = pr.end - pr.arrival;
  pr.done = 1;

  clk = pr.end;
  return true;
}

function fifo(table) {
  while (table.some(t => t.done === 0)) {
    const ok = fifoOnce(table);
    if (!ok) break;  // safety
  }
}

async function selFunc(sel) {
  switch (sel) {
    case 1: 
      const num = await new Promise(res => r1.question('Enter total number of processes: ', res));
      procNum = parseInt(num, 10);
      await enterFunc(0);
      return true;       
    case 2:
      if (!p.length) {
        console.log("Enter parameters first (option 1).\n");
        return true;
      }

      reset();
      fifo(p);
      printTable(p);
      return true; 
    
    case 3:
      
      if (!Array.isArray(p) || p.length === 0) {
        console.log("Enter parameters first (option 1).\n");
        return true;
      }
      reset();          
      sjf(p);
      printTable(p);
      return true;

    case 4:
      if (!Array.isArray(p) || p.length === 0) {
        console.log("Enter parameters first (option 1).\n");
        return true;
      }
      reset();     
      srt(p);
      printTable(p);
      return true;
    
    case 5:
      console.log("Quitting program. . .\n");
      r1.close();
      return false;        

    default:
      console.log("Invalid selection.\n");
      return true;
  }
}

function nextArrivalClk(table, clk) {
  let next = Infinity;
  for (const pr of table) {
    if (pr.done === 0 && pr.arrival > clk && pr.arrival < next) {
      next = pr.arrival;
    }
  }
  return next === Infinity ? clk : next;
}

function sjfOnce(table) {
  const best = scan(FLAG.SJF, table, clk);
  
  if (!best || best.index === -1) {
    const jumped = nextArrivalClk(table, clk);
    if (jumped === clk) return false; 
    clk = jumped;
    return true;
  }

  const pr = table[best.index];
  
  pr.start = clk;                          
  pr.end = pr.start + pr.total;
  pr.turnaround = pr.end - pr.arrival;
  pr.done = 1;

  clk = pr.end;                            
  return true;
}


function sjf(table) {
  while (table.some(t => t.done === 0)) {
    if (!sjfOnce(table)) break; 
  }
}

      

function menuFunc(){
  console.log("Batch Scheduling");
  console.log("----------------");
  console.log("1) Enter parameters: ");  
  console.log("2) Schedule processes with FIFO algorithm");
  console.log("3) Schedule processes with SJF algorithm");
  console.log("4) Schedule processes with SRT algorithm");
  console.log("5) Qut and free memory\n");
}


function srt(table) {
  
  for (const pr of table) {
    if (typeof pr.totalRem !== 'number') pr.totalRem = pr.total;
  }

  while (table.some(t => t.done === 0)) {
    const best = scan(FLAG.SRT, table, clk);

    
    if (!best || best.index === -1) {
      const jumped = nextArrivalClk(table, clk);
      if (jumped === clk) break;  
      clk = jumped;
      continue;
    }

    const pr = table[best.index];

    if (pr.start === -1 || pr.start == null) pr.start = clk;
    
    pr.totalRem -= 1;
    clk += 1;
    
    if (pr.totalRem === 0) {
      pr.end = clk;
      pr.turnaround = pr.end - pr.arrival;
      pr.done = 1;
    }    
  }
}



async function main() {
  let loop = true;
  while (loop) {

    menuFunc();
    const sel = await getSel();
    loop = await selFunc(sel);  

  }
}
main();

