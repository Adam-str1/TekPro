public class square extends rectangle {

    
    public square(){
        double temporary = length;
        length = width;
        width = temporary;
    }

    public square(double side){
        super(side,side);
    }

    public square(double side, String c, boolean f){
        super(side,side,c,f);
    }

    public double getSide(){
        return width;
    }

    public void setSide(double s){
        width = s;
        length = s;
    }

    public String toString(){
        return "A square with side = " + width + ", which is a subclass of " + super.toString();
    }

    public void setWidth(double s){
        width = s;
        length = width;
    }

    public void setLength(double s){
        length = s;
        width = length;
    }
    
}
