public class rectangle extends Shape{
    double width = 1.0;
    double length = 1.0;

    public rectangle(){
        width = 1.0;
        length = 1.0;
    }

    public rectangle(double w, double l){
        width = w;
        length = l;
    }

    public rectangle(double w, double l, String c, boolean f){
        super(c,f);
        width = w;
        length = l;
    }

    // Getter and setter
    public double getWidth(){
        return width;
    }

    public double getLength(){
        return length;
    }

    public void setWidth(double w){
        width = w;
    }

    public void setLength(double l){
        length = l;
    }

    public double getArea(){
        return width*length;
    }

    public double getPerimeter(){
        return 2*(width + length);
    }

    public String toString(){
        return "A rectangle with width = " + width + " and length = " + length + ", which is a subclass of " + super.toString();
    }
}
