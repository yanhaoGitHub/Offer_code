/**	#斐波那契数列的排列是：1，1，2，3，5，8，13，21，34，55，89，144
	#注意，第一个数是1，这个数是第一项，并不是第0项！！
	#第11项是89，而不是144，注意下表是从1开始计算的，并不是从0开始计算！
	#第1项是1，第二项也是1，第三项是2，第0项是0！！！
	
	变态跳台阶：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	
n = 1时，只有1种跳法，f(1) = 1

n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)

n = 3时，会有三种跳得方式，1阶、2阶、3阶，
    
那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
    
因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
    
n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
    f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
    
由以上已经是一种结论，但是为了简单，我们可以继续简化：
    f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
    f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
    可以得出：
    f(n) = 2*f(n-1)
    
得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
            1       ,(n=0 ) 
f(n) =      1       ,(n=1 )
            2*f(n-1),(n>=2)

当然，分析到这里，代码应该很简单了
 */
package Offer_9_3;
public class Solution {
    public int JumpFloorII(int target) {
    	int[] array = {0,1};
    	if (target <= 1) {
			return array[target];
		}
    	return 2*JumpFloorII(target-1);
    }
    public static void main(String[] args) {
    	Solution test = new Solution();
    	System.out.println(test.JumpFloorII(0));
    	System.out.println(test.JumpFloorII(1));
    	System.out.println(test.JumpFloorII(2));
    	System.out.println(test.JumpFloorII(3));
    	System.out.println(test.JumpFloorII(4));
    }
}
