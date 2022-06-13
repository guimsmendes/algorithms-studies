package String;
/*
Swap two digits from an integer, the result should be the maximum. For example 3580 -> 8350
 - Integer to String. For each char, swap 2. If is bigger than default, set default by the number using parseInt
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SwapDigits {

    public static int swap(Integer a){
        String number = a.toString();
        List<Integer> array = new ArrayList<Integer>();
        for (String digit : number.split("")){
            array.add(Integer.parseInt(digit));
        }
        array.sort(Comparator.reverseOrder());
        StringBuilder max = new StringBuilder();
        for(Integer num : array){
            max.append(num + "");
        }
        return Integer.parseInt(max.toString());
    }

    public static void main(String []args){
       System.out.println( swap(3580));
    }

}
