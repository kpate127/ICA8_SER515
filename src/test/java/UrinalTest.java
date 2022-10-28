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
        String str2 = "101010";
        urinals U = new urinals();
        assertEquals(false, U.emptyString(str2));
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
        urinals U = new urinals();
        assertEquals(1, U.countAvailableUrinals(str1.toCharArray()));
        assertEquals(0, U.countAvailableUrinals(str2.toCharArray()));
        assertEquals(3, U.countAvailableUrinals(str3.toCharArray()));
        assertEquals(2, U.countAvailableUrinals(str4.toCharArray()));
        assertEquals(1, U.countAvailableUrinals(str5.toCharArray()));
        assertEquals(-1, U.countAvailableUrinals(str6.toCharArray()));
        System.out.println("====== KUNAL JITENDRA PATEL == TEST THREE EXECUTED =======");
    }



}
