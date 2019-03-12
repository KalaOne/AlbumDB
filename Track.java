
package coursework1;
/** Author: Kaloyan Valchev
 *  Assignment: CourseWork 1
 *  This is the Track class, displays track details - Title and duration
 */

import java.util.Scanner;

public class Track {
    //      Creating variables
    
    private String title;
    public Duration duration;
    //      If empty Track - set to Unknown, new duration(empty)
    public Track(){
        title = "Unknown";
        duration = new Duration();
    }
    //Input track title and duration. For test main.
    public Track(String newTitle, Duration newDuration){
        title = newTitle;
        duration = newDuration;
    }
    //Splitting line into 2 segments - numbers for duration
    // after "-" for TrackName.
    public Track (String lineRead){
         String[] splitLine = lineRead.split(" - ");
         duration = new Duration(splitLine[0]);
         title = splitLine[1];
    }
    // getting the title and the duration.
    public String getTitle(){
        return title;
    }
    
    public Duration getDuration(){
        return duration;
    }
    
    
    // Converting variables to string so can be printed out.
    public String toString(){
        String name = (title + duration.toString());
        return name;
    }
    //  Testing main.
    
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner userIn = new Scanner(System.in);
       System.out.println("Please enter Duration: ");
       String newTime = userIn.nextLine();
       
       Duration dur = new Duration(newTime);
       System.out.println(dur);
       
       Track track = new Track("trackName "+ "Duration: ", dur);
       System.out.println(track);
    
    }
  
}
