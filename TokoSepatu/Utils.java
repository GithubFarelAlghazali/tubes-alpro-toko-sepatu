package TokoSepatu;
import java.util.Scanner;

public class Utils {
    static Scanner scanner = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressToNext(){
        System.out.println("Tekan ENTER untuk memuat ulang halaman");
        scanner.nextLine();
    }
}
