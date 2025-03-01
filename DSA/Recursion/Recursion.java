package DSA.Recursion;

public class Recursion {
    public static int countPath(int n, int m, int i, int j) {
        if(i == n || j == m) {
            return 0;
        }
        if(i == n-1 && j == m-1) {
            return 1;
        }
        int downPath = countPath(n, m, i+1, j);

        int rightPath = countPath(n, m, i, j+1);

        return downPath + rightPath;
    }

    public static void printPermut(String str, String permut) {
        if(str.length() == 0) {
            System.out.println(permut);
            return;
        }
        for(int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPermut(newStr, permut+currChar);
        }
    }
    public static void main(String[] args) {
        int n = 3, m = 3;
        int totalPath = countPath(n, m, 0, 0);
        System.out.println(totalPath);
    }
}
