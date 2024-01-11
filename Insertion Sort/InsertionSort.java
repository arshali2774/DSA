/**
 * InsertionSort
 * hum ye maante hai ki first element apni sahi position pr hai
 * uske baad hum check krenge kya koi element us se chota hai.
 * agar hai to hum first element ko us element ki position pr daal denge.
 * aur uske baad hum us element ko first element ki position pr daal denge,
 * niche diye gaye array ka example lete hai
 * 5 4 3 2 1
 * ab maanlo 5 sahi jagah pr hai
 * phir humara key element ho jayega 4.
 * ab hum baaki array pr loop lagayenge that is from 4 to 1.
 * and we will check if humara sorted element kahi bada to nahi hai baaki kisi
 * element se
 * agar hai hum 4 ki jagah 5 daal denge.
 * 5 5 3 2 1
 * ab hume jo key element hai use sorted position pr daal dena hai
 * 4 5 3 2 1
 * ab 4 and 5 are sorted.
 * ab we have sorted array 4 5 and unsorted 3 2 1
 * ab humara key ho jayega 3
 * aur ab sorted array pr bhi saare element compare krenge ulta direction main
 * ki kahin koi element bada to nahi
 * to phele 5 check hoga jo ki bada hai and 5 ko 3 ki jagah daal denge.
 * 4 5 5 2 1
 * ab 4 compare hoga 3 se jo ki key hai
 * again 4 ko ek baar aage krdednge
 * 4 4 5 2 1
 * ab key ko sorted array main daal denge
 * 3 4 5 2 1
 * aise hi poora array sort ho jayega
 * 
 */
public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println();
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}