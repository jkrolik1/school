import { DatePipe } from '@angular/common';
import { Pipe, PipeTransform } from '@angular/core';
import * as moment from 'moment';

@Pipe({
  name: 'todotime'
})
export class TodotimePipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {
    return moment(value).lang("pl").fromNow();
  }

}
