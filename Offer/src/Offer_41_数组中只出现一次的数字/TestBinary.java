package Offer_41_数组中只出现一次的数字;

public class TestBinary {
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(106));//1101010
		System.out.println(106&1);  //0
		
		System.out.println(106>>1); //53
		System.out.println(Integer.toBinaryString(53));//110101
		System.out.println(53&1);   //1
		
		System.out.println(53>>1);  //26
		System.out.println(Integer.toBinaryString(26));//11010
		System.out.println(26&1);   //0
	}
}
