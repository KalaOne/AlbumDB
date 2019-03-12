package coursework1;

/**
 * Author: Kaloyan Valchev Assignment: CourseWork 1 This is the Album Collection
 * class, which stores details of all Albums
 */
import java.util.ArrayList;
import java.io.File;
import java.io.*;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlbumCollection {

    //Creating arrayList to store all Albums
    public ArrayList<Album> collection;

    public AlbumCollection() {
        collection = new ArrayList<Album>();
        
    }

    public AlbumCollection(File file) {
        try {
            // Creating new album to store the items from file that doesnt start with 0
            Album album = new Album();
            BufferedReader bufRead = null;
            FileReader fileReader = null;
            // Creating a var to read file, to store items from file, read items
            try {
                collection = new ArrayList<Album>();
                // reading file
                // storing items from the file
                fileReader = new FileReader(file);
                // reading/writing items from file.
                bufRead = new BufferedReader(fileReader);
            } catch (Exception exception) {
                System.out.println("Couldn't read file....");
            }
            //Creating a line reader - to check if there are any lines left
            String line;

            while ((line = bufRead.readLine()) != null) {
                // if line doesnt start with 0 - it means it's album name
                // creating new album and storing line in it
                if (line.charAt(0) != '0') {
                    album = new Album(line);
                    collection.add(album);
                } //if line does start with 0, then split the duration with artist name
                //save duration and track as new variables.
                else {
                    Track track = new Track(line);
                    album.addToAlbum(track);
                }
            }
            
            Collections.sort(collection); // Sorting the arrayList alphabetically 
        } catch (IOException ex) {

        }

    }

    public Duration getArtistTotalDur(String artist) {
        Duration totalPlayTime = new Duration();  //Creating a new Duration object to return
        for (int i = 0; i < collection.size(); i++) { // Looping through Album Collection
            if (collection.get(i).artistName.equals(artist)) { //If artist name is = to given artist name
                totalPlayTime.addDuration(collection.get(i).duration); // Adding duration to total duration for that artist.
            }
        }

        return totalPlayTime;
    }

    public String albumWithMostTracks() {
        Album album = new Album();
        int albumSize = 0;
        int trackNum = 0;
        for (int i = 0; i < collection.size(); i++) {
            for (int j = 0; j < collection.get(i).getTrackList().size(); j++) {
                trackNum++;
            }
            if (trackNum > albumSize) {
                albumSize = trackNum;
                album = collection.get(i);
            }
            trackNum = 0;
        }
        return album.getAlbumName();
    }

    public String longestTrack() {
        Track longestTrack = new Track();
        int minVal = -1;
        for (Album collection1 : this.collection) { // looping though album collection
            
            for (Track currentTrack: collection1.getTrackList()) { // looping through tracks in album         
                
                
                if (currentTrack.duration.calCurrDur()> minVal)
                {    // getting current track's duration, compare to longestTrack's duration
                    longestTrack = currentTrack;
                    minVal = currentTrack.duration.calCurrDur();
                }
            }
        }
        //if (longestTrack != null) {
            return longestTrack.toString();
//        } else {
//            return "Some problem searching the tracks";
//        }
  }
    
   

    public String toString() {
        String wholeString = "";
        for (int album = 0; album < collection.size(); album++) {
            Album getAlbum = collection.get(album);
            System.out.printf("%-40s %-40s %-30s\n", "Artist: "
                    + getAlbum.artistName, " Album title: " + getAlbum.albumName, " Duration: " + getAlbum.getDuration());
        }
        return wholeString;
    }

    public static void main(String[] args) {
        File file = new File("albums.txt");
        AlbumCollection newCollection = new AlbumCollection(file);
        System.out.println("Album successfully read.");
        System.out.println("----------------------------------------------------"
                + "------------------------------------------------------------"
        );
        System.out.println(newCollection.toString());

    }

}
