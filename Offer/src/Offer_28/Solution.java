/**
 * 	AC!
	输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
	则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
package Offer_28;
import java.util.ArrayList;
import java.util.TreeSet;
public class Solution {
    public ArrayList<String> Permutation(String str) {
    	ArrayList<String> list = new ArrayList<String>();
    	if (str==null || (str.length()==0)) {
			return list;
		}
    	TreeSet<String> set = new TreeSet<String>();
    	char[] chars = str.toCharArray();
    	this.Permutation(chars, 0, set);
    	list.addAll(set); //！！！addAll而不是add
    	return list;
    }
    public void Permutation(char[] chars, int begin, TreeSet<String> result) {
    	if (chars==null||chars.length==0||begin<0||begin>chars.length-1) {
			return;
		}
    	if (begin == chars.length-1) {
			result.add(String.valueOf(chars));  //递归出口
		}else {
			for (int i = begin; i <= chars.length-1; i++) { //注意这里是chars.length()-1
				swap(chars, begin, i);
				this.Permutation(chars, begin+1, result);  //注意这里是begin+1
				swap(chars, begin, i); 
			}
		}
    }
    public void swap(char[] chars, int index, int index2){
    	char ch = chars[index];
    	chars[index] = chars[index2];
    	chars[index2] = ch;
    }
    public static void main(String[] args) {
    	Solution test = new Solution();
    	ArrayList<String> list = new ArrayList<String>();
    	list = test.Permutation("abc");
    	for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
    }
}