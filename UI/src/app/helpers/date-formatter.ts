import { Injectable } from '@angular/core';

@Injectable()
export class DateFormatter {
   constructor(){} 
    
   dayMonthYear(data){
    const d = new Date(data);
    return `${d.getDate()}. ${d.getMonth() + 1}. ${d.getUTCFullYear()}`;    
   } 
    
   dayMonthYearTime(data){
    const d = new Date(data);
    return `${d.getDate()}. ${d.getMonth() + 1}. ${d.getUTCFullYear()} ${d.getHours()}:00`;    
   }
}