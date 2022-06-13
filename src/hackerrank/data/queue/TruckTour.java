package hackerrank.data.queue;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class TruckTour {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        Stack<Integer> plants = new Stack<>();


        for(int index= 0; index<petrolpumps.size(); index++){

            int i = index;
            int total = 0;
            if (petrolpumps.get(index).get(0) > petrolpumps.get(index).get(1)) {
                for (; i < petrolpumps.size() + index - 1; i++) {
                    if (i >= petrolpumps.size()) {
                        total += petrolpumps.get(i % petrolpumps.size()).get(0);
                        total -= petrolpumps.get(i % petrolpumps.size()).get(1);

                    } else {
                        total += petrolpumps.get(i).get(0);
                        total -= petrolpumps.get(i).get(1);
                    }
                    if (total < 0) break;
                }
            }
            if (i == index + petrolpumps.size() - 1) {
                return index;
            }

        }
        return 0;
    }

    public static int trackTourByQueue(List<List<Integer>> petrolpumps){
        Queue<List<Integer>> queue = new LinkedList<>();
        for (List<Integer> petrolpump : petrolpumps) {
            queue.add(petrolpump);
        }
        int gas = 0;
        int position = 0;
        while(!queue.isEmpty()) {
            List<Integer> station = queue.peek();
            gas += station.get(0);
            gas -= station.get(1);
            queue.poll();

            if(gas < 0) {
                queue.add(station);
                gas = 0;
                position++;
            }
        }
        return position;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
