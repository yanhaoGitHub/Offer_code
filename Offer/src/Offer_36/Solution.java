/**
 * AC!但是全部参考了别人的代码！
 * 
 * @author Think Different_YH
   在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
   输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 
   即输出P%1000000007 
   
  其实就是一个归并的过程，并且归并的过程不会重复。
  因此只需要计算归并排序好的子数组的逆序对，从大往小数，如果前一个子数组数组的最后一个元素
  大于后一个子数组数组的最后一个元素，则此时产生的逆序数的个数，是后一个子数组的大小
  因为，此时，前一个数组的最后一个元素大于第二个子数组的所有元素，类似分析可得。
 */
package Offer_36;
public class Solution {
    public int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);
        return count;
    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high){
        if(low==high){
            return 0;
        }
        int mid = (low+high)>>1;  //右移一位，相当于除以2
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007; //递归
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;  //递归
        
        int count = 0;
        int i=mid;
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid){
            if(array[i]>array[j]){
                count += j-mid;//count += j-(i+1)+1
                copy[locCopy--] = array[i--];
                if(count>=1000000007) {//数值过大求余
                    count%=1000000007;
                }
            }else{
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--){
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--){
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++){
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
          
    public static void main (String[] args){
    	Solution test = new Solution();
    	int[] array={4,3,2,1};
    	System.out.println(test.InversePairs(array)); //6
    	
    	int[] array2={1,2,3,4,5,6,7,0};
    	System.out.println(test.InversePairs(array2)); //7
    	
    	int[] array3={7,5,6,4};
    	System.out.println(test.InversePairs(array3)); //5
    }
}