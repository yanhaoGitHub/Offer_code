package Offer_38;
//二分查找算法
public class BinSearch {
	//递归写法
	public int search(int[] array, int k, int start, int end) {
		int mid = 0;
		if (end >= start) {
			mid = (start+end)>>1;
			if (array[mid] == k) {
				return mid;
			}else if (array[mid] < k) {
				return this.search(array, k, mid+1, end);
			}else {
				return this.search(array, k, start, mid-1);
			}
		}else {
			return -1;
		}
	}
	//非递归写法
	public int search2(int[] array, int k) {
		int begin = 0;
		int fin = array.length-1;
		while (begin <= fin) {
			int mid = (begin + fin)>>1;
			if (array[mid] == k) {
				return mid;
			}else if (array[mid] < k) {
				begin = mid+1;
			}else {
				fin = mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		BinSearch test = new BinSearch();
		int[] array = {1,2,3,5,6,7,9,12,14,18,19,45,48,56,89};
		int i =89;
		System.out.println(test.search(array, i, 0, array.length-1));
		System.out.println(test.search2(array, i));
	}
}
