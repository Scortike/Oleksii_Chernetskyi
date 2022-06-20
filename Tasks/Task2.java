package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static Character firstNonRepeatingLetter(String word)
    {
        Character nonRepeatingLetter = null;
        List<String> letters = new ArrayList<String>(Arrays.asList(word.split("")));
        for (int i = 0; i < word.length(); i++)
        {
            String tempLetter = letters.remove(0);
            if(!(letters.contains(tempLetter.toLowerCase())) && !(letters.contains(tempLetter.toUpperCase())))
            {
                nonRepeatingLetter = tempLetter.charAt(0);
                return nonRepeatingLetter;
            }
        }
        return nonRepeatingLetter;
    }

    public static void main(String[] args) 
    {
        System.out.println(firstNonRepeatingLetter("stress"));
        System.out.println(firstNonRepeatingLetter("sTreSS"));
    }
}
