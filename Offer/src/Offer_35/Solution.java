/**
 * AC!
 * @author Think Different_YH
     在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
    算法思想：我们需要遍历一遍数组，确定每个字符出现的次数，因此，我们创建一个长度为256的数组来存储，为什么是256呢？
    因为字符总共也就256个，我们用数组的索引来表示字符，用数组中存储的数字来表示字符出现的次数，最后再遍历一遍str，
    按照顺序找出第一个出现的字符即可。  
     
 */
package Offer_35;
public class Solution {
	public int FirstNotRepeatingChar(String str) {
		if (str.length() <= 0) {
			return -1;
		}
		int result = 0;
		int[] array = new int[256];
		for (int i = 0; i < array.length; i++) {  //初始化这个字符数组，全部为0，表示所有字符初始出现次数为0
			array[i] = 0;  
		}
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int num = ch;
			array[num]++;
		}
		/*
		 * 注意，这里是遍历str，而不是array，因为array中的字符顺序是确定的，
		 * 出现在前面的字符未必是第一个只出现一次的字符，比如google,l是第一个出现的字符，
		 * 但是如果遍历array的话，l和e都只出现了一次，但是array中e在l的前面，这个时候就会打印出错误的结果！
		 * */
		for (int i = 0; i < str.length(); i++) {
			int ch = str.charAt(i);
			if (array[ch] == 1) {
				result = i;
				break;
			}
		}
		return result;
	 }
	 public static void main(String[] args) {
		 Solution test = new Solution();
		 System.out.println(test.FirstNotRepeatingChar("abaccdef"));//1
		 System.out.println(test.FirstNotRepeatingChar("google"));//4
		 System.out.println(test.FirstNotRepeatingChar(""));//-1
	 } 
}
