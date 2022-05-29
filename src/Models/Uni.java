package Models;


public class Uni {


    public static Models.Queue<Student> readStudentQueue = new Models.Queue<>();

    public static Models.Queue<Student> writeStudentQueue = new Models.Queue<>();

    public static boolean finishRead=false;

    public static boolean finishCalculateAvg=false;


    /**
     * function for calculate avg of student
     * @param student
     */
    public void calculateAvg(Student student) {


        float sumScore= student.getLessons().stream().map(Lesson::getScore).reduce(Float::sum).get();

        float avg = sumScore/student.getLessons().size();

        student.setAvg(avg);
    }


}
