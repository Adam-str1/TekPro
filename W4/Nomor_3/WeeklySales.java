package Nomor_3;

// *************************************************************
// WeeklySales.java
//
// Sorts the sales staff in descending order by sales.
// ************************************************************

import java.util.Scanner;
public class WeeklySales {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstName,LastName;
        int totalSales,size;
        
        do {
            System.out.println("Masukkan jumlah karyawan (Maksimal 10) : ");
            size = input.nextInt();
            input.nextLine();
        } while (size > 10 || size < 0);
        Salesperson[] salesStaff = new Salesperson[size];
        
        for (int i = 0; i < size; i++){
            System.out.println("Masukkan nama depan : ");
            firstName = input.nextLine();
            System.out.println("Masukkan nama belakang : ");
            LastName = input.nextLine();
            System.out.println("Masukkan total penjualan : ");
            totalSales = input.nextInt();
            input.nextLine();
            salesStaff[i] = new Salesperson(firstName, LastName, totalSales);
        }

        Sorting.insertionSort(salesStaff);
        System.out.println("\nRanking of Sales for the Week\n");
        for (int i = 0; i < size; i++){
            System.out.println(salesStaff[i]);
        }
    }
    
}
