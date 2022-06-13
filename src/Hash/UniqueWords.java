package Hash;
/*
Finding unique words in a string
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueWords {

    public static List<String> findUniqueWords(String string){
        Map<String, Integer> map = new HashMap<>();
        for(String word : string.split(" ")){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }
        return map.entrySet().stream().filter(entry -> entry.getValue()==1).map(entry -> entry.getKey()).collect(Collectors.toList());
    }

    public static void main(String []args){
    }
}
