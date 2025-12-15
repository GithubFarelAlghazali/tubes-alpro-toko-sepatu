package TokoBuku;
import java.util.Scanner;

public class Hapus {
    
    public static int hapusData(Scanner scanner, String[][] data, int count){
        // tampilkanDataSepatu(dataSepatu);
        System.out.println();

        if (count == 0) {
            System.out.println("Data sepatu belum ada. Silakan input data terlebih dahulu.");
            return count;
        }

        System.out.print("Pilih merk yang ingin dihapus: ");
        String merk = scanner.next();
        int edited = -1;

        for(int i = 0; i < count; i++){
            if(data[i][0].equalsIgnoreCase(merk)){
                edited = i;
            }
        }

        if(edited < 0){
            System.out.println("Merek tidak ada");
            return count;
        }
        String[][] newArray = new String[count - 1][3];
        int pos = 0;

        for (int i = 0; i < count; i++) {
            if(i != edited){
            newArray[pos] = data[i];
            pos++;} 
        }

        data = newArray;
        System.out.println("Berhasil dihapus");
        
        // tampilkanDataSepatu(dataSepatu);
        return count - 1;
    }
}
