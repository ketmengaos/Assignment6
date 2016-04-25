//**********************************************************************************
//******** || Ket-Meng Jimmy Cheng ~ April 17, 2016 ~ BST Assignment # 5 || ********
//******** || ---------------------------------------------------------- || ********
//******** || This program reads from an input: the Bible. From this,    || ********
//******** || the program lists the top 100 words ordered by usage       || ********
//******** || by creating two Binary Search Trees: the first to list the || ********
//******** || words and increase the counter every time the word is used || ********
//******** || and the second, which is constructed to list the usage and || ********
//******** || words in order.                                            || ********
//**********************************************************************************

//All code is hosted at github.com/ketmengaos.
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            PrintWriter out = new PrintWriter("Output.txt");

            HashMap<Triple<String, String, String>, Integer> hash = new HashMap<Triple<String, String, String>, Integer>();
            Scanner input = new Scanner(new FileReader("Bible"));

            String content = new String(Files.readAllBytes(Paths.get("Bible")));
            String[] spaced = content.split("[ 0-9();:*,.?!\"\\n\\r]+");

            System.out.println(spaced[12]);
            for(int i = 0; i < spaced.length; i = i + 3){
                Triple<String, String, String> trip = new Triple<String, String, String>(spaced[i], spaced[i+1], spaced[i+2]);
                //System.out.println(spaced[i] + " " + spaced[i+1] + " " + spaced[i+2]);
                //System.out.println(trip);
                if(hash.containsKey(trip)) {
                    int temp = hash.get(trip);
                    hash.put(trip, temp+1);
                }
                else hash.put(trip, 1);
            }

            for (Map.Entry entry : hash.entrySet()) {
                String key = entry.getKey().toString();
                Integer value = (Integer) entry.getValue();
                out.println(key + " " + value);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error Found: " + e);
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error Found: " + e);
            System.exit(1);
        }

    }
}