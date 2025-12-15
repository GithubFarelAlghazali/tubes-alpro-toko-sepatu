package TokoSepatu;
import java.util.Scanner;

public class Utils {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressToNext(Scanner scanner){
        scanner.nextLine();
        System.out.println("Tekan \"ENTER\" untuk kembali ke dashboard");
        scanner.nextLine();
    }
}
