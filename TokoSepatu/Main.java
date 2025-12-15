package TokoSepatu;
import TokoSepatu.Edit;
import java.util.Scanner;

public class Main{
    static String[][] dataSepatu = {{ "Nike", "120000", "1km" },{"Rebook", "100000", "90km"},{"Adidas", "250000", "250km"}, {"Water Jordan", "500000", "100km"}};

   
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
        int menu = pilihMenu(scanner);

        switch(menu){
            case 3:
                Edit.editData(scanner, dataSepatu);;
            break;
            case 0:
                System.out.println("Ceritanya kelar");
            break;
            default:
                System.out.println("Udah terserahh kelan");
        }

    }
}