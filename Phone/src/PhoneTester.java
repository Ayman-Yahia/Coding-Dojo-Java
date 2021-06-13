public class PhoneTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Galaxy s8 = new Galaxy("S8", 77, "Jawal", "Zzz Zzz");
		IPhone iPhoneXI = new IPhone("XI", 50, "ooredoo", "Ring ring!");
		
		s8.displayInfo();
		System.out.println(s8.ring());
		System.out.println(s8.unlock());
		
		iPhoneXI.displayInfo();
		System.out.println(iPhoneXI.ring());
		System.out.println(iPhoneXI.unlock());

	}

}
