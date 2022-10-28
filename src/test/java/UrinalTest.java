import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;


public class UrinalTest {

    @Test
    public void checkGoodStringTest(){
        String str1 = "101010";
        urinals U = new urinals();
        assertTrue(U.goodString(str1));
        System.out.println("====== KUNAL JITENDRA PATEL == TEST ONE EXECUTED =======");
    }
    @Test
    public void checkIsEmpty(){
        String input = "101010";
        urinals U = new urinals();
        assertEquals(false, U.emptyString(input));
        System.out.println("====== KUNAL JITENDRA PATEL == TEST TWO EXECUTED =======");
    }

    @Test
    public void checkCountOfAvailableUrinalsTest(){
        String str1 = "10001";
        String str2 = "1001";
        String str3 = "00000";
        String str4 = "0000";
        String str5 = "01000";
        String str6 = "011";
        //urinals U = new urinals();
        assertEquals(1, urinals.backtrack(str1.toCharArray(),0,0));
        assertEquals(0, urinals.backtrack(str2.toCharArray(),0,0));
        assertEquals(3, urinals.backtrack(str3.toCharArray(),0,0));
        assertEquals(2, urinals.backtrack(str4.toCharArray(),0,0));
        assertEquals(1, urinals.backtrack(str5.toCharArray(),0,0));
        assertEquals(-1, urinals.backtrack(str6.toCharArray(),0,0));
        System.out.println("====== KUNAL JITENDRA PATEL == TEST THREE EXECUTED =======");
    }

    @Test
    public void checkFileNotFountTest(){
        String address = "src/resources/urinal.dat1";
        assertThrows(FileNotFoundException.class, () -> {
            urinals.fileInput(address);
        });
        System.out.println("====== KUNAL JITENDRA PATEL == TEST FOUR EXECUTED =======");
    }

    @Test
    public void checkFileFoundTest(){
        String address = "src/resources/urinal.dat";

        assertDoesNotThrow( () -> {
            urinals.fileInput(address);
        });
        System.out.println("====== KUNAL JITENDRA PATEL == TEST FIVE EXECUTED =======");

    }

}
