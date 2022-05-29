import java.io.*;
import java.util.UUID;

public class RandomData {
    public static void main(String[] args) {
        File file = new File("inputData.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for (int i = 0; i <10000 ; i++){
                StringBuilder text= new StringBuilder(UUID.randomUUID() + " mahsa" + i + " karimi" + i + " ");

                for (int j = 0; j <30;j++)
                    text.append("lesson").append(j).append(" 20 ");

                writer.write(text+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
