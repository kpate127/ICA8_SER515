/**
* @author : Kunal Jitendra Patel
* Asurite ID : kpate127
* ASU ID : 1225326674
 */

public class urinals {



    public boolean isGoodString(String string)
    {
        for(int i = 0; i < string.length() - 1; i++){
            if(string.charAt(i) == '1' && string.charAt(i + 1) == '1')
            {
                return false;
            }

        }
        return true;
    }
}
