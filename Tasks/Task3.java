package Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 
{
    public static Integer digitalRoot(Integer number)
    {
        Integer tempNum, tempSum = 0;
        List<String> separatedNumber = new ArrayList<String>(Arrays.asList(number.toString().split("")));
        for(String i: separatedNumber)
        {
            tempNum = Integer.parseInt(i);
            tempSum += tempNum;
        }
        number = tempSum;
        if(number < 10)
        {
            return number;
        }
        else
        {
            return digitalRoot(number);
        }
    }

    public static void main(String[] args) 
    {
        System.out.println(digitalRoot(493193));
    }
}
