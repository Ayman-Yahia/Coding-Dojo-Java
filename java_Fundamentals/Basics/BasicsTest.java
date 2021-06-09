public class BasicsTest {
    public static void main(String[] args){
        Basics test=new Basics();
        test.print1to255();
        test.printOdd();
        test.printSum();
        int[] x={1,3,5,7,9,13};
        test.interateArray(x);
        int[] y={-3,-5,-7};
        test.findMax(y);
        int[] m={2,10,3};
        test.getAvg(m);
        test.arrayOddNum();
        int[] s={1,3,5,7,3};
        test.greaterThanY(s,3);
        int[] e={1,5,10,-2};
        test.squareValues(e);
        int[] i={1,5,10,-2};
        test.eliminateNegNums(i);
        int[] u={1,5,10,-2};
        test.maxMinAvg(u);
        int[] j={1,5,10,7,-2};
        test.shiftArray(j);
    }
}