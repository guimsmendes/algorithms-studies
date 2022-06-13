package hackerrank.sorting;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class FraudulentActivity {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {

        // Write your code here
        int count = 0;
        // quickSort(expenditure, 0, d-1);
        // if (isGreaterThanMedian(expenditure, d)) count++;
        for(int i = 0; i<expenditure.size()-d; i++){
            quickSort(expenditure, i, i+d-1);
            if (isGreaterThanMedian(expenditure, i, i+d)) count++;
        }

        return count;

    }

    static boolean isGreaterThanMedian(List<Integer> expenditure, int start, int end) {
        double median;
        int index = (start+end)/2;
        if ((start+end)%2==0) {
            median = (expenditure.get(index).doubleValue() + expenditure.get(index-1).doubleValue())/2;
        } else {
            median = expenditure.get(index);
        }
        return expenditure.get(end) >= (2*median);

    }

    static void quickSort(List<Integer> arr, int start, int end) {
        if (start<end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1, end);
        }
    }

    static int partition(List<Integer> arr, int start, int end) {

        int pivot = arr.get(end);
        int i = start -1;

        for(int j = start; j<end; j++){
            if(arr.get(j) <= pivot){
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(i+1);
        arr.set(i+1, arr.get(end));
        arr.set(end, temp);

        return i+1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = activityNotifications(expenditure, d);


        bufferedReader.close();
    }
}
