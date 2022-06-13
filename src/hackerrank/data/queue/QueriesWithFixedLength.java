package hackerrank.data.queue;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class QueriesWithFixedLength {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
        List<Integer> response = new ArrayList<>();

        for (Integer query : queries) {
            List<Integer> listMax = new ArrayList<>();
            for (int i = 0; i<=(arr.size()-query); i++) {
                int max = -1;
                for(int j = i; j<i+query; j++){
                    if (arr.get(j)>max) {
                        max = arr.get(j);
                    }
                }
                listMax.add(max);
            }
            int min = Integer.MAX_VALUE;
            for(Integer maximum : listMax) {
                if (maximum < min){ min = maximum;}

            }
            response.add(min);
        }
        return response;
        // Write your code here

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = solve(arr, queries);



        bufferedReader.close();
    }
}
