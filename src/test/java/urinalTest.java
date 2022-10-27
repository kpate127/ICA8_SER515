import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class urinalTest {

    @Test
    public void checkGoodStringTest(){
        String str1 = "101010";
        String str2 = "4522230003";
        urinals U = new urinals();
        assertTrue(U.isGoodString(str1));

    }
}
