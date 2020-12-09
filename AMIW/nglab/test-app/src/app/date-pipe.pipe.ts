import { Pipe, PipeTransform } from '@angular/core';
import * as moment from 'moment';

@Pipe({
  name: 'datePipe'
})
export class DatePipePipe implements PipeTransform {

  transform(value: moment.Moment, ...args: unknown[]): string {
    const t = value.format();
    return t;
  }

}
