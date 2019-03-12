package coursework1;

import java.util.ArrayList;
import java.util.Scanner;

/** Author: Kaloyan Valchev
 *  Assignment: CourseWork 1
 *  This is the Album class, which stores tracks in album
 */
public class Album implements Comparable<Album> {
    
    //     Creating variables 
    public String artistName;
    public String albumName;
    public Duration duration;
    public ArrayList<Track> tracksAlbum;
    // For every track in Album, add duration to total duration.
    public Duration totalDuration(){
        Duration dur = new Duration();
        for (Track trackIndex : tracksAlbum){
            dur.addDuration(trackIndex.duration);
        }
        return dur;
    }   
     // Splitting line of file into Duration and Track list
    public Album(String lineReader){
        String[] lineSplitter = lineReader.split(" : "); //Array storing segments from the line that is split
        artistName = lineSplitter[0];
        albumName = lineSplitter[1];
        tracksAlbum = new ArrayList<Track>();
        duration = new Duration();
    }
  
   //     If no input in the album - Making empty data in variables "Uknown"
    public Album(){
        artistName = "Unknown";
        albumName = "Unknown";
        tracksAlbum = new ArrayList();
    }
   
    // making an add track to album function
    public void addToAlbum(Track track){
        tracksAlbum.add(track);
        duration.addDuration(track.duration);
    }
  
  // Adding whole duration of album
    public Duration localDur(){
        Duration totalDur = new Duration();
        for (int i = 0; i < this.tracksAlbum.size(); i++) {
           totalDur.addDuration(this.tracksAlbum.get(i).getDuration());
            
        }
        return totalDur;
    }
    
   

    // Creating String so it can print out the album details
    public String toString(){
        String albumDetails = (artistName + " / "+ albumName + " / " + localDur());
        return albumDetails;
    }
    // getting artist, album names and duration
    public String getArtistName(){
        return artistName;
    }
    
    public String getAlbumName(){
        return albumName;
    }
    public Duration getDuration(){
        return duration;
    }
    public ArrayList<Track> getTrackList(){
        return tracksAlbum;
    }
    // Comparing the albums in arrayList so it can be sorted alphabetically.
    @Override
    public int compareTo(Album compare){
        int artist = compareArtist(compare);
        if(artist == 0 ){
            return compareName(compare);
        }
        return artist;
    }
    // methods used in compareTo function
    public int compareName(Album compare){
         return this.albumName.compareTo(compare.getAlbumName());
    }
    public int compareArtist(Album compare){
         return this.artistName.compareTo(compare.getArtistName());
    }
    
    
    
//  Testing main. 
    
    public static void main(String[] args) {
      
       Scanner userIn = new Scanner(System.in);
       //System.out.println("Please enter Duration: ");
      // String newTime = userIn.nextLine();
       
       Duration dur = new Duration(1,12,14);
       System.out.println(dur);
        
       Track track = new Track("Duration: ", dur);
       System.out.println(track); 
       
       Album album = new Album("Artist name : Album name");
        System.out.println(album);
      
    }
      
    
}


// In order to print duration i need to create object dur to store the duration