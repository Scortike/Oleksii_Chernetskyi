package Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1
{
    public static ArrayList<Integer> getIntegersFromList (List<Object> argList)
    {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for(Object i: argList)
        {
            if(i instanceof Integer)
            {
                intList.add((Integer)i);
            }
        }
        return intList;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> intList = getIntegersFromList(Arrays.asList(1,2,'a','b',"as",'1',"123"));
        System.out.println(intList);
    }
}