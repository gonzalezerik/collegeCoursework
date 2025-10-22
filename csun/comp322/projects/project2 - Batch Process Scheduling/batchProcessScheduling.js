global.procNum = null;

function getSel(){

  r1.enterSel('1): Enter selection: ', (sel) => {
    r1.close();
  }); 
  return sel;
}


function enterFunc(){
  for(let i = 0; i < num; i++){
    r1.enterProcId('Enter process id ', (id) => {
      r1.close();
    }); 

    r1.enterArrival('Enter arrival cycle for process', (arrival) => {
      r1.close();
  });

    r1.enterTotal('Enter total cycles for process: ', (total) => {
      r1.close();
    });
}

function selFunc(int sel){
  switch(sel){ 
    case 1:
      r1.enterProc('Enter total number of processes: ', (proc) => {
        procNum = proc;
        r1.close();
      }); 
      return enterFunc();
      break; 
    case 2:
      
      break;
    case 3:

      break; 
    case 4:

      break;
    case 5: 

      break; 

}

const readLine = require('readLine');

const r1 = readLine.createInterface({
  input: process.stdin,
  output: process.stdout 
});
      

function menuFunc(){
  console.log("Batch Scheduling\n");
  console.log("----------------\n");
  console.log("1) Enter parameters: ");
  
  
  console.log("2) Schedule processes with FIFO algorithm\n");
  console.log("3) Schedule processes with SJF algorithm\n");
  console.log("4) Schedule processes with SRT algorithm\n");
  console.log("5) Qut and free memory\n");
}




function main() {
  do {
    menuFunc();
  } while (selFunc(getSel()));
} 
