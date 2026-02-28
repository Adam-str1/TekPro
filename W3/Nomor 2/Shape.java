public class Shape {
    // Deklarasi variabel
    String color = "red";
    boolean filled = true;

    public Shape(){
        color = "green";
        filled = true;
    }

    public Shape(String c, boolean f){
        color = c;
        filled = f;
    }

    // Getter and Setter
    public String getColor(){  
        return color;
    }

    public boolean isFilled(){
        return filled;
    }

    public void setColor(String c){
        color = c;
    }

    public void setFilled(boolean f){
        filled = f;
    }

    public String toString(){
        String isFilled;
        if (filled = true){
            isFilled = "filled";
        } else {
            isFilled = "not filled";
        }
        return "A shape with color of " + color + " and " + isFilled;
    }
}
