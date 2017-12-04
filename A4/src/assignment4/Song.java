package assignment4;

// This class represents a single song
public class Song { // implements Comparable<Song> {

	private int year;		// The song's year
	private String title;	// The song's title
	private String artist;	// The song's artist

	// Constructor
	public Song(String title, String artist, int year) {
		this.year = year;
		this.title = title;
		this.artist = artist;
	}

	/*
	@Override
	public int compareTo(Song song) {
		return title.compareTo(song.getTitle());
	}
	 */

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		return "SONG=" + title + ", ARTIST=" + artist + ", YEAR=" + year;
	}
}
