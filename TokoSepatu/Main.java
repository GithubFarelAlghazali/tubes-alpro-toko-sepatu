package TokoSepatu;
import java.util.Scanner;
import TokoSepatu.Input;

public class Main{

    static String[][] dataSepatu = new String[100][9];
    static int count = 0;

    // static void editData(Scanner scanner){
    //     Tampilkan.tampilkanData(1, dataSepatu);
    //     System.out.println();
    //     System.out.print("Pilih merk yang ingin diedit: ");
    //     scanner.nextLine();
    //     String merk = scanner.nextLine();
    //     int edited = cariMerk(merk);

    //     if(edited < 0){
    //         System.out.println("Merek tidak ada boss");
    //         return;
    //     }

    //     System.out.print("Edit harga: ");
    //     String harga = scanner.next();
    //     System.out.print("Edit jarak: ");
    //     String jarak = scanner.next();
    //     int ongkir;

    //         if (Integer.parseInt(jarak) <= 10) {
    //             ongkir = 10000;
    //         } else {
    //             ongkir = 20000;
    //         }

    //         int totalSebelumPPN = Integer.parseInt(harga) + ongkir;
    //         double ppn = totalSebelumPPN * 0.1;
    //         double totalPPN = totalSebelumPPN + ppn;


    //     dataSepatu[edited][1] = harga;
    //     dataSepatu[edited][2] = jarak;
    //     dataSepatu[edited][3] = String.valueOf((int) ppn);
    //     dataSepatu[edited][4] = String.valueOf((int) totalPPN);

    //     Tampilkan.tampilkanData(1, dataSepatu);

    // }

    //  static void hapusData(Scanner scanner){
    //     Tampilkan.tampilkanData(1, dataSepatu);
    //     System.out.println();
    //     System.out.print("Pilih merk yang ingin diedit: ");
    //     String merk = scanner.next();
    //     int deleted = cariMerk(merk);
    //     if(deleted < 0){
    //         System.out.println("Merek tidak ada boss");
    //         return;
    //     }

    //     for (int i = deleted; i < count - 1; i++) {
    //        dataSepatu[i] = dataSepatu[i + 1];
    //     }

    //     dataSepatu = newArray;
    //     Tampilkan.tampilkanData(1, dataSepatu);

    // }

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
                Input.Tampilkan.tampilkanData(mode, dataSepatu);
            break;
            case 2:
                Input.inputSepatu(scanner, count, dataSepatu);
                count++;
            break;
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