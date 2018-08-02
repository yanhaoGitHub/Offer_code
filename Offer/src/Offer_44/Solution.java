/**
 * AC!
 * 左旋转字符串！
 */
package Offer_44;
public class Solution {
    public String reverse(String str, int start, int end) {
    	char[] ch = str.toCharArray();
    	while (start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
    	return String.valueOf(ch);
    }
    public String LeftRotateString(String str,int n) {
    	if (n>=str.length()) return str;
    	//System.out.println("str初始为:"+str);
      
    	str = this.reverse(str, 0, n-1);
    	//System.out.println("1:"+str);
    	
    	str = this.reverse(str, n, str.length()-1);
    	//System.out.println("2:"+str);
    	
    	str = this.reverse(str, 0, str.length()-1);
    	//System.out.println("3:"+str);
    	return str;
    }
    public static void main(String[] args) {
    	Solution test = new Solution();
    	String str = "abcdefg";
    	System.out.println(test.LeftRotateString(str, 2));//cdefgab
    }
}