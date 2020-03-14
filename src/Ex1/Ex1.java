package Ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Project: TemaC30
 * Author: mihai
 * Date: 3/14/2020
 */
public class Ex1 {
    public static String readFromFile()throws IOException {
        List<String> list = new ArrayList<>();
        StringBuilder nextLine = new StringBuilder();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("TextInput.txt")))){
            while (scanner.hasNextLine()){
                nextLine.append(scanner.nextLine());
            }
        }
        System.out.println(nextLine.toString());
        return nextLine.toString();
    }


    public static void writeInFile(String newText) throws IOException{
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("TextInput.txt"))){
            bufferedWriter.write(newText);
        }
    }



    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Old word: ");
        String oldWord = scanner.next();
        System.out.print("New word: ");
        String newWord = scanner.next();

        String newText = readFromFile().replace(oldWord, newWord);

        // Final String
        System.out.println(newText);

        writeInFile(newText);
    }
}
