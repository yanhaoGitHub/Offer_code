package Offer_30_快排_堆排序;
//这个类实现快速排序代码!
public class QuickSort {
	public void quickSort(int[] array, int start, int end){
		int dp;
		if (start<end) { //递归结束
			dp = this.partition(array, start, end);
			this.quickSort(array, start, dp-1);
			this.quickSort(array, dp+1, end);
		}
	}
	public int partition(int[] array, int start, int end) {
		int temp = array[start];
		while (start < end) {
			while (start < end && array[end]>=temp) {
				end--;
			}
			if (start<end) {
				array[start] = array[end];
				start++;
			}
			while (start<end && array[start]<=temp) {
				start++;
			}
			if (start<end) {
				array[end] = array[start];
				end--;
			}
		}
		array[start] = temp;
		return start;
	}
	public static void main(String[] args) {
		QuickSort test = new QuickSort();
		int[] array = {2,4,7,1,3,8,9,2,1,5,6,12,456,23,345};
		test.quickSort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
