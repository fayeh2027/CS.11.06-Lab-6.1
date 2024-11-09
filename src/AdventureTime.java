
import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String filename = "inputOneTwo.txt";
        int challengeOneResult = challengeOne(filename);
        System.out.println(challengeOneResult);
        int challengeTwoResult = challengeTwo(filename);
        System.out.println(challengeTwoResult);
        filename="inputThreeFour.txt";
        int challengeThreeResult= challengeThree(filename);
        System.out.println(challengeThreeResult);
        int challengeFourResult= challengeFour(filename);
        System.out.println(challengeFourResult);

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int [] arrayList = readFile(fileName);
        int counter = 0;
        for (int i=0;i<arrayList.length-1;i++){
            if(arrayList[i]<arrayList[i+1]){
                counter++;
            }
        }
        return counter;
    }
    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int [] arrayList = readFile(fileName);
        int counter = 0;
        for (int i=0;i<arrayList.length-3;i++){
            int sum = arrayList[i]+arrayList[i+1]+arrayList[i+2];
            int nextsum = arrayList[i+1]+arrayList[i+2]+arrayList[i+3];
            if(sum<nextsum){
                counter++;
            }
        }
        return counter;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */

    public static int challengeThree(String fileName) throws FileNotFoundException {
        String [] arraylist = readStringFile(fileName);
        int depth = 0;
        int horizontalPosition=0;
        for (int i =0;i< arraylist.length;i++){
            String str= arraylist[i];
            String [] index = str.split(" ");
            if (index[0].equals("forward")){
                horizontalPosition +=parseInt(index[1]);
            } else if(index[0].equals("up")){
                depth -=parseInt(index[1]);
            } else if (index[0].equals("down")){
                depth +=parseInt(index[1]);
            }
        }
        return depth*horizontalPosition;
    }

    private static String[] readStringFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String [] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }


    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String [] arraylist = readStringFile(filename);
        int depth = 0;
        int horizontalPosition=0;
        int aim=0;
        for (int i =0;i< arraylist.length;i++){
            String str= arraylist[i];
            String [] index = str.split(" ");

            if (index[0].equals("forward")){
                horizontalPosition += Integer.parseInt(index[1]);
                depth += Integer.parseInt(index[1])*aim;
            } else if(index[0].equals("up")){
                aim -=Integer.parseInt(index[1]);
            } else if (index[0].equals("down")){
                aim +=Integer.parseInt(index[1]);
            }
        }
        return depth*horizontalPosition;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /**
     * This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
}
