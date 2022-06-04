import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    Scanner sc = new Scanner(System.in);
    public int checkInput(String mess){
        int n = 0;
        while(true){
            try {
                System.out.print(mess);
                n = Integer.parseInt(sc.nextLine());
                if(n > 0) break;
                else System.out.println("Must be positive number");
            } catch (Exception e) {
                System.out.println("Must be Integer number");
                //TODO: handle exception
            }
        }
        return n;
    }

    public void sort(int a[], int n){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(a[j] > a[j + 1]){
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    public void print(String mess, int a[], int n){
        System.out.print(mess);
        for(int i = 0; i < n; i++){
            if(i == n - 1) System.out.print(a[i] + "]");
            else System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int n = bs.checkInput("Enter number of array: ");
        int a[] = new int[n];
        Random r = new Random();
        for(int i = 0; i < n; i++){
            a[i] = r.nextInt(n);
        }

        bs.print("Unsorted array: [", a, n);
        bs.sort(a, n);
        bs.print("Sorted array: [", a, n);
    }
}