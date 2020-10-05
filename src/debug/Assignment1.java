package debug;
import java.text.DecimalFormat;
import java.util.Random;

public class Assignment1 {
    private static final double square = 2.0;
    private static Random random = new Random();
    public static void main(String[] args) {
        double base, height , hyp;
        base = random.nextInt(6) ;
        height = random.nextInt(6);
        hyp = Math.sqrt(Math.pow(base, square) + Math.pow(height, square));
        System.out.println("Base : "+ DecimalFormat.getInstance().format(base));
        System.out.println("Height : "+ DecimalFormat.getInstance().format(height));
        System.out.println("Hyp : "+ DecimalFormat.getInstance().format(hyp));
    }
}
