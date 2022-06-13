/*
Given four positive integers A, B, C, D, determine if there’s a rectangle such that the lengths of its sides are A, B, C and D (in any order).

If any such rectangle exist return 1 else return 0.
 */

public class Rectangle {
    public int solve(int A, int B, int C, int D) {
        return (A == B && C == D) ||
                (B==C && D == A) ||
                (B == D && C == A) ? 1 : 0;
    }
}

