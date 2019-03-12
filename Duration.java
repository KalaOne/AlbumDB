package coursework1;

import java.util.Scanner;  //For testing

/** Author: Kaloyan Valchev
 *  Assignment: CourseWork 1
 *  This is the duration class, which displays duration of tracks in album
 */

public class Duration {
    
    /***** Creating integers used in the class *******/
   
    private int hh;
    private int mm;
    private int ss;
    private int totalSec;
    
    /**************** Splitting given time to segments - hh/mm/ss ******************/
    
    //No input - setting time to 00:00:00
    public  Duration(){
        hh = 0;
        mm = 0;
        ss = 0;
        totalSec = ((hh*3600) + (mm * 60) + ss);
    }
    // Taking input - replacing hours,mins,sec, with input/parameters
    public  Duration(int hh, int mm, int ss){
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
        this.totalSec = ((hh*3600) + (mm * 60) + ss);
    }
    // adding duration, used for total album duration
    public void addDuration(Duration dur){
        this.hh += dur.getHour();
        this.mm += dur.getMin();
        this.ss += dur.getSs();
        totalSec = ((hh*3600) + (mm * 60) + ss);
          
    }
    public int calCurrDur(){
        totalSec = ((hh*3600) + (mm * 60) + ss);
        return totalSec;
    }
    // Get-ers to access data from other classes
    public int getHour(){
        return hh;
    }
    public int getMin(){
        return mm;
    }
    public int getSs(){
        return ss;
    }
    public int getTotalSec(){
        return totalSec;
    }
    // Splitting the duration between ":"
    public Duration(String split){
        String[] wholeDur = split.split(":");
        hh = Integer.parseInt(wholeDur[0]);
        mm = Integer.parseInt(wholeDur[1]);
        ss = Integer.parseInt(wholeDur[2]);
    }
    
    /* Conveerts integer hour/min/sec to string so time lenght can be displayed. */
    
    public String toString (){
        int totalHours = (totalSec / 3600); // Getting Hours from seconds
        int remainingSec = totalSec % 3600; //Getting seconds without hours
        int totalMin = (remainingSec / 60); //Getting Minutes from remaining seconds
        remainingSec = totalSec - (totalHours * 3600) - (totalMin * 60); // Seconds left without hours and mins
        int seconds = remainingSec;
        
        String hours = Integer.toString(totalHours);
        String minutes = Integer.toString(totalMin);
        String sec = Integer.toString(seconds);
        String time = totalHours +":"+ totalMin+":"+ sec;

        return time;
    }
    // Testing main
    public static void main(String[] args) {
        // TODO code application logic here
//       Scanner userIn = new Scanner(System.in);
//       System.out.println("Please enter time: ");
//       String newTime = userIn.nextLine();
//       
//       Duration dur = new Duration(newTime);
//       System.out.println(dur);
        Duration dur = new Duration(1,23,50);
        System.out.println(dur.totalSec);
        System.out.println(dur);
    } 
}
    
