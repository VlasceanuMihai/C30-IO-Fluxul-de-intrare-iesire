package Ex3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Project: TemaC30
 * Author: mihai
 * Date: 3/14/2020
 */
public class Ex3 {
    private static Scanner scanner = new Scanner(System.in);


    // The shortest word
    public static String shortestWord(List<String> list){
        Deque<String> deque = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;

        for (String word : list){
            if (word.length() < min){
                min = word.length();
                deque.addFirst(word);
            }
        }
        System.out.println("The shortest word: " + deque);
        return deque.getFirst();
    }


    // The longest word
    public static String longestWord(List<String> list){
        Deque<String> deque = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        for (String word : list){
            if (word.length() > max){
                max = word.length();
                deque.addFirst(word);
            }
        }
        System.out.println("The longest word: " + deque);
        return deque.getFirst();
    }


    // The first word in alphabetical order
    public static String firstWordAlphabetical(List<String> list){
        Collections.sort(list);
        Deque<String> deque = new LinkedList<>(list);

        System.out.println("The first word in alphabetical order: " + deque);
        return deque.getFirst();
    }


    // The last word in alphabetical order
    public static String lastWordAlphabetical(List<String> list){
        list.sort(Collections.reverseOrder());
        Deque<String> deque = new LinkedList<>(list);

        System.out.println("The last word in alphabetical order: " + deque);
        return deque.getFirst();
    }


    // Total number of words
    public static int numberOfWords(List<String> list){
        return list.size();
    }


    public static void writeInFile(String file, String shortestWord, String longestWord, String firstWordAlphabeticalOrder,
                                   String lastWordAlphabeticalOrder, int numberOfWords) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write("Shortest word: " + shortestWord + "\n");
            bufferedWriter.write("Longest word: " + longestWord + "\n");
            bufferedWriter.write("First word in alphabetical order: " + firstWordAlphabeticalOrder + "\n");
            bufferedWriter.write("Last word in alphabetical order: " + lastWordAlphabeticalOrder + "\n");
            bufferedWriter.write("Total number of words: " + numberOfWords);
        }
    }




    public static void main(String[] args) throws IOException {
        String file = "result.txt";
        String jsonFile = "jsonFile.json";
        List<String> list = new ArrayList<>();

        System.out.println("Words:");
        String word = scanner.next();
        while (!word.equalsIgnoreCase("quit")){
            list.add(word);
            word = scanner.next();
        }

        System.out.println(list);

        // The shortest word
        String shortestWord = shortestWord(list);
        System.out.println(shortestWord);

        // The shortest word
        String longestWord = longestWord(list);
        System.out.println(longestWord);

        // The first word in alphabetical order
        String firstWordAlphabeticalOrder = firstWordAlphabetical(list);
        System.out.println(firstWordAlphabeticalOrder);

        // The last word in alphabetical order
        String lastWordAlphabeticalOrder = lastWordAlphabetical(list);
        System.out.println(lastWordAlphabeticalOrder);

        // Total number of words
        int numberOfWords = numberOfWords(list);
        System.out.println(numberOfWords);

        // Write in File 'result.txt'
        writeInFile(file, shortestWord, longestWord, firstWordAlphabeticalOrder, lastWordAlphabeticalOrder, numberOfWords);

        createJson(jsonFile, shortestWord, longestWord, firstWordAlphabeticalOrder, lastWordAlphabeticalOrder, numberOfWords);
    }



    public static void createJson(String file, String shortestWord, String longestWord, String firstWordAlphabeticalOrder,
                                  String lastWordAlphabeticalOrder, int numberOfWords) throws IOException{
        JSONObject obj = new JSONObject();
        obj.put("Shortest word", shortestWord);
        obj.put("Longest word", longestWord);
        obj.put("First word in alphabetical order", firstWordAlphabeticalOrder);
        obj.put("Last word in alphabetical order", lastWordAlphabeticalOrder);
        obj.put("Total number of words", numberOfWords);

        try (FileWriter bufferedWriter = (new FileWriter(file))){
            bufferedWriter.write(arrangeJson(obj.toString()));
        }
    }

    public static String arrangeJson(String jsonObject) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(jsonObject);
        return gson.toJson(je);
    }



    // Bubble Sort
    public static void bubbleSort(String[] array){
        boolean isSwapped;
        for (int i = 0; i < array.length; i++){
            isSwapped = false;
            for (int j = 0; j < array.length - 1 - i; j++){
                if (array[j].compareTo(array[j + 1]) > 0){
                    isSwapped = true;
                    String aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }

            if (!isSwapped){
                break;
            }
        }
    }
}
