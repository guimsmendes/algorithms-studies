package Array;

import java.util.ArrayList;
import java.util.List;

/*
Write algorithm for java grep command for word matching in the following context.Given a file containing n words.Given a word w and a number k.Find k words in the file occuring before occurence of w.Assume that the average word size is m in the file
eg.
aaa
bbb
ccc
booking
alpha
beta
gamma

for k=3 and w = booking
the output should be [aaa,bbb,ccc,booking]
similarly for k =2 and w = beta
output should be [booking,alpha,beta]
Assume that the file size can grow very large
and try to get solution with space complexity lesser than O(n)

I suggessted solution for iterating through file until the word w is found and maintaiining a queue of size K
The time complexity of my solution was O(nm)
and space complexity was O(k) .Any answers to improve the time and space complexity
Apparently they were looking for a better implementation of grep
 */
public class Grep {

    public static void printCapped(List<String> words, String w, Integer k){
        List<String> cappedList = new ArrayList<String>(k);

        for(int i = 0; i<words.size(); i++){
            String word = words.get(i);
            if (cappedList.size() >= k+1) cappedList.remove(0);
            cappedList.add(word);
            if (word.equals(w))break;
        }

        System.out.println(cappedList);

    }
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("booking");
        printCapped(list, "booking", 1);
    }
}
