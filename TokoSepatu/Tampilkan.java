package TokoSepatu;

public class Tampilkan {

    public static void tampilkanData(int mode, String[][] data, int count) {

        if (count == 0) {
            System.out.println("=== ADMIN TOKO SEPATU LARIS ===");
            System.out.println("\nData sepatu belum ada.\n");
            return;
        }


        String[][] copy = new String[count][9];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 9; j++) {
                copy[i][j] = data[i][j];
            }
        }


        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                int h1 = Integer.parseInt(copy[j][9]);
                int h2 = Integer.parseInt(copy[j + 1][9]);

                boolean kondisi = (mode == 1) ? h1 < h2 : h1 > h2;
                if (kondisi) {
                    String[] temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }

        System.out.println("\n=== ADMIN TOKO SEPATU LARIS ===");

        // ================= TABEL PROSES =================
        System.out.println("\nPESANAN DIPROSES");
        cetakHeader();

        for (int i = 0; i < count; i++) {
            if (copy[i][8].equalsIgnoreCase("DIPROSES")) {
                cetakBaris(copy[i]);
            }
        }
        garis();

    
        System.out.println("\nPESANAN LUNAS");
        cetakHeader();

        for (int i = 0; i < count; i++) {
            if (copy[i][8].equalsIgnoreCase("LUNAS")) {
                cetakBaris(copy[i]);
            }
        }
        garis();
    }

    
    static void cetakHeader() {
        System.out.printf(
            "%-5s %-15s %-12s %-10s %-12s %-12s %-12s %-15s\n",
            "ID", "Merk", "Harga", "Jarak","Alamat", "Ongkir", "PPN" , "Total"
        );
        garis();
    }

    static void cetakBaris(String[] d) {
        System.out.printf(
            "%-5s %-15s %-12s %-10s %-12s %-12s %-12s %-15s\n",
            d[7], d[0], "Rp"+d[1], d[2]+" km", d[3], "Rp"+d[4], "Rp"+d[5], "Rp"+d[6]
        );
    }

    static void garis() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }
}
