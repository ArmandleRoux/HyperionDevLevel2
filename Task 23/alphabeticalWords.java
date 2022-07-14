import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class alphabeticalWords {

  public static void main(String[] args) {
    List<String> wordsList = new ArrayList<String>();

    // Read through file with scanner and add words to list.
    try {
      File wordFile = new File("randomWords");
      System.out.println(wordFile.getAbsolutePath());
      Scanner wordScanner = new Scanner(wordFile);
      while (wordScanner.hasNextLine()){
        String word = wordScanner.nextLine();
        wordsList.add(word);
      }
      wordScanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
    // Sort in alphabetical order and print to console.
    Collections.sort(wordsList);
    for (String word : wordsList) {
      System.out.println(word);
    }
  }

}
