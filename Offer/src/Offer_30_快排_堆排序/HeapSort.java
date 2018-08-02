package Offer_30_快排_堆排序;
/**
 * 堆排序实现代码
      ！！！下面代码包括大顶堆的代码和小顶堆的代码！	
 */
public class HeapSort {
    public void sort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){ //for循环进行构建并调整！
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
    }
    //调整大顶堆
    public void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1; k<length; k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;  //这个k++很精髓！结合上面for循环中的条件k=k*2+1，很精髓！
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }	
        arr[i] = temp;//将temp值放到最终的位置
    }	
    public void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    /**
     * 下面代码是小顶堆！
     */
    public void sort2(int []arr){
        //1.构建小顶堆
        for(int i=arr.length/2-1;i>=0;i--){ //for循环进行构建并调整！
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap2(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap2(arr,0,j);//重新对堆进行调整
        }
    }
    /**
     * 调整小顶堆
     */
    public void adjustHeap2(int[] arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1; k<length; k=k*2+1){
            if(k+1<length && arr[k]>arr[k+1]){//这里arr[k]<arr[k+1]中的<号变成>号即可变成小顶堆！
                k++;  
            }
            if(arr[k] < temp){//将>号改成<号即可变成小顶堆！
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }	
        arr[i] = temp;//将temp值放到最终的位置
    }	
    public static void main(String[] args) {
		HeapSort test = new HeapSort();
		int[] array = {4,6,8,5,9};
		test.sort2(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}	
}