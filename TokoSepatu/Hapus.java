package TokoSepatu;
import java.util.Scanner;

public class Hapus {
    
    public static int hapusData(Scanner scanner, String[][] data, int count){
        // tampilkanDataSepatu(dataSepatu);
        System.out.println();

        if (count == 0) {
            System.out.println("Data sepatu belum ada. Silakan input data terlebih dahulu.");
            return count;
        }

        System.out.print("Merk sepatu yang ingin dihapus: ");
        String merk = scanner.next();
        System.out.print("Jenis sepatu yang ingin dihapus: ");
        String jenis = scanner.next();
        int edited = -1;

        for(int i = 0; i < count; i++){
            if(data[i][0].equalsIgnoreCase(merk) && data[i][1].equalsIgnoreCase(jenis)){
                edited = i;
            }
        }

        if (edited < 0) {
            System.out.println("Merk atau jenis tidak valid");
            Utils.pressToNext();
            return count;
        }
        

        for (int i = edited; i < count - 1; i++) {
            data[i] = data[i + 1];
        }

        System.out.println("\nBerhasil dihapus\n");
        Utils.pressToNext();
        // tampilkanDataSepatu(dataSepatu);
        return count - 1;
    }
}
