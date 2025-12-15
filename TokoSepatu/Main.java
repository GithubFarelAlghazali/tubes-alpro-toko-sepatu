package TokoSepatu;
import java.util.Scanner;
import TokoSepatu.*;

public class Main{

    static String[][] dataSepatu = new String[100][5];
    static int count = 0;

   
    static int pilihMenu(Scanner scanner){
   
        System.out.println("==== ADMIN TOKO SEPATU LARIS ====");
        System.out.println("Opsi: ");
        System.out.println("1. Tampilkan data sepatu");
        System.out.println("2. Input data sepatu");
        System.out.println("3. Edit data sepatu");
        System.out.println("4. Hapus data sepatu");
        System.out.println("0. Keluar");
        System.out.print("Pilih opsi: ");
        int menu = scanner.nextInt();
        return menu;
    }


    public static void main(String[] args){
        // clearScreen();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while(run){
        int menu = pilihMenu(scanner);

        // clearScreen();
        System.out.println();
        switch(menu){
            case 1:
                System.out.println("Urutkan dari: ");
                System.out.println("1. Mahal -> Murah");
                System.out.println("2. Murah -> Mahal ");
                int mode = scanner.nextInt();
                Tampilkan.tampilkanData(mode, dataSepatu);
            break;
            case 2:
                Input.inputSepatu(scanner, count, dataSepatu);
            case 3:
                // editData(scanner);
            break;
            case 4:
                // hapusData(scanner);
            break;
            case 0:
                System.out.println("Proram ditutup");
                run = false;
            break;
            default:
                System.out.println("Input tidak terdaftar, masukkan sesuai daftar!");
        }
        }

    }
}