import { Injectable } from '@angular/core';

@Injectable()
export class DateFormatter {
   constructor(){} 
    
   dayMonthYear(data){
    return `${data.dayOfMonth}. ${data.monthOfYear}. ${data.year}`;    
   }
    
   dayMonthYearTime(data){
    return `${data.dayOfMonth}. ${data.monthOfYear}. ${data.year} ${data.hourOfDay}:${data.minuteOfHour}`;    
   }
}