package Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
a variation of determining if a string is an anagram of another
 */
public class Anagram {

    public static boolean isAnagram(String a, String b){
        if (a.length() != b.length()) return false;
        AtomicInteger count = new AtomicInteger();
        Map<String, Integer> countCharA = new HashMap<>();
        Map<String, Integer> countCharB = new HashMap<>();
        for (String ch: a.split("")){
            countCharA.putIfAbsent(ch, 0);
            countCharA.put(ch, countCharA.get(ch) +1);
        }
        for (String ch: b.split("")){
            countCharB.putIfAbsent(ch, 0);
            countCharB.put(ch, countCharB.get(ch) +1);
        }

        countCharA.entrySet().stream().forEach((entry) -> {
            if (countCharB.get(entry.getKey()) == entry.getValue()) count.getAndIncrement();
        });
        return countCharA.size()==count.get();
    }

    public static void main(String[] args){
        System.out.println(isAnagram("fired", "derif"));
        System.out.println(isAnagram("banana", "bnnnna"));

    }
}
