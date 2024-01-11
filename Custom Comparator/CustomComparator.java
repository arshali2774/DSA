import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * CustomComparator
 */
class SortByFirstElement implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        return a.get(0).compareTo(b.get(0));
    }
}

class SortBySecondElement implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        return a.get(1).compareTo(b.get(1));
    }
}

public class CustomComparator {

    public static void main(String[] args) {
        oneDArrayList();
        System.out.println();
        usingCustomComparator();
    }

    public static void usingCustomComparator() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(1, 44)));
        list.add(new ArrayList<>(List.of(0, 55)));
        list.add(new ArrayList<>(List.of(0, 22)));
        list.add(new ArrayList<>(List.of(0, 11)));
        System.out.println("Printing an array of array");
        for (ArrayList<Integer> pair : list) {
            System.out.println(pair);
        }
        System.out.println();
        // sorting using collections.sort
        // Collections.sort(list); // we are getting error because normal sort is used
        // to sort only 1 dimension array
        // so we have to define our needs using comparator and we can sort the arraylist
        // however we want
        Collections.sort(list, new SortByFirstElement());
        System.out.println("Printing an array of array in ASC order based in FIRST elements");
        for (ArrayList<Integer> pair : list) {
            System.out.println(pair);
        }
        System.out.println();
        Collections.sort(list, new SortBySecondElement());
        System.out.println("Printing an array of array in ASC order based in SECOND elements");
        for (ArrayList<Integer> pair : list) {
            System.out.println(pair);
        }
        System.out.println();
    }

    public static void oneDArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>(); // this is like vectors in C++ STL.
        arrayList.add(10);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(6);
        System.out.println();
        System.out.println("Elements in array list unsorted");
        for (int x : arrayList) {
            System.out.print(x + " ");
        }
        System.out.println();
        // using collection.sort to sort elements.
        Collections.sort(arrayList); // this will automatically sort in increasing order.
        System.out.println();
        System.out.println("Elements in array list sorted ASCENDING");
        for (int x : arrayList) {
            System.out.print(x + " ");
        }
        System.out.println();
        Collections.sort(arrayList, Comparator.reverseOrder()); // sorting in descending order.
        System.out.println();
        System.out.println("Elements in array list sorted DESCENDING");
        for (int x : arrayList) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}