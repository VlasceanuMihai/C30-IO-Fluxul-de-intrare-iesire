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
public class Ex1_1 {
    public static void convert(String oldWord, String newWord)throws IOException {
        String nextLine = "";
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("TextInput.txt")));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("TextOutput.txt"))){
            while (scanner.hasNextLine()){
                nextLine = scanner.nextLine().replace(oldWord, newWord);
                bufferedWriter.write(nextLine);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Old word: ");
        String oldWord = scanner.next();
        System.out.print("New word: ");
        String newWord = scanner.next();

        // Read from file 'TextInput.txt' --> Replace key word --> Write in file 'TextOutput.txt'
        convert(oldWord, newWord);
    }
}
