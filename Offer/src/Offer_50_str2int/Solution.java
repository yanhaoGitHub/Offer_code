/**
  AC!
    将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
    数值为0或者字符串不是一个合法的数值则返回0
 */
package Offer_50_str2int;
public class Solution {
    public int StrToInt(String str) {
    	if (str==null || str.equals("")) {
			return 0;
		}
    	if (!this.isValid(str)) {
    		//System.out.println("格式不正确！");
			return 0;
		}
    	char[] ch = str.toCharArray();
    	boolean posi;//得到最后的结果的正负号
    	boolean firstIsNum;//判断第一个字符是不是+或者- 
    	if (ch[0] == '+') {
			posi = true;
			firstIsNum = false;
    	}else if (ch[0] == '-') {
			posi = false;
			firstIsNum = false;
		}else {
			posi = true;
			firstIsNum = true;
		}
    	
    	int minq = Integer.MIN_VALUE / 10;
    	int minr = Integer.MIN_VALUE % 10;
    	int res = 0;
    	int cur = 0;
    	/**
    	 * 下面这段代码是关键！详细思路可以查看左神那本书248页！
    	 * 补充说明：在遍历的过程中，如何判断res已经溢出了？
    	 * 假设当前字符为a，那么'0'-a就是当前字符的负数形式，记为cur,如'0'-'8'=-8
    	 * 如果在res+cur之前，已经发现res<minq, 那么res*10一定会溢出！
    	 * 或者res==minq, 同时cur<minr, 则res*10+cur之后也会溢出！
    	 * 
    	 */
    	for (int i = firstIsNum ? 0 : 1; i < ch.length; i++) {
    		cur = '0' - ch[i];
    		if ((res<minq) || (res==minq && cur < minr)) {
				return 0;
			}
    		res = res*10 + cur;
		}
    	//下面的if语句用来判断，如果原来的数是正数，但是res==-2147483648,本来应该返回2147483648的，但是由于Integer的最小值=-2147483647，溢出了！
    	if (posi && res==Integer.MIN_VALUE) {
			return 0;                                           
		}
    	return posi ? -res:res;
    }
    /**
		判断输入的字符串格式是否正确！
		非法输入举例：'-', 'A12', '-0', '-012', '023', '3fa23'， '+','+12','+A12', '++'
     */
    public boolean isValid(String str) {
    	char[] ch = str.toCharArray();
    	//如果str不以-,+开头，也不以数字开头，如"A12",返回false
    	if ((ch[0]!='-' && ch[0]!='+') && (ch[0]<'0' || ch[0]>'9')) {
    		System.out.println("111");
    		return false;
		}
    	//如果str以-或+开头，但是str的长度为1，即str='-',返回false,如果str的长度大于1，但是-后面紧跟着0，
    	//例如-0， -012，返回false
    	if ((ch[0]=='-' || ch[0]=='+') && (ch.length==1 || ch[1]=='0')) {
    		System.out.println("222");
    		return false;
		}
    	//如果str以0开头，但是str的长度大于1，返回false
    	if (ch[0] == '0' && ch.length > 1) {
			return false;
		}
    	//经过上面的判断之后，接下来检查str中是否都是数字字符！
    	for (int i = 1; i < ch.length; i++) {
			if (ch[i] < '0' || ch[i] > '9') {
				return false;
			}
		}
    	return true;
    }
    public static void main(String[] args) {
		Solution test = new Solution();
		//System.out.println(test.StrToInt("-2147483648"));//-2147483648
		//System.out.println(test.StrToInt("-2147483649"));//0，溢出了
		//System.out.println(test.StrToInt("2147483647"));//2147483647
		//System.out.println(test.StrToInt("2147483648"));//0，溢出了
		//System.out.println(test.StrToInt("+123"));//123
		//System.out.println(test.StrToInt("-123"));//-123
		//System.out.println(test.StrToInt("+2147483647"));//2147483647
		//System.out.println(test.StrToInt("2147483647"));//2147483647
		//System.out.println(test.StrToInt("+2147483648"));//0，溢出
		//System.out.println(test.StrToInt("2147483648"));//0，溢出
    }
}