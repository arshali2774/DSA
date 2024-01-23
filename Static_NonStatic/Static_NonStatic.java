// package Static_NonStatic;

// /**
// * Static_NonStatic
// */
// public abstract class Static_NonStatic {
// public static int x = 10;
// public int y = 20;

// public abstract void NonStatic() {
// System.out.println(this.x); // no error can access static from non-static.
// Static_NonStatic.x += 10;
// System.out.println("Non static method");
// }

// public void NonStatic2() {
// NonStatic();
// }

// public static void Static() {
// System.out.println(Static_NonStatic.x);
// System.out.println();
// }

// public static void main(String[] args) {
// // main method is static
// // NonStatic(); // error cannot access non-static methods inside static
// methods.
// Static_NonStatic obj1 = new Static_NonStatic();
// obj1.NonStatic();
// System.out.println(obj1.x);
// System.out.println(Static_NonStatic.x);

// }
// }