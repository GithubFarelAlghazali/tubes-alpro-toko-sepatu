import java.util.Scanner;

public class TokoSepatu{
    static String[][] dataSepatu = new String[100][3];
    static int count = 0;

    static void tampilkanDataSepatu(int mode) {
    String[][] copy = new String[dataSepatu.length][3];
    for (int i = 0; i < dataSepatu.length; i++) {
        for (int j = 0; j < 3; j++) {
            copy[i][j] = dataSepatu[i][j];
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

    static void editData(Scanner scanner){
        tampilkanDataSepatu(1);
        System.out.println();
        System.out.print("Pilih merk yang ingin diedit: ");
        scanner.nextLine();
        String merk = scanner.nextLine();
        int edited = 0;
        boolean isHere = false;
        for(int i = 0; i < dataSepatu.length; i++){
            if(dataSepatu[i][0].toLowerCase().equals(merk.toLowerCase())){
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

        dataSepatu[edited][1] = harga ;
        dataSepatu[edited][2] = jarak + "km";

        tampilkanDataSepatu(1);

    }

     static void hapusData(Scanner scanner){
        tampilkanDataSepatu(1);
        System.out.println();
        System.out.print("Pilih merk yang ingin diedit: ");
        String merk = scanner.next();
        int edited = 0;
        boolean isHere = false;
        for(int i = 0; i < dataSepatu.length; i++){
            if(dataSepatu[i][0].toLowerCase().equals(merk.toLowerCase())){
                edited = i;
                isHere = true;
            }
        }

        if(!isHere){
            System.out.println("Merek tidak ada boss");
            return;
        }

        String[][] newArray = new String[dataSepatu.length - 1][3];
        int pos = 0;

        for (int i = 0; i < dataSepatu.length; i++) {
            if(i != edited){
            newArray[pos] = dataSepatu[i];
            pos++;} 
        }

        dataSepatu = newArray;
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