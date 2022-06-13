package Array;

import java.util.*;

public class Amazon1 {

    public static void main(String... args) {
        countFamilyLogins(List.of("corz", "horn", "dpso", "eqtp", "corn"));

    }

    public static int countFamilyLogins(List<String> logins) {
        Set<String> unsetLogins = new HashSet<String>();
        int count = 0;
        for(String login : logins) {
            unsetLogins.add(login);
            for(String unsetLogin : unsetLogins) {
                if(unsetLogin.equals(change(login)) || login.equals(change(unsetLogin))){
                    count++;
                }
            }
        }
        return count;
    }

    public static String change(String login){
        Integer prP[] = (Integer[]) new ArrayList<Integer>().toArray();
        var a = prP.length ;
        StringBuilder response = new StringBuilder();
        Arrays.stream(login.split("")).forEach(ch -> {
            if(ch.equals("z")) {
                response.append("a");
            } else {
                response.append(Character.valueOf((char) (ch.charAt(0) + 1)));
            }
        });
        return response.toString();
    }
}
