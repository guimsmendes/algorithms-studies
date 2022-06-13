package Hash;

import java.util.*;

/*
Consider a hotel where the guest is checked in and check out. Find a day when the maximum number of guests stay in a hotel.

example:

Input :
[
{check-in : 1, check-out 4},
{check-in : 2, check-out 5},
{check-in : 10, check-out 12},
{check-in : 5, check-out 9},
{check-in : 5, check-out 12}
]

Output : 5
 */
public class CheckInCheckOut {

    public int maxDays(List<Schedule> schedules) {

        Map<Integer, Integer> dayCount = new HashMap<>();

        for(Schedule schedule : schedules){
            for(int i = schedule.checkin; i<= schedule.checkout;i++){
                dayCount.putIfAbsent(i,0);
                dayCount.put(i,dayCount.get(i)+1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(dayCount.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return list.get(0).getValue();
    }
}

class Schedule {
    public int checkin;
    public int checkout;
}
