public class TaxUtil {
    double rate = 0.15;
 
    public double calculateTax(double amount) {
        return amount * rate;
    }
 
//updated, pure function

    public double calculateTaxPure(double amount, double rate) {
        return amount * rate;
    }

    public static void main(String[] args) {
        //task1
        TaxUtil tax = new TaxUtil();
       double res1 = tax.calculateTax(50);
       double res2 = tax.calculateTaxPure(40, 2);
       System.out.println(res1);
       System.out.println(res2);

       
    }
}    
 