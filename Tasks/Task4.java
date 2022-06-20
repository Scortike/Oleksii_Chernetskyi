package Tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Task4 
{
    public static Integer countNumberOfPairs(Integer[] array, Integer target)
    {
        Integer numberOfPairs = 0;
        HashMap<Integer, Integer> amountOfNum = new HashMap<Integer, Integer>();
        for(Integer tempNum : array)
        {
            if(!amountOfNum.containsKey(tempNum))
            {
                amountOfNum.put(tempNum, 1);
            }
            else
            {
                amountOfNum.put(tempNum, amountOfNum.get(tempNum)+1);
            }
        }
        for(Integer tempNum : array)
        {
            if(amountOfNum.get(target - tempNum) != null)
            {
                numberOfPairs += amountOfNum.get(target - tempNum);
            }
            if(target - tempNum == tempNum)
            {
                numberOfPairs--;
            }
        }
        return numberOfPairs/2;
    }

    public static Integer countNumberOfPairsUsingStream(Integer[] array, Integer target)
    {
        return Math.toIntExact(
            IntStream.range(0, array.length)
                .mapToLong(i -> IntStream.range(i+1, array.length)
                    .filter(j-> array[i] + array[j] == target)
                    .count())
                .sum());
    }

    public static void main(String[] args) 
    {
        System.out.println(countNumberOfPairs(new Integer[]{1, 3, 6, 2, 2, 0, 4, 5, 3}, 6));
        System.out.println(countNumberOfPairsUsingStream(new Integer[]{1, 3, 6, 2, 2, 0, 4, 5, 3}, 6));
    }
}
