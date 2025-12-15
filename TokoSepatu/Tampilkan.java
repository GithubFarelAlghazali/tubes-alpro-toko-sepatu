package TokoSepatu;

public class Tampilkan {

    static boolean adaStatus(String[][] data, int count, String status) {
        for (int i = 0; i < count; i++) {
            if (data[i][8].equalsIgnoreCase(status)) {
                return true;
            }
        }
    return false;
    }


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
                int h1 = Integer.parseInt(copy[j][7]);
                int h2 = Integer.parseInt(copy[j + 1][7]);

                boolean kondisi = (mode == 1) ? h1 < h2 : h1 > h2;
                if (kondisi) {
                    String[] temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }
        
        if (adaStatus(data, count, "lunas")) {
            
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
        }
            
            if (adaStatus(data, count, "LUNAS")) {       
                System.out.println("\nPESANAN LUNAS");
                cetakHeader();
                
                for (int i = 0; i < count; i++) {
                    if (copy[i][8].equalsIgnoreCase("LUNAS")) {
                        cetakBaris(copy[i]);
                    }
                }
                garis();
            }
        }

    
    static void cetakHeader() {
        System.out.printf(
            "%-12s %-18s %-15s %-10s %-15s %-15s %-20s %-15s\n",
            "Merk", "Jenis", "Harga", "Jarak","Alamat", "Ongkir", "Total (belum PPN)" , "PPN"
        );
        garis();
    }

    static void cetakBaris(String[] d) {
        System.out.printf(
            "%-12s %-18s %-15s %-10s %-15s %-15s %-20s %-15s\n",
            d[0], d[1], "Rp"+d[2], d[3]+" km", d[4], "Rp"+d[5], "Rp"+d[6], "Rp"+d[7]
        );
    }

    static void garis() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
