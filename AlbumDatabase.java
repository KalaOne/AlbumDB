
package coursework1;

/** Author: Kaloyan Valchev
 *  Assignment: CourseWork 1
 *  Main class
 */
import java.io.*;

public class AlbumDatabase {

    
    public static void main(String[] args) {
       File file = new File("albums.txt");
       AlbumCollection albumC = new AlbumCollection(file);
       System.out.println("1. Album successfully read.");
       System.out.println("----------------------------------------------------"
               + "------------------------------------------------------------"
               );
        System.out.println(albumC.toString());
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("3. Total Pink Floyd Duration");
        System.out.println(albumC.getArtistTotalDur("Pink Floyd"));
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("4. Album with largest number of tracks: " + albumC.albumWithMostTracks());

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("5. Longest track in the file: " + albumC.longestTrack());
    }
    
}


//Indication that the album is successfully read.
//Arrange in alphabet order(comparable each (Album))
//TO STRING AlbumCollection to print everything.
//Display everything Albumcollection + duration
//Total Pink Floyd duration
//Album with largets number of tracks.

//Longest Track in Album

//Add Disturbed; Print it as well. :)