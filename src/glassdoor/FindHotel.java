//package glassdoor;
///*
//Find the nearest hotels within a range [min, max] in a 2D grid,
//where the cells with the value 1 represent part of a road,
//a value bigger than 1 is the price of a room per night and an empty cell no road or hotel.
// */
//
//import java.util.List;
//import java.util.Stack;
//
//public class FindHotel {
//
//    public static Integer findHotel(List<List<Integer>> grid, int r, int c, int min, int max){
//
//
//    }
//
//    public static Integer explore(List<List<Integer>> grid, int r, int c, int r2, int c2, int min, int max){
//        if(r2 < 0 || c2 < 0 || r2 >= grid.size() || c2 >= grid.get(0).size() ||
//        r2-r > max || c2-c > max) return 0;
//        if(grid.get(r2).get(c2).equals(0)) return 0;
//
//        int count = 0;
//        if(grid.get(r2).get(c2)>1 && r2 - r >= min && c2 - c >= min) {
//            count++;
//        }
//        if(grid.get(r).get(c).equals(1)){
//            explore(grid, r, c, r2+1, c, min, max);
//
//        }
//    }
//}
