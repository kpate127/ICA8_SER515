/**
* @author : Kunal Jitendra Patel
* Asurite ID : kpate127
* ASU ID : 1225326674
 */
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
//        if (goodString(input)) {
//            char[] charArray = input.toCharArray();
//            System.out.println("Number of free urinals: " + backtrack(charArray, 0, 0));
//        } else {
//            System.out.println("Number of free urinals: " + -1);
//        }
        return input;
    }

    public static void fileInput(String s) throws IllegalArgumentException, FileNotFoundException {


            File file = new File(s);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
//                if (goodString(input)) {
//                    char[] charArray = input.toCharArray();
//                    System.out.println(input);
//                    System.out.println("Number of free urinals: " + backtrack(charArray, 0, 0));
//                } else {
//                    System.out.println(input);
//                    System.out.println("Number of free urinals: " + -1);
//                }

                if(input.equals("EOF"))break;
            }
            sc.close();
    }

    public static boolean emptyFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resources/urinal.dat"));
        if(br.readLine() == null) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" Select 1) Keyboard Input 2) File Input");
        String str = br.readLine();

        if (str.equals("1")) {
            String input = keyboardInput();
        } else if (str.equals("1")) {
            String address = "src/resources/urinal.dat";
            fileInput(address);
        }
    }
}
//            System.out.println("Enter the string: ");
//            String input = br.readLine();
//            if(goodString(input)) {
//                char[] charArray = input.toCharArray();
//                System.out.println("Number of free urinals: " + backtrack(charArray, 0, 0));
//            } else{
//                System.out.println("Number of free urinals: " + -1);
//            }
//        else if(str.equals("2")) {
//            try {
//                File file = new File("src/resources/urinal.dat");
//                Scanner sc = new Scanner(file);
//                while (sc.hasNextLine()) {
//                    String input = sc.nextLine();
//                    if(goodString(input)) {
//                        char[] charArray = input.toCharArray();
//                        System.out.println(input);
//                        System.out.println("Number of free urinals: " + backtrack(charArray, 0, 0));
//                    } else{
//                        System.out.println(input);
//                        System.out.println("Number of free urinals: " + -1);
//                    }
//                }
//                sc.close();
//            } catch (FileNotFoundException e) {
//                System.out.println("An error occurred.");
//                e.printStackTrace();
//            }

