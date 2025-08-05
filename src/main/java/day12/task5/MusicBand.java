package day12.task5;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private final List<MusicArtist> musicArtists = new ArrayList<>();
    private final String name;
    private final int year;

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public static void transferArtists(MusicBand a, MusicBand b) {
        b.getMusicArtists().addAll(a.getMusicArtists());
        a.getMusicArtists().clear();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<MusicArtist> getMusicArtists() {
        return musicArtists;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
               "name='" + name + '\'' +
               ", year=" + year +
               ", members=" + musicArtists +
               '}';
    }

    public void addMember(MusicArtist member) {
        if (!musicArtists.contains(member)) {
            musicArtists.add(member);
        }
    }

    public void deleteMember(MusicArtist member) {
        musicArtists.remove(member);
    }
}
