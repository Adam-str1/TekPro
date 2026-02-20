package id.ac.polban.employee.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class utama {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        // Field
        int menu;
        int jumlahKaryawan = 0;

        int id;
        String nama;
        Department department = new Department("Default");
        EmploymentType type = new EmploymentType("Default");
        double salary;
        String jenisPekerjaan;

        List<Integer> daftarID = new ArrayList<>();

        Employee karyawan;

        double percent;

        int depart;

        int cariId;

        EmployeeService service = new EmployeeService();


        /* Program */
        do {
        // Tampilkan menu awal
        tampilmenu();
        
        // Input menu
        System.out.print("Pilih aksi : ");
        menu = input.nextInt();
        input.nextLine(); // Bersihkan buffer
        

        if (menu == 1){
            // Menu 1, Daftar Karyawan
            if (jumlahKaryawan != 0){
                for (int i = 0; i < jumlahKaryawan; i++){
                    karyawan = service.getEmployee(daftarID.get(i));
                    System.out.println((i + 1) + ". " + karyawan.getName() + " (" + karyawan.getId() + ")");
                }
            } else {
                System.out.println("Belum ada karyawan yang ditambahkan");
            }

        } else if (menu == 2){
            // Menu 2, Tambah Karyawan

            // Input data karyawan

            System.out.print("Masukkan nama karyawan : ");
            nama = input.nextLine();
            System.out.print("Masukkan id karyawan : ");
            id = input.nextInt();
            daftarID.add(id);
            input.nextLine(); // Bersihkan buffer
            tampilDepartement();
            System.out.print("Pilih Departemen : ");
            depart = input.nextInt();
            department.setName(simpanDepartement(depart));
            input.nextLine(); // Bersihkan buffer
            System.out.print("Masukkan jenis pekerjaan : ");
            jenisPekerjaan = input.nextLine();
            type.setType(jenisPekerjaan);
            System.out.print("Masukkan jumlah gaji : ");
            salary = input.nextDouble();
            jumlahKaryawan = jumlahKaryawan + 1;


            // Simpan data karyawan
            karyawan = new Employee(id, nama, department, type, salary);
            service.addEmployee(karyawan);
        } else if (menu == 3){
            // Menu 3, Lihat info karyawan
            System.out.print("Masukkan id karyawan yang ingin dicari : ");
            cariId = input.nextInt();
            input.nextLine(); // Bersihkan buffer

            karyawan = service.getEmployee(cariId);
            if (karyawan != null){
                tampilKaryawan(karyawan);
            } else {
                System.out.println("Karyawan tidak ditemukan");
            }
            
        } else if (menu == 4){
            // Menu 4, Tambah gaji karyawan
            System.out.print("Masukkan id karyawan : ");
            cariId = input.nextInt();
            input.nextLine(); // Bersihkan buffer

            // Tambah gaji
            System.out.print("Masukkan besar kenaikan gaji (persentase) : ");
            percent = input.nextDouble();
            service.raiseSalary(cariId, percent);
        } else if (menu == 5){
            System.out.println("End of Program");
        }
        

        } while (menu != 5);

        input.close();
    }

    /* Method */

    // Tampilkan menu awal
    private static void tampilmenu(){
        System.out.println("--------Daftar Aksi--------");
        System.out.println("1. Daftar Karyawan \n2. Tambah karyawan\n3. Lihat info karyawan\n4. Tambah gaji karyawan\n5. Keluar");
    }
    
    // Tampilkan daftar departemen
    private static void tampilDepartement(){
        System.out.println("Daftar Departemen");
        System.out.println("1. Departemen Keuangan\n2. Departemen Sumber Daya Manusia\n3. Departemen Pemasaran\n4. Departemen Penjualan\n5. Departemen IT");
    }

    // Simpan data departemen ke field
    private static String simpanDepartement(int nomor){
        if (nomor == 1){
            return "Departemen Keuangan";
        } else if (nomor == 2){
            return "Departemen Sumber Daya Manusia";
        } else if (nomor == 3){
            return "Departemen Pemasaran";
        } else if (nomor == 4){
            return "Departemen Penjualan";
        } else if (nomor == 5){
            return "Departemen IT";
        } else {
            return "Departemen apa nich";
        }
    }

    // Tampil info karyawan
    private static void tampilKaryawan(Employee karyawan){
        Department department = karyawan.getDepartment();
        EmploymentType type = karyawan.getType();
        System.out.println("Nama : " + karyawan.getName());
        System.out.println("ID : " + karyawan.getId());
        System.out.println("Departemen : " + department.getName());
        System.out.println("Jenis Pekerjaan : " + type.getType());
        System.out.println("Gaji : " + karyawan.getSalary());
    }

}
