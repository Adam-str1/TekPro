package Nomor_2;

abstract public class Shape {
    String shapeName;

    public abstract double area();

    public Shape(String name){
        shapeName = name;
    }

    public String toString(){
        return shapeName;
    }
}
