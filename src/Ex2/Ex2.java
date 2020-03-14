package Ex2;

import java.io.*;
import java.util.Scanner;

/**
 * Project: TemaC30
 * Author: mihai
 * Date: 3/14/2020
 */
public class Ex2 {
    public static void writeInFile(String numberString, String file)throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write(numberString);
        }
    }


    public static void writeInFile(int[] intNumbers, String file) throws IOException{
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < intNumbers.length; i++){
                sb.append(intNumbers[i]);

                // No whitespace after last element
                if (i < intNumbers.length - 1){
                    sb.append(" ");
                }
            }

            bufferedWriter.write(sb.toString());
        }
    }


    public static String readFromFile(String file)throws IOException{
        String nextLine = "";
        try (Scanner scanner =  new Scanner(new BufferedReader(new FileReader(file)))){
            while (scanner.hasNextLine()){
                nextLine = scanner.nextLine();
            }
        }
        return nextLine;
    }


    public static int[] bubbleSort(int[] intNumbers){
        boolean isSwapped;

        for (int i = 0; i < intNumbers.length; i++){
            isSwapped = false;
            for (int j = 0; j < intNumbers.length - 1 - i; j++){
                if (intNumbers[j] > intNumbers[j + 1]){
                    isSwapped = true;
                    int aux = intNumbers[j];
                    intNumbers[j] = intNumbers[j + 1];
                    intNumbers[j + 1] = aux;
                }
            }

            if (!isSwapped){
                break;
            }
        }
        return intNumbers;
    }


    public static int[] convertAndParse(StringBuilder sb){
        String[] numbers = sb.toString().split(" ");
        int[] intNumbers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++){
            intNumbers[i] = Integer.parseInt(numbers[i]); // .toTrim();
        }

        System.out.println("Integer values: ");
        display(intNumbers);

        return intNumbers;
    }


    public static void display(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        String numbers1String = "1 18 40 100";
        String numbers2String = "0 10 15 80 1001";
        String file1 = "Numbers1.txt";
        String file2 = "Numbers2.txt";
        String fileToMerge = "NumbersMerge.txt";

        // Write numbers1String in 'Numbers1.txt'
        writeInFile(numbers1String, file1);

        // Write numbers2String in 'Numbers2.txt'
        writeInFile(numbers2String, file2);

        // Read from file
        String readFile1 = readFromFile(file1);
        System.out.println("File1: " + readFile1);
        String readFile2 = readFromFile(file2);
        System.out.println("File2: " + readFile2);

        // Append -->
        StringBuilder sb = new StringBuilder();
        sb.append(readFile1).append(" ").append(readFile2);
        System.out.println("StringBuilder:\n" + sb.toString());

        // Convert to int & Parse --> Sort
        int[] intNumbers = bubbleSort(convertAndParse(sb));

        System.out.println("\nOutput: ");
        display(intNumbers);

        // Write in file 'NumbersMerge.txt'
        writeInFile(intNumbers, fileToMerge);
    }
}
