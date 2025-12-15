package TokoSepatu;
import TokoSepatu.Hapus;
import java.util.Scanner;

public class Main{
    static String[][] dataSepatu = {
    { "Nike", "120000", "1km" },
    {"Rebook", "100000", "90km"},
    {"Adidas", "250000", "250km"}, 
    {"Water Jordan", "500000", "100km"}};

    // Method to display all items in the dataSepatu array
    static void tampilkanDataSepatu(String[][] dataSepatu) {
        System.out.println("\nDaftar Sepatu:\n");
        for (int i = 0; i < dataSepatu.length; i++) {
            for(int j = 0; j < 3; j++){
                System.out.print(dataSepatu[i][j] + " ");
            }
                System.out.println();
        }
    }

    static void editData(Scanner scanner){
        tampilkanDataSepatu(dataSepatu);
        System.out.println();
        System.out.print("Pilih merk yang ingin diedit: ");
        String merk = scanner.next();
        int edited = 0;
        boolean isHere = false;
        for(int i = 0; i < dataSepatu.length; i++){
            if(dataSepatu[i][0].toLowerCase().equals(merk.toLowerCase())){
                edited = i;
                isHere = true;
            }
        }

        if(!isHere){
            System.out.println("Merek tidak ada boss");
            return;
        }

        System.out.print("Edit harga: ");
        String harga = scanner.next();
        System.out.print("Edit jarak: ");
        String jarak = scanner.next();

        dataSepatu[edited][1] = harga ;
        dataSepatu[edited][2] = jarak + "km";

        tampilkanDataSepatu(dataSepatu);

    }



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
                editData(scanner);
            break;
            case 4:
                Hapus.hapusData(scanner, dataSepatu);
            break;
            case 0:
                System.out.println("Ceritanya kelar");
            break;
            default:
                System.out.println("Udah terserahh kelan");
        }

    }
}