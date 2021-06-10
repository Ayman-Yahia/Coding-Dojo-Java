import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class CodeExample {
    public static void main(){

    }
    public static ArrayList printSum(int[] myArray){
        int sum = 0;
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i=0;i<myArray.length;i++){
            sum += myArray[i];
            if (myArray[i]>10){
                newArray.add(myArray[i]);
            }
        }
        System.out.println("sum of given array: "+sum);
        return newArray;
    }
    public static ArrayList printCharArr(){
        ArrayList<String> myCharArray = new ArrayList<String>();
        myCharArray.add("Nancy");
        myCharArray.add("Jinichi");
        myCharArray.add("Fujibayashi");
        myCharArray.add("Momochi");
        myCharArray.add("Ishikawa");
        Collections.shuffle(myCharArray);
        for (int i=0;i<myCharArray.size();i++){
            if (myCharArray.get(i).length()<6){
                myCharArray.remove(i);
            }
        }
        return myCharArray;
    }
    public static void shuffleArr(){
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Collections.shuffle(Arrays.asList(alphabet));
        String let = alphabet[0];
        
        System.out.println(let);
        System.out.println("first letter of Array : "+ let);
        System.out.println("Last letter of Array : "+ alphabet[25]);
        if (let == "a" || let == "e" || let == "i" || let == "o" || let == "u"){
            System.out.println("The first letter is a vowel");
        }
    }
    public static int[] randomArray(){
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i=0; i<10;i++){
            arr[i] = rand.nextInt(46)+55; 
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int[] sortArray(){
        int[] newArray = randomArray();
        Arrays.sort(newArray);
        System.out.println("Minimum value in an array : "+ newArray[0]);
        System.out.println("Maximum value in an array : "+ newArray[newArray.length-1]);
        return newArray;
    }
    public static String rand5CharLong(){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int alphaLength = alpha.length();
        String newstr = "";
        Random rand = new Random();
        for (int i = 0; i<5; i++){
            newstr += alpha.charAt(rand.nextInt(alphaLength));
        }
        return newstr;
    }
    public static String[] random10StringArray(){
        String[] myArray = new String[10];
        for(int i=0;i<10; i++){
            String randStr = rand5CharLong();
            myArray[i] = randStr;
        }
        return myArray;
    }
}