package Nomor_2;

public class Cylinder extends Shape {
    double radius;
    double heigth;

    public Cylinder(double r, double h){
        super("Cylinder");
        radius = r;
        heigth = h;
    }

    public double area(){
        return Math.PI*radius*radius*heigth;
    }

    public String toString(){
        return super.toString() + " of radius " + radius + " and height " + heigth;
    }
}
