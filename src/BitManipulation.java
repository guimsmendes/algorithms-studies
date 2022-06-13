import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
 */

public class BitManipulation {

        public int findMinXor(ArrayList<Integer> A) {
            A.sort(Comparator.comparingInt(x -> x));

            int min = Integer.MAX_VALUE;

            for (int i = 0; i<A.size()-1; i++) {

                int value = A.get(i) ^ A.get(i+1);

                if (value < min) {
                    min = value;

                }
            }
            return min;
        }


}
