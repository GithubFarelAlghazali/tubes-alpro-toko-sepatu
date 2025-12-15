package TokoSepatu;

public class Tampilkan {

    public static void tampilkanData(int mode, String[][] data, int count) {

        if (count == 0) {
            System.out.println("=== ADMIN TOKO SEPATU LARIS ===");
            System.out.println("\nData sepatu belum ada.\n");
            return;
        }

        // Salin data
        String[][] copy = new String[count][7];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 7; j++) {
                copy[i][j] = data[i][j];
            }
        }

        // Sorting berdasarkan harga total (index 5)
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                int h1 = Integer.parseInt(copy[j][5]);
                int h2 = Integer.parseInt(copy[j + 1][5]);

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
            if (copy[i][6].equalsIgnoreCase("PROSES")) {
                cetakBaris(copy[i]);
            }
        }
        garis();

        // ================= TABEL LUNAS =================
        System.out.println("\nPESANAN LUNAS");
        cetakHeader();

        for (int i = 0; i < count; i++) {
            if (copy[i][6].equalsIgnoreCase("LUNAS")) {
                cetakBaris(copy[i]);
            }
        }
        garis();
    }

    // ===== Helper Method =====
    static void cetakHeader() {
        System.out.printf(
            "%-5s %-15s %-12s %-10s %-12s %-15s\n",
            "ID", "Merk", "Harga", "Jarak", "Ongkir", "Total"
        );
        garis();
    }

    static void cetakBaris(String[] d) {
        System.out.printf(
            "%-5s %-15s Rp%-10s %-10s Rp%-10s Rp%-12s\n",
            d[0], d[1], d[2], d[3], d[4], d[5]
        );
    }

    static void garis() {
        System.out.println("--------------------------------------------------------------------------");
    }
}
