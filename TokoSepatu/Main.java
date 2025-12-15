package TokoSepatu;

import java.util.Scanner;

public class Main{

    static String[][] dataSepatu = new String[100][7];
    static int count = 0;
    static int mode = 1;


    static int pilihMenu(Scanner scanner){
        System.out.println("Opsi: ");
        System.out.println("1. " + (mode == 1 ? "Urutkan dari murah -> mahal" : "Urutkan dari mahal -> murah"));
        System.out.println("2. Input data sepatu");
        System.out.println("3. Edit data sepatu");
        System.out.println("4. Hapus data sepatu");
        System.out.println("0. Keluar");
        System.out.print("Pilih opsi: ");
        int menu = scanner.nextInt();
        return menu;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        
        while (run) {
            Utils.clearScreen();
            Tampilkan.tampilkanData(mode, dataSepatu, count);

            int menu = pilihMenu(scanner);
           

            switch (menu) {
                case 1:
                    System.out.println("Urutkan dari: " + (mode == 1 ? "paling murah" : "paling mahal") + "(y/n):");
                    String input = scanner.next();
                   
                    if (mode == 1) {
                        if (input.equalsIgnoreCase("y")) {
                            mode = 2;
                        }
                    } else {
                        if (input.equalsIgnoreCase("y")) {
                            mode = 1;
                        }
                    }
                    break;
                case 2:
                    count = Input.inputSepatu(scanner, count, dataSepatu);
                    break;
                case 3:
                    Edit.editData(scanner, dataSepatu, count);
                    break;
                case 4:
                    count = Hapus.hapusData(scanner, dataSepatu, count);
                    break;
                case 0:
                    System.out.println("Program ditutup");
                    run = false;
                    break;
                default:
                    System.out.println("Input tidak terdaftar, masukkan sesuai daftar!");

                }
                Utils.pressToNext(scanner);
        }


    }
}