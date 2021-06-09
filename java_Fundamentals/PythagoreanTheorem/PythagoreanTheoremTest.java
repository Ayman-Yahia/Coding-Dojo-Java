import java.lang.Math;
public class PythagoreanTheoremTest {
    public double calculteHypotenuse(int A, int B){
        double C = (A)^2 + (B)^2;          
        double squareRoot =  Math.sqrt(C);
        return squareRoot;
    }
}