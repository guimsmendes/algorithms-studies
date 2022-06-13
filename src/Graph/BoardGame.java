package Graph;

import java.util.List;

/*
Consider an N*N game board, with a black and white pieces that can be placed on it. You are given a board with placed pieces around it in a random spots.

You need to implement a function that determines if a piece (black or white) is captured on a given coordination (x, y).

A piece is defined as captured by the following rules:
1. If all sides (up, down, left & right) contains an opposite piece that surrounds/blocking it.
2. If some of the sides are blocked (for example, right and down) and the other ones are out of bound (OOB defined for coords: x: <= 0, y: <= 0) it's considered as blocked.
3. If one of the sides is empty, it's free.
4. If one of the sides contains the same piece type, and that piece is not captured (by the rules above), it's free.
5. Note that pieces may be captured in a clustered way (related to #4).

For example, consider the following coordinates:
coord(1,1) = B
coord(1,2) = W
coord(2,1) = W

X | 1 | 2
1 | B | W
2 | W |
For the given coordination 1,1 the result would be `captured` (true).

Another example, consider the following coordinates:
coord(2,2) = W
coord(2,3) = W
coord(3,1) = W
coord(3,2) = B
coord(3,3) = B
coord(3,4) = W
coord(4,2) = W
coords(4,3) = W

X | 1 | 2 | 3 | 4 | 5 |
2 | E  | W | W | W | E
3 | W  | B | B | B | W
4 | E  | W | W | W | E
For the given coordination 3,2 (or 3,3) the result would be `true` (captured).
If we would either remove one of the W coords (thus making it empty), or change it to be a B piece, the result would be `false` (not captured).

As basic primitive, you are provided with a function that translates coordination into its state:

getState (x, y) == Black, White, Out Of Bound, Empty
 */
public class BoardGame {

    public String getState(List<List<String>> grid, Integer r, Integer c) {
        if (r < 0 || c < 0 || r < grid.size() || c < grid.get(0).size()) return "Out Of Bound";
        switch (grid.get(r).get(c)) {
            case "B":
                return "Black";
            case "W":
                return "White";
            default:
                return "Empty";
        }
    }

    public boolean isFree(List<List<String>> grid, Integer x, Integer y) {

        var current = getState(grid, x, y);
        var up = getState(grid, x - 1, y);
        var down = getState(grid, x + 1, y);
        var left = getState(grid, x, y - 1);
        var right = getState(grid, x, y + 1);

        if (up.equals("Empty") || down.equals("Empty") || left.equals("Empty") || right.equals("Empty")) return true;

        return isAFriendFree(grid, current, down, x + 1, y) ||
                isAFriendFree(grid, current, up, x - 1, y) ||
                isAFriendFree(grid, current, left, x, y - 1) ||
                isAFriendFree(grid, current, right, x, y + 1);

    }

    public boolean isAFriendFree(List<List<String>> grid, String current, String position, Integer x, Integer y) {
        return current.equals(position) ? isFree(grid, x, y) : false;
    }

}
