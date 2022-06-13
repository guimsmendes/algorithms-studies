package Array;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
the 2-sum problem
 */
public class TwoSum {
    public static void sum(List<Integer> list, Integer value){
        List<Integer> newList = list.stream().sorted(Integer::compare).collect(Collectors.toList());
        Set<String> response = new HashSet<>();
        int i = 0;
        int j = i-1;
        int temp;
        while(i<list.size()/2){
            temp = newList.get(i) + newList.get(list.size()-j);
            if(temp==value) {
                response.add(list.indexOf(newList.get(i)) + "," + list.indexOf(newList.get(j)));
            } else if(temp<value){
                i++;
            } else {
                j--;
            }
        }
        System.out.println(response.toString());
    }

}
