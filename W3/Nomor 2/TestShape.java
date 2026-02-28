public class TestShape {
    public static void main(String[] args){
        Shape bentuk1 = new Shape();
        System.out.println("Membuat objek dari shape dengan constructor 1");
        System.out.println(bentuk1.toString());
        
        Shape bentuk2 = new Shape("blue", true);
        System.out.println("Membuat objek dari shape dengan constructor 2");
        System.out.println(bentuk2.toString());

        bentuk1.setColor("black");
        bentuk1.setFilled(false);
        System.out.println("setColor dengan 'black' ");
        System.out.println("setFilled dengan false");
        System.out.println("Color setelah diset : " + bentuk1.getColor());
        System.out.println("Filled setelah diset : " + bentuk1.isFilled());

        square bentuk3 = new square();
        System.out.println(bentuk3.toString());
        System.out.println("Luas area persegi : " + bentuk3.getArea());
        System.out.println("Keliling area persegi : " + bentuk3.getPerimeter());
        bentuk3.setSide(3);
        System.out.println("Setelah disetSide, width = " + bentuk3.getWidth() + " Length = " + bentuk3.getLength());
        System.out.println("Nilai side : " + bentuk3.getSide());
        System.out.println("Luas area persegi : " + bentuk3.getArea());
        System.out.println("Keliling area persegi : " + bentuk3.getPerimeter());
        bentuk3.setLength(5);
        System.out.println("Setelah disetLength, width = " + bentuk3.getWidth() + " Length = " + bentuk3.getLength());
        System.out.println("Nilai side : " + bentuk3.getSide());
        System.out.println("Luas area persegi : " + bentuk3.getArea());
        System.out.println("Keliling area persegi : " + bentuk3.getPerimeter());
        bentuk3.setWidth(7);
        System.out.println("Setelah disetWidth, width = " + bentuk3.getWidth() + " Length = " + bentuk3.getLength());
        System.out.println("Nilai side : " + bentuk3.getSide());
        System.out.println("Luas area persegi : " + bentuk3.getArea());
        System.out.println("Keliling area persegi : " + bentuk3.getPerimeter());
    }
}
