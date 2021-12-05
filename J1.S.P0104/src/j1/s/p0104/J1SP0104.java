import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class J1SP0104 {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Set<String> hs = new HashSet<String>();
        BufferedReader br = null;
        System.out.print("Please enter directory or file: ");
        
        while (true) {
            String fileName = in.nextLine().trim();
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                break;
            } catch (FileNotFoundException e) {
                System.out.print("Enter again: ");
            }
        }
        String line;
        System.out.print("Please enter string to search: ");
        String keyword;
        while (true) {            
            keyword = in.nextLine().trim();
            if (!keyword.isEmpty()) break;
            else System.out.print("Enter again: ");
        }
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (words[i].toLowerCase().contains(keyword.toLowerCase())) {
                    hs.add(words[i]);
                }
            }
        }
        if (hs.size() == 0) {
            System.out.println("Don't have any word contain keyword!");
        } else {
            System.out.println("Found " + hs.size() + " words!");
            for (String w : hs) {
                System.out.println(w);
            }
        }
        System.out.println();
    }
}