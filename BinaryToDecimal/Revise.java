package BinaryToDecimal;

public class Revise {
  public static void main(String[] args) {
    int binaryNum = 10001;
    int decimalNum = 0;
    int factor = 1; // this is 2^i where i>=0;
    int newBinaryNum = binaryNum;
    while (newBinaryNum != 0) {
      int digit = newBinaryNum % 10;
      newBinaryNum /= 10;
      decimalNum += digit * factor;
      factor = 2 * factor;
    }
    System.out.println(binaryNum + " = " + decimalNum);
  }
}
