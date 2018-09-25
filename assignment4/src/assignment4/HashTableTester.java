package assignment4;

import java.util.Random;
import java.io.FileReader;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;

// Class for testing your implementation of the HashTable class
public class HashTableTester {

    // Returns a list of songs to use for testing the hash table
    private static ArrayList<Song> initSongList() {
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Le Premier Bonheur du Jour", "Os Mutantes", 1968));
        songs.add(new Song("Stretch Out And Wait", "The Smiths", 1987));
        songs.add(new Song("Scream", "Black Flag", 1984));
        songs.add(new Song("Europe, After the Rain", "Max Richter", 2002));
        songs.add(new Song("Why Are You Looking Grave?", "Mew", 2005));
        songs.add(new Song("Fallen Angel", "King Crimson", 1974));
        return songs;
    }

   @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        ArrayList<Song> songs = initSongList();

        String line = "";
        String cvsSplitBy = ",";
        BufferedReader br = null;
        String csvFile = "C:\\Users\\Abbas\\Documents\\Code\\Workspace Java\\COMP250\\A4\\tests\\Songs.csv";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] song = line.split(cvsSplitBy);
                songs.add(new Song(song[0], song[1], parseInt(song[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        MyHashTable<String,Song> songTable;
        int numBuckets = 6;

        // Initialize the hash table. Key will be the song title.
        songTable = new MyHashTable<String,Song>(numBuckets);
        for (Song song: songs) {
            songTable.put(song.getTitle(), song);
            System.out.println(song);
        }
        System.out.println("Number of songs: " + songTable.size());
        System.out.println("Number of buckets: " + songTable.getNumBuckets() + "\n");


        // Try to retrieve a song
        StringBuffer errors = new StringBuffer();
        Song testSong0 = songTable.get("Scream");
        System.out.println(testSong0 + "\n");
        if (testSong0 == null || !testSong0.getArtist().equals("Black Flag") || testSong0.getYear() != 1984)
            errors.append("Failed to retrieve song 'Scream'.\n");


        // Rehashing changes the capacity of the table, but not the number of entries
        songTable.rehash();
        System.out.println("Number of songs: " + songTable.size());
        System.out.println("Number of buckets: " + songTable.getNumBuckets() + "\n");


        // Try to retrieve a song
        Song testSong1 = songTable.get("Scream");
        System.out.println(testSong1 + "\n");
        if (testSong1 == null || !testSong1.getArtist().equals("Black Flag") || testSong1.getYear() != 1984)
            errors.append("Failed to retrieve song 'Scream'.\n");


        // Test the iterator
        Iterator iterator = songTable.iterator();
        while (iterator.hasNext()) {
            HashNode<String,Song> song = (HashNode<String,Song>)iterator.next();
            System.out.println(song.getValue());
        }
        System.out.println();


        // PUT MORE TESTS HERE

        // Try to remove a song
        int songRemoved = 0;
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int songIndex = rand.nextInt(songs.size());

            ArrayList<String> songKeys = songTable.keys();
            ArrayList<Song> songValues = songTable.values();

            System.out.println("Size of table, keys, values: " + songTable.size() + ", " + songKeys.size() + ", " + songValues.size());

            Song keyFromList = songTable.get(songKeys.get(songIndex));
            Song valueFromList = songValues.get(songIndex);
            if (keyFromList != valueFromList)
                errors.append("Failed to match song " + songTable.get(songKeys.get(songIndex)) + ".\n");

            Song toRemove = songs.remove(songIndex);
            System.out.println("Song to remove: " + toRemove);

            Song removedSong = songTable.remove(toRemove.getTitle());
            Song retrievedSong = songTable.get(toRemove.getTitle());
            songRemoved++;
            if (removedSong == null || !removedSong.getArtist().equals(toRemove.getArtist())
                || removedSong.getYear() != toRemove.getYear() || retrievedSong != null) {
                errors.append("Failed to remove song " + toRemove.getTitle() + ".\n");
                System.out.println("Failed to remove song " + toRemove.getTitle() + ".");
                songRemoved--;
            }
        }
        System.out.println("Songs Removed: " + songRemoved + "\n");


        // Test the iterator
        iterator = songTable.iterator();
        while (iterator.hasNext()) {
            HashNode<String,Song> song;
            song = (HashNode<String,Song>)iterator.next();
            System.out.println(song.getValue());
        }


        // Clear hash table
        songTable.clear();
        if (!songTable.isEmpty())
            errors.append("Failed to clear table.");


        // Display the test results
        System.out.println();
        System.out.println("---------------\nTEST 1 RESULTS:\n---------------\n");
        if (errors.length() == 0) {
            errors.append("All tests passed successfully.");
        }

        System.out.println(errors.toString());
        System.out.println();

    }

}
