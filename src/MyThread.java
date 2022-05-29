import Models.Student;

public class MyThread implements Runnable {
    Student student ;

    MyThread(Student student) {
        this.student = student;
    }

    public void run() {
        Main.uni.calculateAvg(student);
        Main.uni.writeStudentQueue.push(student);
    }
}
