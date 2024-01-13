/**
 * SquareRoot
 */
public class SquareRoot {

    public static void main(String[] args) {
        int x = 15;
        if (x == 0) {
            System.out.println("Can't find square root of 0");
            return;
        }
        int first = 1, last = x;
        while (first <= last) {
            int mid = (first + last) >> 1;
            if (mid == x / mid) {
                System.out.println(mid);
                return;
            } else if (mid > x / mid) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        System.out.println(last);
        return;
    }
}