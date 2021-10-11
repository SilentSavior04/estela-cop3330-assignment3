package ex41;

import java.io.*;

import java.util.*;

    public class NameSorter {
        public static void readNames(Scanner input, ArrayList<String> names) {
            while (input.hasNextLine()) {
                names.add(input.nextLine());
            }
        }
        public static void outputNames(ArrayList<String> names) throws IOException {

            FileWriter output = new FileWriter("exercise41_intput.txt");
            output.write("Total of " + names.size() + " names\n");
            output.write("-------\n");
            for (String i : names) {
                output.write(i + "\n");
            }
            output.close();
        }
        public static void main(String[] args) throws FileNotFoundException {

            Scanner inputFile = new Scanner(new File("exercise41_input.txt"));
            ArrayList<String> names = new ArrayList<>();
            readNames(inputFile, names);
            names.sort(String.CASE_INSENSITIVE_ORDER);
            inputFile.close();
            try {
                outputNames(names);
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

