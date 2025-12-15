package services;
import java.util.Scanner;

public class Edit {
    public static void editData(Scanner scanner, String[][] data, int count){
        // tampilkanDataSepatu(dataSepatu);
       
        System.out.println();

        if (count == 0) {
                System.out.println("Data sepatu belum ada. Silakan input data terlebih dahulu.");
                return;
                }

        System.out.print("Pilih merk yang ingin diedit: ");
        String merk = scanner.next();
        int edited = -1;

        for(int i = 0; i < count; i++){
            if(data[i][0].equalsIgnoreCase(merk)){
                edited = i;
            }
        }

        if(edited < 0){
            System.out.println("Merek tidak ada");
            return;
        }

        System.out.print("Edit harga: ");
        String harga = scanner.next();
        System.out.print("Edit jarak: ");
        String jarak = scanner.next();

        data[edited][1] = harga ;
        data[edited][2] = jarak + "km";

        System.out.println("Berhasil edit");

        // tampilkanDataSepatu(dataSepatu);

    }
}
