/**
 * AC!
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 例如把9表示成二进制就是1001，有2位是1，因此如果输入9，该函数要输出2。
 * 
 * 左移规则:左移运算符m<<n表示把m左移n位，把一个二进制数，左移n位的时候，最左边的n为将被丢弃，同时在最右边补上n个0，比如：
 * 00001010 << 2 = 00101000
 * 10001010 << 3 = 01010000
 * 右移运算符m>>n表示把m右移n位，右移n位的时候，最右边的n位将被丢弃，但是右移处理时最左边位的情形要稍微复杂一些。
 * 如果数字是一个无符号数值，则用0填补最左边的n位，如果数字是一个有符号数值，则用数字的符号位填补最左边的n位。
 * 也就是说如果数字原先是一个正数，则右移之后在最左边补n个0，如果数字原先是负数，则右移之后再最左边补n个1。比如:
 * 00001010 >> 2 = 00000010
 * 10001010 >> 3 = 11110001
 */
package Offer_10_1;
public class Solution {
    public int NumberOf1(int n) {   //最优解，n中有几个1就循环几次！
    	String temp = Integer.toBinaryString(n);
    	System.out.println(n+"的二进制数是:"+temp);
    	int count = 0;
    	while(n != 0){
    		++count;	
    		n = (n-1) & n;
    	}
    	return count;
    }
    public int NumberOf12(int n) {   //正解，n中有多少位就循环多少次！
    	int count = 0, flag=1;
    	while (flag != 0) {
			if ((flag & n) != 0) {//由于n的始终是1，10，100，1000这种形式，所以与运算的时候只要结果不是0，就说明n的低位，次低位是不是1了!			
				count++;
			}
			flag = flag << 1; //把flag左移一位，相当于乘以2，及从1变成10，从10变成100，从100变成1000
		}
    	return count;
    }
    public int NumberOf13(int n) {  //直接调用java内置函数进行处理，不推荐
		return Integer.toBinaryString(n).replace("0", "").length();
    }
    public int NumberOf14(int n) {  //直接调用java内置函数进行处理，不推荐
		return Integer.bitCount(n);
    }
    public static void main(String[] args) {
    	Solution test = new Solution();
    	
    	System.out.println(10&8); //注意在java中两个整数&运算的时候会自动转化为二进制，但是与运算结束之后的结果又会转化为十进制表示，所以这里输出8
    	/*int[] array = {0,1,2,3,5,6,7,8,10,11,15,18,20,100};
    	for (int i = 0; i < array.length; i++) {
    		System.out.println(test.NumberOf1(array[i]));
    		System.out.println(test.NumberOf12(array[i]));
    		System.out.println(test.NumberOf13(array[i]));
    		System.out.println(test.NumberOf14(array[i]));
    		System.out.println("-------------------------");
    	}*/
    }
}