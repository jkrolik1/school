import { Pipe, PipeTransform } from '@angular/core';
import * as moment from 'moment';

@Pipe({
  name: 'datePipe'
})
export class DatePipePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return moment().startOf('hour').fromNow(); ;
  }

}
