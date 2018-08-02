/**
 * AC!
 * 翻转单词顺序列！
 */
package Offer_45;
public class Solution {
    public String ReverseSentence(String str) {
    	if (str == null) return null;
    	if (str.trim().length()==0) return str;//
    	String str_firstProcess = this.reverse(str);
    	String[] strs = str_firstProcess.split(" ");
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < strs.length; i++) {
			sb.append(this.reverse(strs[i]));
			if (i!=strs.length-1) {
				sb.append(" ");
			}
    	}
    	return sb.toString();
    }
    public String reverse(String str) {
    	char[] ch = str.toCharArray();
    	int start = 0;
    	int end = ch.length-1;
    	while (start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
    	return String.valueOf(ch);
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		String str = "I am a student.";
		System.out.println(test.ReverseSentence(str));//student. a am I
		String str2 = " ";
		System.out.println("-"+test.ReverseSentence(str2)+"-");//- -
    }
}