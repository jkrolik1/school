import { DatePipe } from '@angular/common';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'todotime'
})
export class TodotimePipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {
    let date = new Date(value);
    let difference = new Date(new Date().getTime() - date.getTime()).getTime();
    difference = Math.round(difference/1000);

    if(difference < 60)
      return difference + ' sekund temu';
    if(difference < 3600)
      return Math.round(difference/60) + ' minut temu';
    if((difference / 3600) < 24 )
      return 'Dziś o ' + new DatePipe('en-US').transform(date, 'HH:mm');


    return new DatePipe('en-US').transform(date, 'yyyy-MM-dd');
  }

}
