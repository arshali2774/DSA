package RemoveAllAdjacentDuplicateStrings;

import java.util.LinkedList;

class Item {
  char c;
  int freq;

  public Item(char c, int freq) {
    this.c = c;
    this.freq = freq;
  }
}

public class RemoveAllAdjacentDup2 {
  public static void main(String[] args) {
    String s1 = "abcd", s2 = "deeedbbcccbdaa", s3 = "pbbcggttciiippooaais";
    int k1 = 2, k2 = 3, k3 = 2;
    System.out.println("Answer 1: " + removeDupStack(s1, k1));
    System.out.println("Answer 2: " + removeDupStack(s2, k2));
    System.out.println("Answer 3: " + removeDupStack(s3, k3));

  }

  public static String removeDupStack(String s, int k) {
    // Using Stack and String Builder.
    StringBuilder str = new StringBuilder();
    // implementing stack using linked list, and making custom node Item.
    LinkedList<Item> stack = new LinkedList<>();
    for (char c : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek().c == c) {
        // if stack is not empty and top element on stack is same as the
        // current element, then increase the freq of the top most element.
        ++stack.peek().freq;
      } else {
        stack.push(new Item(c, 1));
        // if stack is empty or the top element is not same as current element then push
        // the element initialize the freq.
      }
      if (stack.peek().freq == k) {
        stack.pop();// if top element freq matches k then pop the top element.
      }
    }

    // append the answer to string builder
    while (!stack.isEmpty()) {
      Item item = stack.pop();
      for (int i = 0; i < item.freq; ++i)
        str.append(item.c);
    }
    // answer will be in reverse order.
    return str.reverse().toString();
  }
}
