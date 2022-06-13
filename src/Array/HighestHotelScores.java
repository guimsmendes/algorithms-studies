package Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of hotelId, parentHotelId and a score retrieve the top k root parentHotelIds with the highest scores:

[{0, 1, 10}, {1, 2, 20}, {3, 4, 10}, {7, 8, 5}] K = 2

Result: [[2, 30], [4,10]]
 */
public class HighestHotelScores {

    public List<List<Integer>> highestScores(ArrayList<Hotel> list, Integer K) {
        return list.stream()
                .sorted(Comparator.comparingInt(x -> x.score*-1))
                .limit(K)
                .map(hotel -> List.of(hotel.parentHotelId, hotel.score))
                .collect(Collectors.toList());
    }
}


class Hotel{
    Integer hotelId;
    Integer parentHotelId;
    Integer score;
}
