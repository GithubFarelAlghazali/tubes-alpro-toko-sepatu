package TokoSepatu;
import java.util.Scanner;

public class Hapus {
    
    public static void hapusData(Scanner scanner, String[][] data){
        // tampilkanDataSepatu(dataSepatu);
        System.out.println();
        System.out.print("Pilih merk yang ingin diedit: ");
        String merk = scanner.next();
        int edited = 0;
        boolean isHere = false;
        for(int i = 0; i < data.length; i++){
            if(data[i][0].toLowerCase().equals(merk.toLowerCase())){
                edited = i;
                isHere = true;
            }
        }

        if(!isHere){
            System.out.println("Merek tidak ada boss");
            return;
        }

        String[][] newArray = new String[data.length - 1][3];
        int pos = 0;

        for (int i = 0; i < data.length; i++) {
            if(i != edited){
            newArray[pos] = data[i];
            pos++;} 
        }

        data = newArray;
        // tampilkanDataSepatu(dataSepatu);

    }
}
