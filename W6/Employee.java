public class Employee{
    private String Name;
    private float Salary;


    /* Constructor */
    public Employee(String N, float S){
        Name = N;
        Salary = S;
    }

    /* Getter and Setter */

    public String getName(){
        return Name;
    }

    public float getSalary(){
        return Salary;
    }

    public void setName(String N){
        Name = N;
    }

    public void setSalary(float S){
        Salary = S;
    }

    public String toString(){
        return "Nama : " + Name + ", Salary : " + Salary;
    }


}