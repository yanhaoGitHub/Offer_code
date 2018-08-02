/**
	AC!
	数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
	由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。	
 	
 	！！！本问题最关键的一部分是自己要对输入进来的数组的合法性进行判断，不能直接默认数组合法！
 */
package Offer_29;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
    	if (this.judge(array) == false) {
			return 0;
		}
    	int index = 0;
    	int num=1;
    	for (int i = 0; i < array.length; i++) {
    		if (num<0) {
    			index = i;
    			num = 1;
			}else if (array[index] == array[i]) {
				num++;
			}else {
				num--;
			}
		}
    	return array[index];
    }
    //写一个函数用来判断给定的数组是否满足题目中的条件.
    public boolean judge(int[] array){
    	TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    	for (int i = 0; i < array.length; i++) {
    		if (map.containsKey(array[i])) {
				int num = map.get(array[i]);
				num++;
				map.put(array[i], num);
    		}else {
				map.put(array[i], 1);
			}
    	}
    	/*System.out.print("keys:");
    	for (int key : map.keySet()) {
			System.out.print(key+" ");
		}
    	System.out.println();
    	System.out.print("vlue:");
    	for (int value : map.values()) {
			System.out.print(value+" ");
		}
    	System.out.println();
    	System.out.println("------------------------------");
    	*/
    	//让treemap按照value值进行排序，从大到小排序.
    	List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
    	Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
    		//升序排序
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
    	});
    	//遍历排序结果.
    	//for(Map.Entry<Integer, Integer> mapping : list){ 
    	//    System.out.println(mapping.getKey()+":"+mapping.getValue()); 
    	//} 
    	//得到最后的一组值，即最大的value值以及它所对应的key值.
    	Map.Entry<Integer, Integer> max = list.get(list.size()-1);
    	if (max.getValue() <= (array.length/2.0)) { //!!!注意这里是<=而不是<
			return false;
		}else {
			return true;
		}
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		int[] array1 = {1,2,3,2,2,2,5,4,2};
		int[] array2 = {1,2,3,2,4,2,5,2,3};
		int[] array3 = {4,2,1,4,2,4};
		System.out.println("result1="+test.MoreThanHalfNum_Solution(array1));//2
		System.out.println("result2="+test.MoreThanHalfNum_Solution(array2));//0
		System.out.println("result3="+test.MoreThanHalfNum_Solution(array3));//0
    }
}