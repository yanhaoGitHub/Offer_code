/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 *
 * !!!No AC, �������Լ����ô������ݲ����Լ��Ĵ����ʹ���Ĵ���֮��Ĳ�𣬵���û�з��ֲ�ͬ�����⣡����
 */
package Offer_3_NoAC;

import java.util.Random;

public class Solution {
	//�Լ��Ĵ���
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
	  	//���˵Ĵ���
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
		  //����������ɴ������ֵ���ʽ���в��ԣ�����û�з����������ڣ�
		  Random random=new Random();// ���������
		  for (int i = 0; i < 1000000; i++) {
			  int result=random.nextInt(1000000000);// ����[0,10)�����е�������ע�ⲻ����10
			  if (test.Find(result, array2) != test.Find2(result, array2)) {
				  System.out.println("��ǰ���������������:"+result);
				  System.out.println("find="+test.Find(result, array2));
				  System.out.println("find2="+test.Find2(result, array2));
			  }
		  }
	  }
}






