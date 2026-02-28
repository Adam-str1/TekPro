import java.util.Scanner;

public class TestCylinder {
    
    public static void main(String[] args){
        // Declaration var
        Scanner input = new Scanner(System.in);

        double radius;
        String color;
        double height;
        
        int menu;
        
        // Program
        Cylinder cyl = new Cylinder();

        System.out.println("Objek silinder dibuat");
        do {
            System.out.println(cyl.toString()); // Tampil atribut silinder
            tampilMenu();
            menu = input.nextInt();
            input.nextLine(); // Bersihkan buffer
            if (menu == 1){
                System.out.print("Masukkan panjang radius : ");
                radius = input.nextDouble();
                cyl.setRadius(radius);
            } else if (menu == 2){
                System.out.print("Masukkan tinggi silinder : ");
                height = input.nextDouble();
                cyl.setHeight(height);
            } else if (menu == 3){
                System.out.print("Warna silinder : ");
                color = input.nextLine();
                cyl.setColor(color);
            } else if (menu == 4){
                System.out.print("Luas alas : ");
                System.out.println(cyl.getArea());
            } else if (menu == 5){
                System.out.print("Volume silinder : ");
                System.out.println(cyl.getVolume());
            } else if (menu == 6){
                System.out.println("Program selesai");
            } else {
                System.out.println("Menu tidak valid");
            }

        

        } while (menu != 6);
        input.close();
    }
    private static void tampilMenu(){
        System.out.println("--------Daftar Menu--------");
        System.out.println("1. Ubah nilai radius");
        System.out.println("2. Ubah tinggi silinder");
        System.out.println("3. Atur warna silinder");
        System.out.println("4. Hitung luas alas");
        System.out.println("5. Hitung volume silinder");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu : ");
    }

}
