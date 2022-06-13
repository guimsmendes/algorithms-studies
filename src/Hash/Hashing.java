package Hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/*
Given are Three arrays A, B and C.

Return the sorted list of numbers that are present in atleast 2 out of the 3 arrays.
 */

public class Hashing {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        Set<Integer> aSet = new HashSet<Integer>();
        aSet.addAll(A);

        Set<Integer> bSet = new HashSet<Integer>();
        bSet.addAll(B);

        Set<Integer> cSet = new HashSet<Integer>();
        cSet.addAll(C);

        Set<Integer> resp = new HashSet<Integer>();
        for (Integer valueA : aSet){
            if(bSet.contains(valueA) || cSet.contains(valueA)) resp.add(valueA);
        }
        for(Integer valueB : bSet){
            if(cSet.contains(valueB)) resp.add(valueB);
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(resp);
        list.sort((x,y) -> Integer.compare(x, y));
        return list;

    }
}

