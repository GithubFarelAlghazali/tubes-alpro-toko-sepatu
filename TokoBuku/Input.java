package TokoBuku;
import java.util.Scanner;

public class Input {
    public static int inputSepatu(Scanner scanner, int count, String[][] data) {
        if (count >= data.length) {
            System.out.println("Data sepatu sudah penuh, tidak bisa tambah lagi.");
            return count;
        }
        scanner.nextLine();
        System.out.print("Masukkan merk sepatu: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan harga sepatu: ");
        int harga = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan jarak pengiriman (km): ");
        int jarak = Integer.parseInt(scanner.nextLine());
        int ongkir;
        
        if (jarak <= 10) {
            ongkir = 10000;
        } else {
            ongkir = 20000;
        }
        
        int totalSebelumPPN = harga + ongkir;
        double ppn = totalSebelumPPN * 0.1;
        double totalPPN = totalSebelumPPN + ppn;
        
        data[count][0] = merk;
        data[count][1] = String.valueOf(harga);
        data[count][2] = String.valueOf(jarak);
        data[count][3] = String.valueOf((int) ppn);
        data[count][4] = String.valueOf((int) totalPPN);
        
        System.out.println("\nData sepatu berhasil ditambahkan!\n");
        return count + 1;
    }
}
