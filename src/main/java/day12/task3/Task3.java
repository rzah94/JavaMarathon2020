package day12.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {

        Random random = new Random();

        final int fromYear = 1970;
        final int toYear = 2010;

        List<MusicBand> bands = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int year = random.nextInt(toYear - fromYear + 1) + fromYear;

            bands.add(new MusicBand("groupName #" + i, year));
        }

        Collections.shuffle(bands);

        System.out.println(bands);
        System.out.println(groupsAfter2000(bands));

    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        return bands.stream()
                .filter(band -> band.getYear() > 2000)
                .toList();
    }
}
