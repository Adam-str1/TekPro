import java.util.Scanner;

public class Jumlah {
    public static void main(String args[]) throws InterruptedException{
       // Variabel
       int nT; // Banyak thread yang ingin dibuat
       int N; // Angka terakhir
       int sisa; // Sisa bagi N dengan nT
       int hasil; // Hasil bagi N dengan nT
       SumThread[] r;
       Thread[] Threads; // Array of thread
       int jumlah = 0; // Jumlah hasil parsial masing-masing thread
       
       
       Scanner input = new Scanner(System.in);

       /* Program */
       
       // Input user
       System.out.print("Masukkan angka terakhir  : ");
       N = input.nextInt();
       System.out.print("Masukkan jumlah thread : ");
       nT = input.nextInt();


       // Atur panjang array dan simpan hasil bagi dan sisa bagi
       Threads = new Thread[nT]; 
       r = new SumThread[nT]; // Sebagai penyimpan hasil parsial tiap thread
       int[] bagian = new int[nT]; // Daftar angka terakhir pembagian tugas
       sisa = N%nT;
       hasil = N/nT;

       // Bagi tugas
       for (int i = 0; i < nT; i++){
            bagian[i] = hasil*(i+1); // Bagi rata terlebih dahulu pembagiannya
       }

       int k = 0;

       // Bagi rata sisa bagi yang ada
       for (int i = 0; i < sisa; i++){
            for (int j = 0 + k; j < nT; j++){
                bagian[j] += 1;
            }
            k += 1;
            if (k == nT){
                k = 0; // Isi lagi dari awal
            }
       }
       
       // Atur tugas untuk thread 
       k = 0;
       for (int i = 0; i < nT; i++){
            r[i] = new SumThread(k,bagian[i]);
            k = bagian[i] + 1;
       }

       // Jalankan thread
       for (int i = 0; i < nT; i++){
            Threads[i] = new Thread(r[i]);
            Threads[i].start();
       }


       // Tunggu thread selesai dan tambahkan hasil parsialnya
       for (int i = 0; i < nT; i++){
            Threads[i].join();
            System.out.println("Hasil akhir sementara : " + jumlah + " + "+ r[i].getHasil());
            jumlah += r[i].getHasil();
       }
       
       input.close();

       // Output Hasil akhir
       System.out.println("Penjumlahan akhirnya : " + jumlah);
       
    }
}

class SumThread implements Runnable{
    private int angkaAwal;
    private int angkaAkhir;
    private int hasil = 0;

    public SumThread(int mulai, int akhir){
        angkaAwal = mulai;
        angkaAkhir = akhir;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " menghitung dari " + angkaAwal + " hingga "+ angkaAkhir);
        // Hitung jumlah parsial
        for (int i = angkaAwal; i <= angkaAkhir; i++){
            hasil += i;
        }

        System.out.println("Hasil perhitungan dari " + Thread.currentThread().getName() + " : " + getHasil());
    }

    /* Getter */
    public int getHasil(){
        return hasil;
    }
}
