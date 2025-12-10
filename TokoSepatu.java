import java.util.Scanner;

public class TokoSepatu{
    static String[][] dataSepatu = {{ "Nike", "120000", "1km" },{"Rebook", "100000", "90km"},{"Adidas", "250000", "250km"}};

    // Method to display all items in the dataSepatu array
    static void tampilkanDataSepatu(String[][] dataSepatu) {
        System.out.println("Daftar Sepatu:");
        for (int i = 0; i < dataSepatu.length; i++) {
            for(int j = 0; j < 3; j++){
                System.out.print(dataSepatu[i][j] + " ");
            }
                System.out.println();
        }
    }

    static void editData(Scanner scanner){
        tampilkanDataSepatu(dataSepatu);
        System.out.println("Pilih data yang ingin diedit");
        int edited = scanner.nextInt();
        for(int i = 0; i < 3; i++){
            System.out.print(dataSepatu[edited - 1][i] + " ");
        }
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
        System.out.println(menu);
        editData(scanner);
    }
}