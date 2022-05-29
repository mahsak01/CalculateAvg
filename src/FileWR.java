import Models.Student;

import java.io.*;

public class FileWR {

    // base path for save outputs
    private final static String path="output\\";

    /**
     * function for read file and add student
     */
    public static void readFile()  {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("inputData.txt")));
            while (true) {

                try {
                    String line = "";
                    if ((line = reader.readLine()) == null)
                        break;
                    Main.addStudent(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * function for Write output in file
     * @param student
     */
    public static void writeFile(Student student) {

        try {
            File file = new File(path+student.getUuid().toString()+".json");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(student.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
