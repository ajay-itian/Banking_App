import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'credit'
})
export class CreditPipe implements PipeTransform {

  transform(value: number): any {
    return "+ "+value;
  }

}
