/* SELF ASSESSMENT

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: My method definition is correct.
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: My method reads the words from words.txt.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: My method returns the contents of the file in an ArrayList.

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: My method definition is correct.
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: My method reads each, saves them to an ArrayList and returns the ArrayList.

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: My method definition is correct.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: My method compares each word with every other word.
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: My method returns false if a non-unique word is found.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: My method returns true if all the words are unique and false otherwise.

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: My method definition is correct.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: My method uses the binarySearch method.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: My method returns true if the binarySearch method returns a value >= 0, otherwise it returns false.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: My method definition is correct.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: My method compares two words and returns true only if they are the same length and have only one different letter in the same position.

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: My method definition is correct.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: My method calls isUniqueList, isEnglishWord and isDifferentByOne and displays the correct message.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: My main program reads all the words from the file to an ArrayList.
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: My program asks the user for input and calls isWordChain.s

 Total Mark out of 100 (Add all the previous marks):
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordLinks {
    public static void main(String[] args) {
        ArrayList<String> englishWords = readDictionary();
        askForInput(englishWords);
    }
    public static void askForInput(ArrayList<String> englishWords)
    {
        System.out.println("Enter a comma separated list of words (or an empty list to quit):");
        Scanner inputScanner = new Scanner(System.in);
        String wordChain = inputScanner.nextLine();
        ArrayList<String> wordList = readWordList(wordChain);
        if(isWordChain(wordList, englishWords))
        {
            System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
            askForInput(englishWords);
        }
        else if(wordChain.length() == 0)
        {
            System.out.println("Thank you for playing.");
        }
        else
        {
            System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
            askForInput(englishWords);
        }
    }

    public static ArrayList<String> readDictionary()
    {
        ArrayList<String> data = new ArrayList<>();
        File myFile = new File("words.txt");
        try {
            FileReader fr = new FileReader(myFile);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s=br.readLine())!=null)
            {
                data.add(s);
            }

            br.close();
            fr.close();
        }
        catch ( Exception FileNotFoundException)
        {
            System.out.println("The file does not exist.");
        }
        return data;
    }


    public static ArrayList<String> readWordList(String wordList) {
        String[] wordArray = wordList.split(",\\s*");
        ArrayList<String> wordArrayList = new ArrayList<>();
        for(int index = 0; index < wordArray.length; index++)
        {
            wordArrayList.add(wordArray[index]);
        }
        return wordArrayList;
    }

    public static boolean isUniqueList(ArrayList<String> wordArrayList) {
        for (int index = 0; index < wordArrayList.size(); index++) {
            for (int otherIndex = 0; otherIndex < wordArrayList.size(); otherIndex++) {
                if (index != otherIndex && wordArrayList.get(index).equals(wordArrayList.get(otherIndex))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEnglishWord(String word, ArrayList<String> englishWords) {
        String[] englishWordsArray = new String[englishWords.size()];
        for(int index = 0; index < englishWordsArray.length; index++)
        {
            englishWordsArray[index] = englishWords.get(index);
        }
        int wordIndex = Arrays.binarySearch(englishWordsArray, word);
        if (wordIndex >= 0) {
            return true;
        }
        return false;
    }

    public static boolean isDifferentByOne(String stringA, String stringB) {
        char[] characterArrayA = stringA.toCharArray();
        char[] characterArrayB = stringB.toCharArray();
        int differences = 0;
        if (characterArrayA.length == characterArrayB.length) {
            for (int index = 0; index < characterArrayA.length; index++) {
                if (characterArrayA[index] != characterArrayB[index]) {
                    differences++;
                }
            }
        }
        if (differences == 1) {
            return true;
        }
        return false;
    }

    public static boolean isWordChain(ArrayList<String> wordArrayList, ArrayList<String> englishWords)
    {

        if(!isUniqueList(wordArrayList))
        {
            return false;
        }
        for (int index = 0; index < wordArrayList.size(); index++)
        {
            if(!isEnglishWord(wordArrayList.get(index), englishWords))
            {
                return false;
            }
        }
        for (int index = 1; index < wordArrayList.size(); index++)
        {
            if(!isDifferentByOne(wordArrayList.get(index), wordArrayList.get(index - 1)))
            {
                return false;
            }
        }
        return true;
    }

}
