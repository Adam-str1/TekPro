import java.util.Scanner;

public class W1DataTypes{
    public static void main(String[] args){
        // Declare variabel
        byte T; // Byte dipakai karena T tidak untuk angka yang besar

        Scanner input = new Scanner(System.in);

        // Input User
        do {
            T = input.nextByte();
            if (T > 25 || T < 1){
                System.out.println("Angka haruslah positif dan tidak lebih dari 25");
            }
        } while (T > 25); /* Looping input untuk memastikan angka yang dimasukkan tidak 
        terlalu banyak mengingat nanti variabel T akan dipakai sebagai panjang dari
        array of long. long sendiri butuh memori yang banyak.*/

        long[] angka = new long[T];
        for (int i = 0; i < T; i++){
            angka[i] = input.nextLong();
        }

        // Program
        String[] tipe = {"byte","short","int","long"};
        int index;

        System.out.println("\n Output Program\n");
        
        for (int i = 0; i < T; i++){
            // Cek range angka

            if (angka[i] >= -128 && angka[i] <= 127){
                index = 0;
            } else if (angka[i] >= -32768 && angka[i] <= 32767 ){
                index = 1;
            } else if (angka[i] >= -2147483648 && angka[i] <= 2147483647){
                index = 2;
            } else {
                index = 3;
            }

            // Output
            System.out.printf("%d can be fitted in :\n", angka[i]);
            for (int j = index; j < 4; j++){
                System.out.println("* " + tipe[j]);
            }
            
        }
        input.close();
    }


}