package hackerrank.data;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetInterview {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int longestConsecutive(final List<Integer> A) {
        Set<Integer> set = new TreeSet<>();
        for (Integer value : A) {
            set.add(value);
        }
        int max = 0;
        int count = 1;
        int temp=-1;
        for (Integer valueSet : set){

            if ((valueSet-temp) == 1){
                count++;
            } else {
                if (count > max) max = count;
                count = 1;
            }
            temp = valueSet;
        }
        if (count > max) max = count;
        return max;
    }

    public static void main(String[] args){
        System.out.println(longestConsecutive(List.of(6, 4, 5, 2, 3)));
    }
}