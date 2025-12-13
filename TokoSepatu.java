import java.util.Scanner;

public class TokoSepatu{

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
        Scanner scanner = new Scanner(System.in);
        int menu = pilihMenu(scanner );
        
        switch(menu){
            case 0:
                System.out.println("Selesai");
                break;
            case 1:
                System.out.println("Tampilkan data");
                break;
            case 2:
                System.out.println("Masukkan data");
                break;
            case 3:
                System.out.println("Edit data");
                break;
            case 4:
                System.out.println("Hapus data");
                break;
            default:
                System.out.println("Opsi tidak sesuai");
                break;
        }
    }
}