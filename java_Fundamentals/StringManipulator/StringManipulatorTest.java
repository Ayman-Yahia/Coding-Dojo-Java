public class StringManipulatorTest {
    public static void main(String[] args){
        StringManipulator test = new StringManipulator();
        System.out.println(test.trimAndConcat("   Coding ", "  Dojo  Seattle  "));
        System.out.println(test.trimAndConcat("   Coding ", "  Dojo  "));

        Integer a = test.getIndexOrNull("Coding", 'g');
        System.out.println(a);

        Integer b = test.getIndexOrNull("Coding Dojo", "Dojo");
        System.out.println(b);

        String word = test.concatSubstring("Hello", 2, 3, "World");
        System.out.println(word);
    }
}