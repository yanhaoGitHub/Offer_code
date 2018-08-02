package Offer_30_快排_堆排序;
//这个类实现快速排序代码!
public class QuickSort2 {
	public void quickSort(int[] array, int start, int end){
		if (start < end) {
			int index = this.partition2(array, start, end);
			this.quickSort(array, start, index-1);
			this.quickSort(array, index+1, end);
		}
	}
	public int partition2(int[] array, int start, int end) {
		int tempNum = array[start];
		int i = start;
		int j = end;
		while (i < j) {
			while (array[j]>=tempNum && i<j) {
				j--;
			}
			if (i < j) {
				array[i] = array[j];
				i++;
			}
			while (array[i]<=tempNum && i<j) {
				i++;
			}
			if (i < j) {
				array[j] = array[i];
				j--;
			}
		}
		array[i] = tempNum;
		return i;
	}

	public static void main(String[] args) {
		QuickSort2 test = new QuickSort2();
		int[] array = {2,4,7,1,3,8,9,2,1,5,6,12,456,23,345};
		test.quickSort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
