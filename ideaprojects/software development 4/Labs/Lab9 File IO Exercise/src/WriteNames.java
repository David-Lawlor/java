import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DL on 18/03/2015.
 * Going on half 3 and I'm doing a lab. Some interesting stuff on Arraylists learned tonight
 * like addAll() and using the split string method. definitely come in handy for the project
 */
public class WriteNames {

    public static ArrayList<String> readFile(){
        File input = new File("Software Development 4/Labs/Lab9 File IO Exercise/res/names.txt");
        ArrayList<String> names = new ArrayList<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(input))){
            String s;
            while ((s = bf.readLine()) != null){
                names.add(s);
            }

        }catch(IOException ex){
            System.out.println("Error reading from file");
        }

        return names;
    }

    public static void runOne(){
        ArrayList<String> s = readFile();
        File output = new File("Software Development 4/Labs/Lab9 File IO Exercise/res/optOne.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(output))){
            for (String x: s){
                bw.write(x);
                bw.newLine();
            }
        }catch (IOException ex){
            System.out.println("Error outputting to file");
        }
    }

    public static void runTwo(){
        ArrayList<String> names = readFile();
        int counter = 0;

        File output = new File("Software Development 4/Labs/Lab9 File IO Exercise/res/optTwo.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(output))){
            while (counter < names.size()){
                bw.write(names.get(counter));
                bw.newLine();
                counter+=2;
            }
        }catch (IOException ex){
            System.out.println("Error outputting to file");
        }
    }

    public static void runThree(){
        ArrayList<String> names = readFile();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the name");
        String name = in.nextLine();

        File output = new File("Software Development 4/Labs/Lab9 File IO Exercise/res/optThree.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(output))){
            for (String x: names) {
                if(x.equals(name)){
                    bw.write(name);
                    break;
                }
                System.out.println("1");
            }
        }catch (IOException ex){
            System.out.println("Error outputting to file");
        }
    }

    public static void runFour(){
        ArrayList<String> names = readFile();

        //Read name in from the user
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the name");
        String name = in.next();

        // made arraylist to hold all of the split parts of the array
        ArrayList<String> searchArray = new ArrayList<>();

        //must initialise arraylist. can initialise with asList() below but becomes a fixed size

        //split names into another arraylist containing first and last names separated
        for (String x: names) {
            String[] parts = x.split(" ");
            searchArray.addAll(Arrays.asList(parts));
        }

        //for outputting the results to the file optFour.txt
        File output = new File("Software Development 4/Labs/Lab9 File IO Exercise/res/optFour.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(output))){

            // Loop for searching the Arraylist of names
            int index = 0;
            for (int i = 0; i < searchArray.size(); i++) {
                if(searchArray.get(i).equals(name)){
                    index = i;// find the index of the matching name
                    break;
                }
            }
            // if index is odd then I have the second name
            if(index%2 ==1)
                bw.write(searchArray.get(index -1) +" "+ searchArray.get(index));

            // if index is even then I have the first name
            else
                bw.write(searchArray.get(index) +" "+ searchArray.get(index + 1));

        }catch (IOException ex){
            System.out.println("Error outputting to file");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;

        System.out.println("Please select an option 1,2,3, or 4");
        option = in.nextInt();
        switch (option){
            case 1:
                runOne();
                break;
            case 2:
                runTwo();
                break;
            case 3:
                runThree();
                break;
            case 4:
                runFour();
                break;
            default:
                System.out.println("You have not entered a valid option");
        }
        System.out.println("Program ends");
    }
}
