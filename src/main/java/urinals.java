/**
* @author : Kunal Jitendra Patel
* Asurite ID : kpate127
* ASU ID : 1225326674
 */
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class urinals {

    public static boolean countAvailableUrinals(char[] input) {
        int res = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '1') {
                if (((i >= 1) && (input[i - 1] == '1')) || ((i < input.length - 1) && (input[i + 1] == '1')))
                    return false;
            }
        }

        return true;
    }

    public static int backtrack(char[] input, int idx, int ans) {
        if (idx == input.length)
            return 0;
        else {
//            if(!goodString(input.toString())){
//                return -1;
//            }
            for (int i = idx; i < input.length; i++) {
                if (input[i] == '0') {
                    input[i] = '1';
                    if (countAvailableUrinals(input))
                        return backtrack(input, idx + 1, ans + 1);
                    input[i] = '0';
                }
                else if(i < input.length-1 && input[i+1] == '1') return -1;
            }
        }

        return ans;
    }

    public static boolean goodString(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '1' || input.charAt(i) == '0') {
                if (input.charAt(i) == '1' && input.charAt(i + 1) == '1') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }


    public static boolean emptyString(String string) {
        return string.length() == 0;
    }

    public static String keyboardInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string: ");
        String input = br.readLine();
        if (goodString(input)) {
            char[] charArray = input.toCharArray();
            int answer = backtrack(charArray, 0, 0);
            System.out.println("Number of free urinals: " + answer);
        } else {
            System.out.println("Number of free urinals: " + -1);
        }
        return input;
    }

    public static void fileInput(String s) throws IllegalArgumentException, IOException {


            File file = new File(s);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            Scanner sc = new Scanner(file);
            List<Integer> answers = new ArrayList<>();
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                if(input.equals("EOF")){
                    break;
                }
                if (goodString(input)) {
                    char[] charArray = input.toCharArray();
                    System.out.println(input);
                    int answer = backtrack(charArray, 0, 0);
                    answers.add(answer);
                    System.out.println("Number of free urinals: " + answer);
                } else {
                    System.out.println(input);
                    System.out.println("Number of free urinals: " + -1);
                    answers.add(-1);
                }

                if(input.equals("EOF"))break;
            }
            writeToFile(answers);
            sc.close();
    }

    public static int emptyFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resources/urinal.dat"));
        if(br.readLine() == null) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int notEmptyFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resources/urinal.dat"));
        if(br.readLine() != null) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public boolean createNewFile() throws IOException {
        File f1 = new File("src/resources/rule/rule.txt");
        boolean value = f1.createNewFile();
        return value;
    }

    public static void writeToFile(List<Integer> answers) throws IOException {
        int newFileIndex = new File("src/resources/rule").listFiles().length + 1;
        FileWriter fileWriter = new FileWriter("src/resources/rule/rule"+ newFileIndex + ".txt");
        for (int answer: answers) {
            fileWriter.write(answer + "\n");
        }
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" Select 1) Keyboard Input 2) File Input");
        String str = br.readLine();

        if (str.equals("1")) {
            String input = keyboardInput();
        } else if (str.equals("2")) {
            String address = "src/resources/urinal.dat";
            fileInput(address);
        }
    }
}


