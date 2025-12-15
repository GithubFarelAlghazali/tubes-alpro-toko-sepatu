package TokoSepatu;
import java.util.Scanner;

public class Main{

    static String[][] dataSepatu = {
    { "Nike", "120000", "1km" },
    {"Rebook", "100000", "90km"},
    {"Adidas", "250000", "250km"}, 
    {"Water Jordan", "500000", "100km"}};

    static void editData(Scanner scanner){
        Tampilkan.tampilkanData(1, dataSepatu);
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

        Tampilkan.tampilkanData(1, dataSepatu);

    }

     static void hapusData(Scanner scanner){
        Tampilkan.tampilkanData(1, dataSepatu);
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
        Tampilkan.tampilkanData(1, dataSepatu);

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
                Tampilkan.tampilkanData(mode, dataSepatu);
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