import java.util.Scanner;

public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    private String nama;
    private int jumlah;
    private double harga;
    private int nstok;

    Scanner input = new Scanner(System.in);

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {

        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }

    public void tampilMenuMakanan() {
        char[] daftar = {'a','b','c','d'};
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(
                        daftar[i] + ". " + nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]);
            }
        }
    }

    public boolean isOutOfStock(int id) {
        if (stok[id] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setStock(int stokBaru) {
        this.stok[this.nstok] = stokBaru;
    }

    public int getStock(int nstok){
        return stok[nstok];
    }

    public boolean ValidStock() {
        if (getStock(this.nstok) < this.jumlah) {
            System.out.println("Stok tidak memenuhi");
            return false;
        } else {
            System.out.println("Stok tersedia");
            return true;
        }
    }

    // Perbarui jumlah stok
    public void nStok(){
        setStock(this.stok[nstok] - jumlah);
    }

    // Tampilkan jumlah stok saat ini
    public void tampilStok(){
        System.out.println("Stok " + this.nama + " : " + this.stok[nstok]);
    }

    // Tampilkan pesanan ditolak
    public void TampilTolak(){
        System.out.println("Pesanan ditolak");
    }

    // Tampilkan pesanan diterima
    public void TampilTerima(){
        System.out.println("Pesanan diterima");
        System.out.println("Rincian pesanan");
        System.out.println(this.nama + ", " + this.jumlah + " porsi, " + " Total harga : " + this.harga*(double)this.jumlah);
    }

    // Lanjut pesanan
    public boolean lanjutPesan(){
        char lanjut;
        System.out.print("Pesan lagi ? (y/n) : ");
        lanjut = input.next().charAt(0);
        input.nextLine();
        if (lanjut == 'y'){
            return true;
        } else {
            System.out.println("Pesanan selesai");
            return false;
        }
    }

    public void pesanMenu(){
        System.out.print("Masukkan makanan (a,b,c,d) : ");
        this.nama = input.nextLine();
        System.out.print("Masukkan jumlah porsi : ");
        this.jumlah = input.nextInt();
        if (this.nama.equals("a")){
            this.nstok = 0; // index stok
            this.nama = "Pizza";
            this.harga = 250000;
        } else if (this.nama.equals("b")){
            this.nstok = 1;
            this.nama = "Spaghetti";
            this.harga = 80000;
        } else if (this.nama.equals("c")){
            this.nstok = 2;
            this.nama = "Tenderloin Steak";
            this.harga = 60000;
        } else if (this.nama.equals("d")){
            this.nstok = 3;
            this.nama = "Chicken Steak";
            this.harga = 45000;
        } else {
            this.nama = "NotValid";
        }

    }

    public boolean ValidPesan(){
        if (this.nama.equals("NotValid")|| jumlah < 0){
            System.out.println("Pesanan tidak valid!");
            return false;
        } else {
            System.out.println("Pesanan valid");
            return true;
        }
    }

    public static void nextId() {
        id++;
    }
}
