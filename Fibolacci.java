public class Fibolacci {
    public int fibo(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Fibolacci fb = new Fibolacci();
        System.out.print("Arraay: ");
        for(int i = 0; i < 45; i++){
            if(i == 44) System.out.println(fb.fibo(i) + ",.....");
            else System.out.print(fb.fibo(i) + ", ");
        }
    }
}
