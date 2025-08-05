package day12.task4;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private final List<String> members = new ArrayList<>();
    private String name;
    private int year;

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public static void transferMembers(MusicBand a, MusicBand b) {
        b.getMembers().addAll(a.getMembers());
        a.getMembers().clear();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<String> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
               "name='" + name + '\'' +
               ", year=" + year +
               ", members=" + members +
               '}';
    }

    public void addMember(String member) {
        if (!members.contains(member)) {
            members.add(member);
        }
    }

    public void deleteMember(String member) {
        members.remove(member);
    }
}
