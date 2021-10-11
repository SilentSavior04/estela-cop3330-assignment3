package ex42;

import java.util.*;
import java.io.*;

public class ParsingData {

        public void printDetails(String filename) {
            try {
                File file = new File(filename);
                Scanner sc = new Scanner(file);

                while (sc.hasNext()) {
                    String s = sc.nextLine();
                    String[] temp = s.split(",");
                    System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]);
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Error: File Not Found!!");
            }
        }

        public static void main(String[] args) {

            ParsingData emp = new ParsingData();
            System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary");
            System.out.println("----------------------------------------");
            emp.printDetails("exercise42_input.txt");
        }
    }
