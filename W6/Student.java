
public class Student {
    // Attribute
    private int ID;
    private String Nama;

    // Concsturctor with 2 parameters
    public Student(int I, String N){
        ID = I;
        Nama = N;
    }

    /* Getter and Setter */

    public String getName(){
        return Nama;
    }

    public int getId(){
        return ID;
    }

    public void setName(String N){
        Nama = N;
    }

    public void setId(int I){
        ID = I;
    }

    public String toString(){
        return "Nama : " + Nama + ", Salary : " + ID;
    }

}
