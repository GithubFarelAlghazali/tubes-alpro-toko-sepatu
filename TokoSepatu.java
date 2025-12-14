import java.util.Scanner;

public class TokoSepatu{
    static String[][] dataSepatu = new String[100][5];
    static int count = 0;

    static void tampilkanDataSepatu(int mode) {
        if (count == 0) {
            System.out.println("Data sepatu belum ada. Silakan input data terlebih dahulu.");
            return;}
            
        String[][] copy = new String[count][5];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 5; j++) {
                copy[i][j] = dataSepatu[i][j];
                }
            }

        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - i - 1; j++) {
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

        System.out.println("\n==== DATA SEPATU ====\n");
        System.out.printf("%-15s %-12s %-10s %-15s %-15s\n", "Merk", "Harga", "Jarak (km)","PPN","Total Bayar");
        System.out.println("------------------------------------------------------------------------------------\n");

        for (int i = 0; i < copy.length; i++) {
            String merk = copy[i][0];
            String harga = copy[i][1];
            String jarak = copy[i][2];
            String ppn = copy[i][3];
            String totalPPN = copy[i][4];
            System.out.printf("%-15s Rp%-10s %-10s Rp%-15s Rp%-15s\n",merk, harga, jarak, ppn , totalPPN);}

        System.out.println("------------------------------------------------------------------------------------\n");
    }

    static int cariMerk(String merk){
        int index = -1;
        for(int i = 0; i < count; i++){
            if(dataSepatu[i][0].toLowerCase().equals(merk.toLowerCase())){
                index = i;
            }
        }
        return index;
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
        int ongkir;

            if (jarak <= 10) {
                ongkir = 10000;
            } else {
                ongkir = 20000;
            }

            int totalSebelumPPN = harga + ongkir;
            double ppn = totalSebelumPPN * 0.1;
            double totalPPN = totalSebelumPPN + ppn;

        dataSepatu[count][0] = merk;
        dataSepatu[count][1] = String.valueOf(harga);
        dataSepatu[count][2] = String.valueOf(jarak);
        dataSepatu[count][3] = String.valueOf((int) ppn);
        dataSepatu[count][4] = String.valueOf((int) totalPPN);

        count++;

        System.out.println("Data sepatu berhasil ditambahkan.");
    }

    static void editData(Scanner scanner){
        tampilkanDataSepatu(1);
        System.out.println();
        System.out.print("Pilih merk yang ingin diedit: ");
        scanner.nextLine();
        String merk = scanner.nextLine();
        int edited = cariMerk(merk);

        if(edited < 0){
            System.out.println("Merek tidak ada boss");
            return;
        }

        System.out.print("Edit harga: ");
        String harga = scanner.next();
        System.out.print("Edit jarak: ");
        String jarak = scanner.next();
        int ongkir;

            if (Integer.parseInt(jarak) <= 10) {
                ongkir = 10000;
            } else {
                ongkir = 20000;
            }

            int totalSebelumPPN = Integer.parseInt(harga) + ongkir;
            double ppn = totalSebelumPPN * 0.1;
            double totalPPN = totalSebelumPPN + ppn;


        dataSepatu[edited][1] = harga;
        dataSepatu[edited][2] = jarak;
        dataSepatu[edited][3] = String.valueOf((int) ppn);
        dataSepatu[edited][4] = String.valueOf((int) totalPPN);

        tampilkanDataSepatu(1);

    }

    static void hapusData(Scanner scanner){
        tampilkanDataSepatu(1);
        System.out.println();
        System.out.print("Pilih merk yang ingin diedit: ");
        String merk = scanner.next();
        int deleted = cariMerk(merk);
        if(deleted < 0){
            System.out.println("Merek tidak ada boss");
            return;
        }

        for (int i = deleted; i < count - 1; i++) {
           dataSepatu[i] = dataSepatu[i + 1];
        }

        dataSepatu[count - 1] = new String[5]; 
        count--;

        tampilkanDataSepatu(1);

    }

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


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while(run){
        int menu = pilihMenu(scanner);

        switch(menu){
            case 1:
                System.out.println("Urutkan dari: ");
                System.out.println("1. Mahal -> Murah");
                System.out.println("2. Murah -> Mahal ");
                int mode = scanner.nextInt();
                tampilkanDataSepatu(mode);
            break;
            case 2:
                inputDataSepatu(scanner);
                break;
            case 3:
                editData(scanner);
            break;
            case 4:
                hapusData(scanner);
            break;
            case 0:
                System.out.println("Ceritanya kelar");
                run = false;
            break;
            default:
                System.out.println("Udah terserahh kelan");
        }
        }

    }
}