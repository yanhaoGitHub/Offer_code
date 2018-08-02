/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * !!!No AC, 本道题自己采用大量数据测试自己的代码和痛过的代码之间的差别，但是没有发现不同，疑题！！！
 */
package Offer_3_NoAC;

import java.util.Random;

public class Solution {
	//自己的代码
	public boolean Find(int target, int [][] array) {
		  boolean flag = false;
		  for (int i = 0; i < array.length; i++) {
			  int len = array[i].length;
			  if (target==array[i][0] || target==array[i][len-1]) {
				  //System.out.println("111");
				  flag = true;
				  break;
			  }else if (target>array[i][0] && target<array[i][len-1]) {
				  //System.out.println("222");
				  for (int j = 1; j < len; j++) {
					  if (target == array[i][j]) {
					//	  System.out.println("333");eq
						  flag = true;
						  break;
					  }
				  }
				  //System.out.println("444");
			  }else {
				  //System.out.println("555");
				  continue;
			  }
		  }
		  return flag;
	  }
	  	//别人的代码
	    public boolean Find2(int target,int [][] array) {
	    	int len = array.length-1;
	    	        int i = 0;
	    	        while((len >= 0)&& (i < array[0].length)){
	    	            if(array[len][i] > target){
	    	                len--;
	    	            }else if(array[len][i] < target){
	    	                i++;
	    	            }else{
	    	                return true;
	    	            }
	    	        }
	    	        return false;
	    	    }
	  public static void main(String[] args) {
		  int[][] array2 = {{1,2,4,6},{7,8,10,11,13,16,19},
				  {23,26,27,29},{234,256,567,789,1230},
				  {1234,2345,2347,2356,2389,12345},{12346,23456,23478,23490}};
		  Solution test = new Solution();
		  //采用随机生成大量数字的形式进行测试，但是没有发现问题所在！
		  Random random=new Random();// 定义随机类
		  for (int i = 0; i < 1000000; i++) {
			  int result=random.nextInt(1000000000);// 返回[0,10)集合中的整数，注意不包括10
			  if (test.Find(result, array2) != test.Find2(result, array2)) {
				  System.out.println("当前随机产生的数字是:"+result);
				  System.out.println("find="+test.Find(result, array2));
				  System.out.println("find2="+test.Find2(result, array2));
			  }
		  }
	  }
}






