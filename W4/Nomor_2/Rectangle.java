package Nomor_2;

public class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(double l, double w){
        super("Cylinder");
        length = l;
        width = w;
    }

    public double area(){
        return length*width;
    }

    public String toString(){
        return super.toString() + " of length " + length + " and width " + width;
    }
}
