//**********************************************************************************
//******** || Ket-Meng Jimmy Cheng ~ April 25, 2016 ~ Hash Assignment #6 || ********
//******** || ---------------------------------------------------------- || ********
//******** || This program reads from an input: the Bible. From this,    || ********
//******** || the program will call put() and insert each trigram into   || ********
//******** || the hash map in the format of (Trigram, Occurrence). When  || ********
//******** || the program finds that there are multiple occurrences, it  || ********
//******** || adds 1 to the value of the Hashmap associated with it.     || ********
//**********************************************************************************

//All code is hosted at github.com/ketmengaos.
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            PrintWriter out = new PrintWriter("Output.txt");

            HashMap<Triple<String, String, String>, Integer> hash = new HashMap<Triple<String, String, String>, Integer>();

            //Streamlined way of parsing the information into a String.
            String bible = new String(Files.readAllBytes(Paths.get("Bible")));
            String[] spaced = bible.split("[ ();*,.?!\"\\n\\r]+"); //Should effectively strip unwanted punctuation.

            System.out.println(spaced[12]);
            for(int i = 0; i < spaced.length; i = i + 3){
                Triple<String, String, String> trip = new Triple<String, String, String>(spaced[i], spaced[i+1], spaced[i+2]);
                if(hash.containsKey(trip)) {
                    int temp = hash.get(trip);
                    hash.put(trip, temp+1);
                }
                else hash.put(trip, 1);
            }
            //Prints out the key and value.
            for (Map.Entry entry : hash.entrySet()) {
                String key = entry.getKey().toString();
                Integer value = (Integer) entry.getValue();
                out.println(key + " " + value); //Prints to Output.txt for your viewing pleasure.
                System.out.println(key + " " + value); //Standard output if you enjoy eyestrain?
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