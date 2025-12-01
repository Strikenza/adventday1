import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(testZeros());
    }

        public static String strSeperate(String turn) {
            return turn.substring(0,1);
        }

        public static int intSeperate(String turn) {
            return Integer.parseInt(turn.substring(1));
        }


    public static int turnercheck(String turn, int starter) {
        String stringturn = strSeperate(turn);
        int intturn = intSeperate(turn);
        int zerocount = 0;
        if (stringturn.equals("L")) {
            for (int i = 0; i < intturn; i++) {
                starter--;
                if (starter == 0) zerocount++;
                if (starter == -1) {
                    starter = 99;
                }
            }
        }
        if (stringturn.equals("R")) {
            for (int i = 0; i < intturn; i++) {
                starter++;
                if (starter == 0) zerocount++;
                if (starter == 100) {
                    starter = 0;
                }
            }
        }
        return zerocount;
    }

        public static int turner(String turn, int starter) {
        String stringturn = strSeperate(turn);
        int intturn = intSeperate(turn);
            if (stringturn.equals("L")) {
                for (int i = 0; i < intturn; i++) {
                    starter--;
                    if (starter == -1) {
                        starter = 99;
                    }
                }
            }
            if (stringturn.equals("R")) {
                for (int i = 0; i < intturn; i++) {
                    starter++;
                    if (starter == 100) {
                        starter = 0;
                    }
                }
            }
            return starter;
        }

        public static int testZeros() throws FileNotFoundException {
            int count = 0;
            int current = 50;
            int line = 0;
            String nextChange =" ";
            File f = new File("input.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                nextChange = s.next();
                count += turnercheck(nextChange, current);
                current = turner(nextChange, current);
            }
            return count;
        }

}