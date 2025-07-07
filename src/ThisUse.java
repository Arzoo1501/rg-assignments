public class ThisUse extends Super2 {
    int num;

    public ThisUse(int num) {
        this.num = num; // Assigns constructor parameter to the instance variable of ThisUse
    }

    public void display() {
        System.out.println("display method");
    }

    public void Show() {
        this.display();         // calls display() of ThisUse class
        display();              // same as above; calls ThisUse.display()
        System.out.println(this.num);  // prints ThisUse.num (which is 10)
        System.out.println(num);       // same as above (10)
    }

    public static void main(String[] args) {
        ThisUse o = new ThisUse(10);
        o.Show();
    }
}
