import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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



}
