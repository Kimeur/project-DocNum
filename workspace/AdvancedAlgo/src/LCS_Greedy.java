public class LCS_Greedy {

public static void main(String[] args) {
//        String X_awal = "ABCBDABE";
//        String Y = "BDCABA";

//        String X_awal = "XMJYAUZ";
//        String Y = "MZJAWXU";

//        String X_awal ="AGGTAB";
//        String Y="GXTXAYB";

//        String X_awal = "ABCDGH";
//        String Y = "AEDFHR";

//        String X_awal = "AHBCDG";
//        String Y = "AEDFHR";       

    //greedy not always optimum
    String X_awal = "my name is marouane, and i'm sick, thank you very much";
    String Y = "my name is adeleye, but you are very sick, thank you ";
    String X = match(X_awal, Y);
    int[] Penanda_Y = new int[Y.length()];
    int y_length = Y.length();
    for (int k = 0; k < y_length; k++) {
        Penanda_Y[k] = 0;
    }
    int m = X.length();
    int n = Y.length();
    String L = "";
    String LSym = "";
    int R = 0;
    int i = 1;
    int[] P = new int[100];
    P[i] = posisi(X, Y, i, Penanda_Y, R);
    i = 1;
    while (i <= m) {
        if (i != m) {
            P[i + 1] = posisi(X, Y, (i + 1), Penanda_Y, R);
        }
        if (P[i + 1] == 0) {
            if (P[i] > R) {
                L = L + " " + Integer.toString(P[i]);
                LSym = LSym + " " + X.charAt(i - 1);
            }
            break;
        }

        if (P[i + 1] < R || P[i] < R) {
            R = 0;
        }
        if (P[i] > P[i + 1]) {
            if (R == 0 && i > 1) {
                L = L + " " + Integer.toString(P[i]);
                LSym = LSym + " " + X.charAt(i - 1);
                Penanda_Y[P[i] - 1] = 1;
                R = P[i];
                i = i + 1;
                if (R == Y.length() || i > X.length()) {
                    break;
                }
                P[i] = posisi(X, Y, i, Penanda_Y, R);
            } else {
                L = L + " " + Integer.toString(P[i + 1]);
                LSym = LSym + " " + X.charAt(i + 1 - 1);
                Penanda_Y[P[i + 1] - 1] = 1;
                R = P[i + 1];
                i = (i + 1) + 1;
                if (R == Y.length() || i > X.length()) {
                    break;
                }
                P[i] = posisi(X, Y, i, Penanda_Y, R);
            }

        } else {

            if (R == 0 && i > 1) {
                L = L + " " + Integer.toString(P[i + 1]);
                LSym = LSym + " " + X.charAt(i + 1 - 1);
                Penanda_Y[P[i + 1] - 1] = 1;
                R = P[i + 1];
                i = (i + 1) + 1;
                if (R == Y.length() || i > X.length()) {
                    break;
                }
                P[i] = posisi(X, Y, i, Penanda_Y, R);
            } else {
                L = L + " " + Integer.toString(P[i]);
                LSym = LSym + " " + X.charAt(i - 1);
                Penanda_Y[P[i] - 1] = 1;
                R = P[i];
                i = i + 1;
                if (R == Y.length() || i > X.length()) {
                    break;
                }
                P[i] = posisi(X, Y, i, Penanda_Y, R);
            }
        }
    }
    System.out.println("X = " + X_awal);
    System.out.println("X = " + Y);
    System.out.println("L = " + L);
    System.out.println("LSym = " + LSym);
    System.out.println("Length = " + LSym.length() / 2);
}

public static String match(String X, String Y) {
    String hasil = "";
    for (int i = 0; i < X.length(); i++) {
        for (int j = 0; j < Y.length(); j++) {
            if (X.charAt(i) == Y.charAt(j)) {
                hasil = hasil + X.charAt(i);
                break;
            }
        }
    }
    return hasil;
}

public static int posisi(String X, String Y, int i, int[] Penanda_Y, int R) {
    int n = Y.length();
    int k;
    int kr = 0;
    i = i - 1;
    for (k = 0; k < n; k++) {
        if ((X.charAt(i) == Y.charAt(k)) && Penanda_Y[k] == 0) {
            kr = k + 1;
            break;
        }
    }
    for (k = R; k < n; k++) {
        if ((X.charAt(i) == Y.charAt(k)) && Penanda_Y[k] == 0) {
            kr = k + 1;
            break;
        }
    }
    return kr;
}
}