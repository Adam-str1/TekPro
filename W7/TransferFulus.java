
class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account(); // Membuat objek dari class Account
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Mengunci akses ke objek acc1
                System.out.println("Thread t1 Mengunci akses ke objek acc1. Thread t1 masuk ke keadaan sleep");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulasi dengan memberikan jeda. Mengapa diperlukan Exception?
                // Exception diperlukan sebagai persiapan jika terjadi kondisi interrupt pada thread t1

                synchronized (acc2) { // thread t1 mengunci akses ke objek acc2
                    System.out.println("Thread t1 mengunci akses ke objek acc2. Thread t1 menjalankan program untuk menambahkan balance yang ada di acc1 ke acc2");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // Thread t2 mengunci akses ke objek acc1. // Urutan pengunciannya, yaitu acc1 lalu acc2, disamakan dengan t1.
                // Hal ini dilakukan untuk menghindari deadlock. Jadi ketika t1 mengunci objek ke acc1, t2 akan menunggu pelepasan kunci acc 1 sehingga t1 bisa lanjut mengunci acc2
                    System.out.println("Thread t2 mengunci akses ke objek acc1. Thread t2 menjalankan program untuk menambahkan balance yang ada di acc2 ke acc1");
                    acc1.balance += acc2.balance;
                synchronized (acc2) { // Thread t2 mengunci akses ke objek acc2
                    System.out.println("Thread t2 megunci akses ke objek acc2. Thread t2 masuk ke keadaan sleep");
                    try { Thread.sleep(100); } catch (Exception e) {} // Thread t2 masuk ke keadaan sleep, exception diperlukan sebagai persiapan untuk kondisi jika thread diinterrupt
                
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
		System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}
