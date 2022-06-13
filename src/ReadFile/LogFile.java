package ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
We have a log file, can grow pretty big. Each line is a trace-log, and the first field is the RequestID.
We need to scan the file, and print all the logs for requests which resulted in error ..

- RandomAccessFile in Java, readLine()  contains(Error). getLine. substring(0,3). put in a Set. Compare with other ids
 */
public class LogFile {

    public static List<String> trackErrorId() {
        List<List<String>> file = scanFile();

        List<String> response = new ArrayList<String>();

        for(List<String> line : file) {
            if(line.get(2).equals("ERROR")) response.add(line.get(0));
        }
        return response;
    }

    public static List<List<String>> scanFile() {
        List<List<String>> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(System.getenv("log.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> lineParsed = new ArrayList<>();
                String read[] = line.split(" ");
                for (String r : read) {
                    lineParsed.add(r);
                }
                list.add(lineParsed);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
}
