package listenfiy;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    public String albumName;
    public String artistName;
    public List<Song> songList;

    public Album(String albumName, String artistName) {

        //Initialize the songList
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }


    public boolean findSongInAlbum(String title){
        // Iterate over the arraylist and match
        // each Song title with title

         for (Song song : songList)
             if((song.title).compareTo(title) == 0) {
                 return true;
             }

         return false;
    }

    public String addSongToAlbum(String title, double duration){
        //check if the song is already present we will not add
        //otherwise we will create a new Song and add it to the songList

        if(findSongInAlbum(title) == true)
            return "Song is already present";
        else{
            //I need to create a Song object and then add it to songList
            Song newSong = new Song(title, duration);
            songList.add(newSong);
            return "New Song has been added successfully.";
        }
    }

    public String addSongToPlayList(int trackNo, LinkedList<Song> playList) {

        int index = trackNo - 1;

        //Checking for validity of index
        if(index >= 0 && index < this.songList.size()){
            Song song = this.songList.get(index);
            playList.add(song);
            return  "Song added to the playList";
        }
        return "Invalid track No";
    }

    public String addSongToPlayList(String title, LinkedList<Song> playList){
        //I need to find out that Song wiith that title
        //and put it in the playlist

        boolean addedSong = false;
        for (Song song:songList) {

            if (song.title == title) {
                playList.add(song);
                addedSong = true;
                return "Song has been added successfully";
            }
        }
        return "Song doesn't added";
    }
}
