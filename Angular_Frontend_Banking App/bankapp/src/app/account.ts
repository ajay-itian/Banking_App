import { Address } from "./Address";

  export class Account {
    id: number = 0;
    accountHolderName: string = "";
    balance: number = 0;
    dateofcreate:Date=new Date();
    email:string="";
    mobileNo:number=0;
    address:Address=new Address();
    dateofbirth:Date = new Date();
    
    constructor() {}
  }
