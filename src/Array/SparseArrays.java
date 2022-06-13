package Array;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class SparseArrays {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> resp = new ArrayList<>();
        List<String> sortedStrings = strings.stream().sorted((x,y) -> x.compareTo(y)).collect(Collectors.toList());
        for (String a : queries){
            int count = 0;
            int index = binarySearch(sortedStrings, 0, sortedStrings.size()-1, a);
            count = 1;
            if(index<sortedStrings.size()-1){
                int i = index+1;
                while(i< sortedStrings.size() && sortedStrings.get(i).equals(a) ){
                    count++;
                    i++;
                }
            }
            if(index>0){
                int j = index-1;
                while(j > 0 && sortedStrings.get(j).equals(a)){
                    count++;
                    j--;
                }
            }
            if (index<0) {
                count = 0;
            }
            resp.add(count);

        }

        return resp;

    }

    public static int binarySearch(List<String> strings, int start, int end, String value ){
        if (start>end) {
            return -1;
        }
        int mid = (end+start)/2;
        if(strings.get(mid).equals(value)){
            return mid;
        }
        if (strings.get(mid).compareTo(value)<0){
            return binarySearch(strings, mid+1, end, value);
        }
        return binarySearch(strings, start, mid-1, value);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = matchingStrings(strings, queries);



        bufferedReader.close();
    }
}

