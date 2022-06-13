package Hash;

import java.util.*;
import java.util.stream.Collectors;

/*
Given arrays for N (>= 2) users, each representing the IDs of hotels visited, find the common IDs of the hotels visited amongst the users.

Input:
userA = { 2, 3, 1 }
userB = { 2, 5, 3 }
userC = { 7, 3, 1 }

Output:
{3}

Assumptions:
Arrays are unsorted.

Cases:
1) Each array consists of distinct hotel IDs
2) Each array may contain duplicate hotel IDs
 */
public class HotelsVisited {
    public List<Integer> commonIds(ArrayList<ArrayList<Integer>> input){

        int numberUsers = input.size();
        List<Set<Integer>> setList = input.stream().map(user -> {
            Set<Integer> set = new HashSet<>();
            set.addAll(user);
            return set;
        }).collect(Collectors.toList());

        Map<Integer, Integer> countMap = new HashMap<>();
        for(Set<Integer> set : setList) {
            for (Integer value : set){
                if(!countMap.keySet().contains(value)) {
                    countMap.put(value, 1);
                } else {
                    countMap.put(value, countMap.get(value)+1);
                }
            }
        }
        var response = countMap.entrySet().stream()
                .filter((entry) -> entry.getValue() == numberUsers )
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return response;

    }
}
