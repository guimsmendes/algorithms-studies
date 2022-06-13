package String;

/*
There's a very simple compression algorithm that takes subsequent characters and just emits how often they were seen.

Example:
abababaabbbaaaaa
 */

import java.util.Stack;

public class Compressed {

    public static void compress(String a){

        StringBuilder s = new StringBuilder();

        for ( int i = 0; i<a.length();i++ ){
            char temp = a.charAt(i);
            int count = 0;
            while(a.charAt(i)==temp && i<a.length()-1){
                count++;
                i++;
            }
            s.append(count+""+temp);
            if(i<a.length()-1) i--;
        }
        System.out.println(s);

    }

    public static void main(String[] args){
        compress("abababaabbbaaaaa");
    }

}
