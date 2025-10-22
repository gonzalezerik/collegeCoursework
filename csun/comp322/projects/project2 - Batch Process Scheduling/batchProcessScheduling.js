let procNum = null;
let p = [];
const ask = (q) => new Promise((res) => r1.question(q, res));

const readLine = require('readline');

const r1 = readLine.createInterface({
  input: process.stdin,
  output: process.stdout 
});


function getSel(){
  return new Promise((resolve) => {
    r1.question('Enter selection: ', (selection) => {
      resolve(parseInt(selection, 10));
    });
  }); 
 }
const pTemp = {};

function enterFunc(i){
  if (i >= procNum ){
    r1.close();
    printTable(p);
    return true;
  }
  console.log("entered enterFunc\n");
  p = [];

  r1.question('Enter process id: ', (id) => {
    pTemp.id = parseInt(id);

    r1.question('Enter arrival cycle for process', (arrival) => {
      pTemp.arrival = parseInt(arrival);

      r1.question('Enter total cycles for process: ', (total) => {
        pTemp.total = parseInt(total);
        
        p.push(pTemp);
        enterFunc(i + 1);
      });
    });
  });
  
}
function printTable(list){
  console.log("ID Arrival Total Start End Turnaround\n");
  console.log("-------------------------------------\n");
  for (const p of list) {
    const val = (x) => (x == null ? "": String(x));

    console.log(`${String(p.id).padEnd(7)}`+` ${String(p.arrival).padEnd(7)}`+ `${String(p.total).padEnd(7)}`+ `${val(p.start).padEnd(7)}` + ` ${val(p.end).padEnd(7)}` +` ${val(p.turnaround)}`);
    console.log();
  }



}



function selFunc(sel){
  switch(sel){ 
    case 1:
        console.log("case1\n");
        r1.question('Enter total number of processes: ', (num) => {
        procNum = parseInt(num);
        enterFunc(0)
      });
      
    case 2:
      
      break;
    case 3:

      break; 
    case 4:

      break;
    case 5: 

      break; 

  }
}

      

function menuFunc(){
  console.log("Batch Scheduling\n");
  console.log("----------------\n");
  console.log("1) Enter parameters: ");
  
  
  console.log("2) Schedule processes with FIFO algorithm\n");
  console.log("3) Schedule processes with SJF algorithm\n");
  console.log("4) Schedule processes with SRT algorithm\n");
  console.log("5) Qut and free memory\n");
}




async function main() {
  let sel;
  do {
    menuFunc();
} while(selFunc(await getSel()));
}
main();
