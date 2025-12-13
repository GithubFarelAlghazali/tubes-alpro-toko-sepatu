import java.util.Scanner;

public class TokoSepatu {

    static String[][] dataSepatu = new String[100][3];
    static int count = 0;

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

    static void tampilkanDataDenganPPN() {
        if (count == 0) {
        System.out.println("Data sepatu belum ada. Silakan input data terlebih dahulu.");
        return;
        }
        
        System.out.println("=== Daftar Barang + Total + PPN ===");
        for (int i = 0; i < count; i++) {
            int harga = Integer.parseInt(dataSepatu[i][1]);
            int jarak = Integer.parseInt(dataSepatu[i][2]);
            int ongkir;

            if (jarak <= 10) {
                ongkir = 10000;
            } else {
                ongkir = 20000;
            }

            int totalSebelumPPN = harga + ongkir;
            double ppn = totalSebelumPPN * 0.1;
            double totalPPN = totalSebelumPPN + ppn;

            System.out.println(
                (i+1) +
                " | Merk: " + dataSepatu[i][0] + 
                " | Harga: Rp" + harga + 
                " | Ongkir: Rp" + ongkir + 
                " | PPN: Rp" + (int)ppn + 
                " | Total + PPN: Rp" + (int)totalPPN
            );
        }
    }

     static void inputDataSepatu(Scanner scanner) {
        if (count >= dataSepatu.length) {
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

        dataSepatu[count][0] = merk;
        dataSepatu[count][1] = String.valueOf(harga);
        dataSepatu[count][2] = String.valueOf(jarak);
        count++;

        System.out.println("Data sepatu berhasil ditambahkan.");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int menu;
         do {
            menu = pilihMenu(scanner);
            switch(menu) {
                case 1:
                    tampilkanDataDenganPPN();
                    break;
                case 2:
                    inputDataSepatu(scanner);
                    break;
                case 3:
                case 4:
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while(menu != 0);
    }
}