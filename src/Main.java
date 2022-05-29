import Models.Lesson;
import Models.Student;
import Models.Uni;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static Models.Uni.writeStudentQueue;

public class Main {

    public static Uni uni = new Uni();



    public static void main(String[] args) {

        readFile();
        calculateAvg();
        writeFile();

    }
    public static void writeFile(){
        Thread thread = new Thread(){
            @Override
            public synchronized void start() {
                Long fistTime = System.currentTimeMillis();
                ThreadPoolExecutor pool =(ThreadPoolExecutor) Executors.newFixedThreadPool(5);
                while (!uni.finishCalculateAvg || !writeStudentQueue.isEmpty() || pool.getActiveCount()!=0 || !pool.getQueue().isEmpty()) {
                    if (!writeStudentQueue.isEmpty()){
                        FileWR.writeFile(writeStudentQueue.pop());
                    }
                }
                pool.shutdown();
                Long lastTime = System.currentTimeMillis();
                System.out.println("time for write data : " + (lastTime - fistTime));

            }
        };
        thread.start();
    }
    public static void readFile(){
        Thread thread = new Thread(){
            @Override
            public synchronized void start() {
                Long fistTime = System.currentTimeMillis();
                FileWR.readFile();
                Long lastTime = System.currentTimeMillis();
                System.out.println("time for read data : " + (lastTime - fistTime));
                uni.finishRead=true;
            }
        };
        thread.start();
    }

    public static void calculateAvg() {
        Thread thread = new Thread(){
            @Override
            public synchronized void start() {
                Long fistTime = System.currentTimeMillis();
                ThreadPoolExecutor pool =(ThreadPoolExecutor)Executors.newFixedThreadPool(10);
                while ( !uni.finishRead || !uni.readStudentQueue.isEmpty() || pool.getActiveCount()!=0 || !pool.getQueue().isEmpty()) {
                    if (!uni.readStudentQueue.isEmpty()){
                        Runnable thread = new MyThread(uni.readStudentQueue.pop());
                        pool.execute(thread);
                    }
                }
                pool.shutdown();
                uni.finishCalculateAvg=true;
                Long lastTime = System.currentTimeMillis();
                System.out.println("time for calculate Avg : " + (lastTime - fistTime));

            }
        };
        thread.start();
    }

    public static void addStudent(String line) {
        String[] input = line.split(" ");
        Student student = new Student(UUID.fromString(input[0]), input[1], input[2]);
        for (int i = 3; i < input.length; i += 2) {
            student.addLessons(new Lesson(input[i], Float.parseFloat(input[i + 1])));
        }
        Uni.readStudentQueue.push(student);
    }


}
