package TokoSepatu;

public class Tampilkan {
    public static void tampilkanData(int mode, String[][] data, int count) {
        if (count == 0) {
        System.out.println("=== ADMIN TOKO SEPATU LARIS ===");
        System.out.println("\nData sepatu belum ada. Silakan input data terlebih dahulu\n");
        return;
    }
    
    String[][] copy = new String[count][5];
    for (int i = 0; i < count; i++) {
        for (int j = 0; j < 5; j++) {
            copy[i][j] = data[i][j];
            }
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                int h1 = Integer.parseInt(copy[j][4]);
                int h2 = Integer.parseInt(copy[j + 1][4]);
                
                boolean kondisi = (mode != 1) ? h1 > h2 : h1 < h2;  
                if (kondisi) {
                    String[] temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }

        
        System.out.println("=== ADMIN TOKO SEPATU LARIS ===");
        System.out.println("\nDAFTAR PESANAN");

        System.out.printf("%-15s %-12s %-10s %-10s %-15s\n", "Merk", "Harga", "Jarak", "PPN", "Harga Total");
        System.out.println("---------------------------------------------------------------------------------");
        
        for (int i = 0; i < count; i++) {
            System.out.printf("%-15s %-12s %-10s %-10s %-15s\n", copy[i][0], "Rp" + copy[i][1], copy[i][2], "Rp" + copy[i][3], "Rp" + copy[i][4]);
        }
        
        System.out.println("---------------------------------------------------------------------------------");
        
    }
}
