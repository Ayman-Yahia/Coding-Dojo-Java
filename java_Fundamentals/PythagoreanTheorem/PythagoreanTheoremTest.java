import java.lang.Math;
public class PythagoreanTheoremTest {
    public double calculteHypotenuse(int A, int B){
        double C = (A)*(A) + (B)*(B);          
        double squareRoot =  Math.sqrt(C);
        return squareRoot;
    }
}