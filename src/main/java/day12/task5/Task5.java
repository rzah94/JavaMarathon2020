package day12.task5;

import day12.task5.MusicBand;

public class Task5 {
    public static void main(String[] args) {
        MusicBand band1 = new MusicBand("Первая", 2000);
        MusicBand band2 = new MusicBand("Вторая", 2021);

        for (int i = 1; i < 12; i++) {
            MusicArtist artist = new MusicArtist("Участник группы Первая #" + i, i);
            band1.addMember(artist);
        }

        for (int i = 1; i < 12; i++) {
            MusicArtist artist = new MusicArtist("Участник группы Вторая #" + i, i);
            band1.addMember(artist);
        }

        MusicBand.transferArtists(band1, band2);

        System.out.println(band1);
    }
}
