import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'debit'
})
export class DebitPipe implements PipeTransform {

  transform(value: number): any {
    return "- "+value;
  }

}
