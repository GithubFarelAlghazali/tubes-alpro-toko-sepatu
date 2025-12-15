package TokoSepatu;

import java.util.Scanner;

public class Input {
    public static void inputSepatu(Scanner scanner, int count, String[][] data) {

        if (count >= data.length) {
            System.out.println("Data sepatu sudah penuh, tidak bisa tambah lagi.");
            return;
        }
        scanner.nextLine();
        System.out.print("Masukkan merk sepatu: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan harga sepatu: ");
        int harga = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan jarak pengiriman (km): ");
        int jarak = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan alamat pengiriman: ");
        String alamat = scanner.nextLine();
        int ongkir;
            if (jarak <= 10) {
                ongkir = 10000;
            } else {
                ongkir = 20000;
            }

            int totalSebelumPPN = harga + ongkir;
            double ppn = totalSebelumPPN * 0.1;
            double totalPPN = totalSebelumPPN + ppn;

            String status = "Diproses";

        data[count][0] = merk;
        data[count][1] = String.valueOf(harga);
        data[count][2] = String.valueOf(jarak);
        data[count][3] = alamat;
        data[count][4] = String.valueOf((int) ppn);
        data[count][5] = String.valueOf(ongkir);
        data[count][6] = String.valueOf((int) totalPPN);
        data[count][7] = String.valueOf(count);
        data[count][8] = status;

        count++;

        System.out.println("Data sepatu berhasil ditambahkan.");
    }

    public class Tampilkan {

    public static void tampilkanData(int mode, String[][] data) {
        System.out.println("=== DATA SEPATU ===");

            for (int i = 0; i < data.length; i++) {
                if (data[i][0] == null) break;

                System.out.println(" | ID    : " + data[i][7]);
                System.out.println(" | Merk  : " + data[i][0]);
                System.out.println(" | Harga : " + data[i][1]);
                System.out.println(" | Jarak : " + data[i][2]);
                System.out.println(" | Alamat: " + data[i][3]);
                System.out.println(" | PPN   : " + data[i][4]);
                System.out.println(" | Ongkir: " + data[i][5]);
                System.out.println(" | Total : " + data[i][6]);
                System.out.println(" | Status: " + data[i][8]);
                System.out.println("===================");
            }
        }
    }
}
