import java.util.Scanner;
import java.util.Random;

public class LinearSearch {
    Scanner sc = new Scanner(System.in);
    public int checkInput(){
        int n = 0;
        while(true){
            try {
                n = Integer.parseInt(sc.nextLine());
                if(n > 0) break;
                else System.out.println("Must be positive number");
            } catch (Exception e) {
                System.out.println("Must be number");
            }
        }
        return n;
    }

    public void search(int a[], int x){
        boolean check = false;
        for(int i = 0; i < a.length; i++){
            if(a[i]  == x) {
                System.out.format("Found %d in index %d ", x, i);
                System.out.println();
                check = true;
            }
        }
        if(check == false) System.out.print("Not found x");
    }

    public void print(int a[]){
        System.out.print("Array: [");
        for(int i = 0; i < a.length; i++){
            if(i == a.length - 1) System.out.print(a[i] + "]");
            else System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();
        System.out.print("Enter number of array: ");
        int n = ls.checkInput();
        int a[] = new int[n];
        Random r = new Random();
        for(int i = 0; i < n; i++){
            a[i] = r.nextInt(n);
        }
        ls.print(a);

        System.out.println("Enter the number want to search: ");
        int x = ls.checkInput();
        ls.search(a, x);
    }
}
