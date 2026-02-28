package Nomor_3;

public class ManagerTest {
    public static void main(String[] args) {
        // Mendeklarasikan dan mengalokasikan array untuk 3 objek Employee
        Employee[] staff = new Employee[3];
        // Mengisi array dengan kombinasi Employee dan Manager (Polimorfisme)
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Manager("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);
        // Menaikkan gaji semua staf sebesar 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }
        // Mencetak data setiap staf

        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        Employee tempo = new Employee(null, 0, 0, 0, 0);
        for (int i = 0; i < 2; i++) {
            int k = 0;
            for (int j = 1; j < (3 - i); j++) {
                if (staff[k].compare(staff[j]) == -1) {
                    tempo = staff[k];
                    staff[k] = staff[j];
                    staff[j] = tempo;
                }

                k = k + 1;
            }
        }

        // Mencetak data dari setiap staf
        System.out.println("Data setelah diurutkan descendeing berdasarkan salary");
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }
    }

}