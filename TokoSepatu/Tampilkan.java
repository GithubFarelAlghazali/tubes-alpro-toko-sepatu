package TokoSepatu;

public class Tampilkan {
    public static void tampilkanData(int mode, String[][] data) {
        String[][] copy = new String[data.length][3];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = data[i][j];
            }
        }

        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - i - 1; j++) {
                int h1 = Integer.parseInt(copy[j][1]);
                int h2 = Integer.parseInt(copy[j + 1][1]);

                boolean kondisi = (mode != 1) ? h1 > h2 : h1 < h2;  
                if (kondisi) {
                    String[] temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }

        
        System.out.println("\n==== DATA SEPATU ====\n");

        System.out.printf("%-15s %-12s %-10s\n", "Merk", "Harga", "Jarak");
        System.out.println("------------------------------------------");

        for (int i = 0; i < copy.length; i++) {
            System.out.printf("%-15s Rp%-10s %-10s\n",
                    copy[i][0], copy[i][1], copy[i][2]);
        }

        System.out.println("------------------------------------------\n");
    }
}
