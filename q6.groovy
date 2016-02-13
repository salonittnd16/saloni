//unable to resolve the exception here
class HourMinute
{
    int hours
    int minutes
    
    int getHours()
    {
        this.hours
     }
     
 int getMinutes()
    {
        this.minutes
     }
     
     
     void setHours(int hours)
     {
         this.hours=hours
         }
         
         
         void setMinutes(minutes)
         {
             this.minutes=minutes
         
         }
          
     
         HourMinute plus(HourMinute hm1,HourMinute hm2)
         {    HourMinute result=new HourMinute()
             result.hours=hm1.hours+hm2.hours
             result.minutes=hm1.minutes+hm2.minutes
             
            return result  
             }
 HourMinute minus(HourMinute hm1,HourMinute hm2)
         {    HourMinute result=new HourMinute()
             if(hm1.hours>hm2.hours)
            { result.hours=hm1.hours-hm2.hours
             result.minutes=hm1.minutes-hm2.minutes
            } 
             else
             { result.hours=hm1.hours-hm2.hours
             result.minutes=hm1.minutes-hm2.minutes
            } 
             
             return result  
                     }
    
 }

HourMinute hm1=new HourMinute(hours:2,minutes:20)
HourMinute hm2=new HourMinute(hours:4,minutes:30)
HourMinute finalAdd=hm1+hm2
HourMinute finalSub=hm1-hm2
println "time after adding is= hours : ${finalAdd.hours} and minutes : ${finalAdd.minutes}"
println "time after deducting is= hours : ${finalSub.hours} and minutes : ${finalSub.minutes}"

