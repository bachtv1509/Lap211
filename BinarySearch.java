import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    Scanner sc = new Scanner(System.in);
    public int checkInput(String mess, int min){
        int n = 0;
        while(true){
            try {
                System.out.print(mess);
                n = Integer.parseInt(sc.nextLine());
                if(n >= min) break;
                else System.out.println("Must be positive number");
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Must be Integer number");
            }
        }
        return n;
    }

    public void bubbleSort(int a[], int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(a[j] > a[j + 1]){
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    public int search(int a[], int low, int hight, int x){
        if(hight >= low){
            int mid = low + (hight - low) / 2;
            if(a[mid] == x) return mid;
            else if(a[mid] > x) return search(a, low, mid - 1, x);
            else return search(a, mid + 1, hight, x);
        }
        return -1;
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
        BinarySearch bs = new BinarySearch();
        int n = bs.checkInput("Enter number of array: ", 1);
        int a[] = new int[n];
        Random r = new Random();
        for(int i = 0; i < n; i++){
            a[i] = r.nextInt(n);
        }
        bs.bubbleSort(a, n);
        bs.print("Sorted array: [", a, n);
        int x = bs.checkInput("Enter value x: ", 0);
        int result = bs.search(a, 0, n - 1, x);
        if(result == -1) System.out.format("Not found %d in array",x);
        else{
            System.out.print(result + " ");
            int result1 = result, result2 = result;
            while(result1 > 0 && a[result1 - 1] == x){
                result1--;
                System.out.print(result1 + " ");
            }

            while(result2 < n && a[result2 + 1] == x){
                result2++;
                System.out.print(result2 + " ");
            }
        }
    }
}
