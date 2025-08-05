package day12.task4;

public class Task4 {
    public static void main(String[] args) {

        MusicBand band1 = new MusicBand("Первая", 2000);
        MusicBand band2 = new MusicBand("Вторая", 2021);

        for (int i = 1; i < 12; i++) {
            band1.addMember("Участник группы Первая #" + i);
        }

        for (int i = 1; i < 12; i++) {
            band1.addMember("Участник группы Вторая #" + i);
        }

        MusicBand.transferMembers(band1, band2);

        System.out.println(band2);
    }
}
