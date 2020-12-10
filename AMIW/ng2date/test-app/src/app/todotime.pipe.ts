import { Pipe, PipeTransform } from '@angular/core';
import * as moment from 'moment';

@Pipe({
  name: 'todotime'
})
export class TodotimePipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {

    const a = moment();
    const b = moment(value);
    const hours = a.diff(b, 'hours');

    if (hours < 23) {
      return moment(value).lang("pl").fromNow();
    } else {
      moment(value).calendar(null,{
        lastDay : '[Yesterday]',
        sameDay : '[Today]',
        nextDay : '[Tomorrow]',
        lastWeek : '[last] dddd',
        nextWeek : 'dddd',
        sameElse : 'L'
      })
      return moment(value).lang("pl").calendar();
    }
  }

}
