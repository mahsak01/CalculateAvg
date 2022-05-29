package Models;

public class Lesson {

    private String name;

    private float score;

    public Lesson(String name, float score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\" : \"" + name + "\",\n" +
                "\"score\" : " + score +
                '}';
    }
}
