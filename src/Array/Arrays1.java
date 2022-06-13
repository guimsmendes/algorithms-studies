package Array;

import java.util.*;
/*
Given an array of integers A and multiple values in B around which left rotation of the array A needs to be performed.

Find the rotated array for each value and return the result in the from of a matrix where i’th row represents the rotated

array for the i’th value in B.
 */

public class Arrays1 {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> response = new ArrayList<>();
        int n = A.size();
        for (Integer rotation : B) {
            rotation = rotation%n;
            ArrayList<Integer> leftArray = new ArrayList<>();
            int arr[] = new int[n];
            for (int i = 0; i<n; i++){
                arr[(i+n-rotation)%n] = A.get(i);
            }
            for (int j = 0; j<n;j++) {
                leftArray.add(arr[j]);
            }
            response.add(leftArray);
        }

        return response;
    }
}
