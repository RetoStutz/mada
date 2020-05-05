package SiebDesEratostenes;

public class Sieb {

    public static void sieb(int n){
        boolean[] prim = new boolean[n+1];
        for (int i = 2; i <= n; i++)
            prim[i] = true;
        for (int i = 2; i*i <= n; i++)
            if (prim[i])
                for (int j = i; i*j <= n; j++)
                    prim[i*j] = false;
        for (int i = 2; i <= n; i++) {
            if(prim[i]) System.out.println(i);
        }
    }
    public static void main(String[] args) {
        sieb(100000);
    }
}
