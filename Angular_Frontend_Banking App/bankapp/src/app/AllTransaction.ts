import { Account } from "./account";

export class AllTransaction {
  transcId: number = 0;
  amount: number = 0;
  action: string = "";
  account!: Account;

  constructor() {}
}
