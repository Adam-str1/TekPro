class Resto {
    private int chickenStock = 100;
    int turn = 1; // Sebagai pengatur giliran thread

    public void serveCustomer(String cashierName) {
        if (chickenStock > 0) {
            try { Thread.sleep(10); } catch (InterruptedException e) {}
            
            chickenStock--; 
            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto(); // Membuat objek dari class Resto
        
        Runnable task = () -> { // 
            for (int i = 0; i < 40; i++) {
                // Stop jika stock habis
                if (ayamJuicyLuicyGallagher.getRemainingStock() == 0){
                    break;
                }
                synchronized(ayamJuicyLuicyGallagher){ // Mengunci resource
                    String name = Thread.currentThread().getName(); // Ambil nama thread yang sedang mengunci
                    int myTurn = name.charAt(6) - 64; // Sebagai pengatur giliran thread

                    

                    while (ayamJuicyLuicyGallagher.turn != myTurn){ // Jika bukan gilirannya, maka lepas kunci
                        try {ayamJuicyLuicyGallagher.wait();} catch (Exception e){} // wait melepas kunci
                    }


                    ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName()); // Jalankan method
                    // ganti giliran
                    ayamJuicyLuicyGallagher.turn = (ayamJuicyLuicyGallagher.turn % 3) + 1; // Ganti giliran thread
                    
                    // Bangunkan thread yang sedang dalam keadaan wait
                    ayamJuicyLuicyGallagher.notifyAll(); // Thread yang dalam keadaan wait tidak bisa bangun sendiri
                    
                }
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        kasir1.start();
        kasir2.start();
        kasir3.start();

        kasir1.join();
        kasir2.join();
        kasir3.join();

        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}

