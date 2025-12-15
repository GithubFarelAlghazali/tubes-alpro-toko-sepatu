package TokoSepatu;
import java.util.Scanner;

public class Edit {
    public static void editData(Scanner scanner, String[][] data){
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

        System.out.print("Edit harga: ");
        String harga = scanner.next();
        System.out.print("Edit jarak: ");
        String jarak = scanner.next();

        data[edited][1] = harga ;
        data[edited][2] = jarak + "km";

        // tampilkanDataSepatu(dataSepatu);

    }
}
