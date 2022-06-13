package DP;

import java.util.ArrayList;
/*

GIven three prime numbers A, B and C and an integer D.
You need to find the first(smallest) D integers which only have A, B, C or a combination of them as their prime factors.

Return an array of size D denoting the first smallest D integers which only have A, B, C or a combination of them as their prime factors.

NOTE: You need to return the array sorted in ascending order.

 */

public class DP {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {

        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        int x= 0,y=0,z = 0;
        int temp = 0;
        while(array.size()<=D){
            temp = Math.min(A*array.get(x), B*array.get(y));
            temp = Math.min(temp, C*array.get(z));
            array.add(temp);
            if (temp == A*array.get(x)) x++;
            if (temp == B*array.get(y)) y++;
            if (temp == C*array.get(z)) z++;
        }
        array.remove(0);
        array.stream().sorted((a,b) -> Integer.compare(a,b));
        return array;
    }

}

