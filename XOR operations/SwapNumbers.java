public class SwapNumbers {
    public static void main(String[] args) {
        int x = 10, y = 20;
        System.out.println();
        System.out.println("X = " + x + " Y = " + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("X = " + x + " Y = " + y);
    }
}
