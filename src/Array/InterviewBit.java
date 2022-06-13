package Array;

import java.util.ArrayList;

public class InterviewBit {
    public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {


            int max = (A * 2) - 1;
            int arr[][] = new int[max][max];

            for(int i = 0; i<= max/2; i++){
                for (int j = 0; j<=max/2;j++){
                    if(j>=i){
                        arr[i][j]=A-i;
                        arr[max-i-1][j] = A-i;
                        arr[i][j+i] =  A-i;
                        arr[i][max-j-1] = A-i;
                        arr[max-i-1][j+i] =  A-i;
                        arr[max-i-1][max-j-1] = A-i;
                    } else {
                        arr[i][j] = A-j;
                        arr[i][max-j-1] = A-j;
                        arr[max-i-1][j] =  A-j;
                        arr[max-i-1][max-j-1] = A-j;
                    }
                }
            }
            ArrayList<ArrayList<Integer>> array = new ArrayList<>();
            for(int i[] : arr){
                ArrayList<Integer> arrayInt = new ArrayList<>();
                for(int value : i) {
                    arrayInt.add(value);
                }
                array.add(arrayInt);
            }
                return array;
    }

    public static void main(String[] args){
        prettyPrint(3);
    }
}
