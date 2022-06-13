package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {

    public static Map<Integer, List<Integer>> generatePascalTriangle(int size){
        Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
        result.put(0, List.of(1));
        result.put(1, List.of(1,1));

        for(int i = 2; i<=size;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            var line = result.get(i-1);

            for(int j = 0; j<line.size()-1; j++){
                temp.add(line.get(j) + line.get(j+1));
            }
            temp.add(1);
            result.put(i, temp);
        }
        return result;
    }

    public static void main(String[] args) {

        var response = generatePascalTriangle(30);
        for(int i = 0;i<response.size();i++){
            System.out.println(response.get(i));
        }

           }


}
