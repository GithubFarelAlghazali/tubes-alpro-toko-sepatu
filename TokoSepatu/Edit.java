package TokoSepatu;
import java.util.Scanner;

public class Edit {
    public static void editData(Scanner scanner, String[][] data, int count) {

        System.out.println();

        if (count == 0) {
            System.out.println("Data sepatu belum ada. Silakan input data terlebih dahulu.");
            return;
        }

        System.out.print("Masukkan merk yang ingin diedit: ");
        String merk = scanner.next();
        System.out.print("Masukkan jenis sepatu: ");
        String jenis = scanner.next();
        int edited = -1;

        for (int i = 0; i < count; i++) {
            if (data[i][0].equalsIgnoreCase(merk) && data[i][1].equalsIgnoreCase(jenis)) {
                edited = i;
            }
        }

        if (edited < 0) {
            System.out.println("Merek atau jenis sepatu tidak valid");
            return;
        }

        System.out.print("Edit harga: ");
        String harga = scanner.next();
        System.out.print("Edit jarak: ");
        String jarak = scanner.next();

        data[edited][2] = harga;
        data[edited][3] = jarak;

        System.out.println("\nData sepatu berhasil diedit\n");

    }
    
    public static void editStatus(Scanner scanner, String[][] data, int count){
       
        System.out.println();

        if (count == 0) {
                System.out.println("Data sepatu belum ada. Silakan input data terlebih dahulu.");
                return;
                }

        System.out.print("Masukkan merk yang ingin diedit: ");
        String merk = scanner.next();
        System.out.print("Masukkan jenis sepatu: ");
        String jenis = scanner.next();
        int edited = -1;

        for(int i = 0; i < count; i++){
            if(data[i][0].equalsIgnoreCase(merk) && data[i][1].equalsIgnoreCase(jenis)){
                edited = i;
            }
        }

        if (edited < 0) {
            System.out.println("Merek atau jenis sepatu tidak valid");
            return;
        }

        if (data[edited][8].equalsIgnoreCase("diproses")) {   
            System.out.print("Ubah ke lunas(y/n)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                data[edited][8] = "Lunas" ;
            }
        } else {
            System.out.print("Ubah ke diproses(y/n)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                data[edited][8] = "Diproses" ;
            }
        }

  

        System.out.println("\nStatus pesanan sepatu berhasil diedit\n");

    }
}
