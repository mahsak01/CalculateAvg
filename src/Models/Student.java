package Models;

import java.util.ArrayList;
import java.util.UUID;

public class Student {

    private UUID uuid;

    private String firstName;

    private String lastName;

    private ArrayList<Lesson> lessons = new ArrayList<>();

    private float avg;

    public Student(UUID uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        lessons = lessons;
    }

    public void addLessons(Lesson lesson) {
        lessons.add(lesson);
    }


    @Override
    public String toString() {
        return "{" +
                "\"uuid\" : \"" + uuid +"\""+
                ",\n \"firstName\" : \"" + firstName  +"\""+
                ",\n \"lastName\" : \"" + lastName  +"\""+
                ",\n \"Lessons\" : " + lessons.toString() +
                ",\n \"avg\" : " + avg +
                '}';
    }
}
