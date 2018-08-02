/**
 *  AC!
	从扑克牌中随机抽5个数字，判断是不是一个顺子，即这五张牌是不是连续的，
	2~10为数字本身，A为1，J为11，Q为12,K为13，而大小王可以看作是任意数字！
 */
package Offer_46;
public class Solution {
    public boolean isContinuous(int [] numbers) {
    	if (numbers.length != 5) {//初始判断，不能少！
			return false;
		}
    	
    	boolean flag = false;
    	this.heapSort(numbers);//堆排序！
    	int zeroNum = this.zeroNums(numbers);//得到0出现的次数
    	System.out.println("0出现的次数是："+zeroNum);
    	int marginNum = this.marginNum(numbers, zeroNum);//得到最大间隔和
    	if (marginNum == -1) {  //注意这个判断，若返回值是-1，则说明有重复出现的非0数字，不可能是顺子，返回false
			return false;
		}
    	if(marginNum <= zeroNum) { //注意这个条件，只要margin小于zeroNum即可，因为0是很灵活的，它可以代替任何数！
			flag = true;
		}
    	return flag;
    }
    //得到数组中0出现的次数！
    public int zeroNums(int[] array) {
    	int num = 0;
    	for (int i = 0; i < array.length; i++) {
			if (array[i]==0) {
				num++;
			}else {
				break;
			}
		}
    	return num;
    }
    public int marginNum(int[] array, int zerosNum) {
    	int result = 0;
    	for (int i = zerosNum; i < array.length-1; i++) {
			int j = array[i];
			int k  = array[i+1];
			if (j == k) {
				return -1;//有相同的牌，则不可能是顺子，返回-1
			}else {
				result += (k-j-1);
			}
		}
    	System.out.println("result="+result);
    	return result;
    }
    
    public void heapSort(int[] array) {
    	for (int i = array.length/2-1; i >= 0; i--) {
			adjustHeap(array, i, array.length);
		}
    	for (int i = array.length-1; i > 0; i--) {
    		this.swap(array, 0, i);
    		this.adjustHeap(array, 0, i);
    	}
    }
    public void adjustHeap(int[] array, int i_index, int endIndex) {
    	int temp = array[i_index];
    	for (int k = 2*i_index+1; k < endIndex; k=2*k+1) {
			if (k+1 < endIndex && array[k+1]>array[k]) {
				k++;
			}
			if (array[k] > temp) {
				array[i_index] = array[k];
				i_index = k;
			}else {
				break;
			}
		}
    	array[i_index] = temp;
    }
    public void swap(int[] array, int i, int k) {
    	int temp = array[i];
    	array[i] = array[k];
    	array[k] = temp;
    }
    public static void main(String[] args) {
		Solution test = new Solution();
		int[] array = {0,0,1,4,7};
		System.out.println(test.isContinuous(array));
		System.out.println("-------------------------");
		
		int[] array2 = {3,0,0,0,0};
		System.out.println(test.isContinuous(array2));
		System.out.println("-------------------------");
		
		int[] array3 = {0,0,0,0,0};
		System.out.println(test.isContinuous(array3));
		System.out.println("-------------------------");
		
		int[] array4 = {2,6,0,0,0};
		System.out.println(test.isContinuous(array4));
		System.out.println("-------------------------");
		
		int[] array5 = {1,0,0,1,0};
		System.out.println(test.isContinuous(array5));
    }
}