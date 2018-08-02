/**
 *  AC!
	输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
	例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	
	解题思路：
 	先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
  	排序规则如下：
 	若ab > ba 则 a > b，
  	若ab < ba 则 a < b，
  	若ab = ba 则 a = b；
  	解释说明：
 	 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
 */
package Offer_33;
import java.util.Arrays;
import java.util.Comparator;
public class Solution {
	//笨办法，先列出所有可能的排列，然后找出最小值！
    public String PrintMinNumber(int [] numbers) {
    	if (numbers==null || numbers.length==0) {
			return "";
		}
    	String[] strs = new String[numbers.length];
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < numbers.length; i++) {
    		strs[i] = String.valueOf(numbers[i]);
		}
    	Arrays.sort(strs, new Comparator<String>() {
        	String s1 = null;
        	String s2 = null;
    		@Override
    		public int compare(String o1, String o2) {
    			 s1 = o1 + o2;
    			 s2 = o2 + o1;
    			 return s1.compareTo(s2);
    		}
    	});
    	for (int i = 0; i < strs.length; i++) {
			sb.append(strs[i]);
		}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		int[] numbers = {3, 32, 321};
		System.out.println(test.PrintMinNumber(numbers));
    }
}