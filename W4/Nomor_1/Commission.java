package Nomor_1;

public class Commission extends Hourly {
    // Variable Instance
    double totalSale;
    double comRate = 0.2; // 20% Commission rate

    public Commission (String eName, String eAddress, String ePhone,String socSecNumber, double rate, double comRate)
    {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.comRate = comRate;
    }


    // give value to variable totalSales
    public void addSales(double totalSale){
        this.totalSale = totalSale;
    }

    public double pay(){
        double payment = super.pay() + totalSale;
        totalSale = 0;
        return payment;
    }

    public String toString(){
        String result = super.toString();
        result += "Total sales : " + totalSale;
        return result;
    }
}
