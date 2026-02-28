public class circle extends Shape {
    double radius = 1.0;
    private final double phi = 3.14;

    // Constructors
    public circle(){
        radius = 1.0;
    }

    public circle(double r){
        radius = r;
    }

    public circle(double radius, String color, boolean filled){
        super(color,filled);
    }

    // Getter and Setter
    public double getRadius(){
        return radius;
    }

    public void setRadius(double r){
        radius = r;
    }

    public double getArea(){
        return phi*phi*radius;
    }

    public double getPerimeter(){
        return 2*phi*radius;
    }

    public String toString(){
        return "A Circle with radius = " + radius + ", which is a subclass of " + super.toString();
    }
}
