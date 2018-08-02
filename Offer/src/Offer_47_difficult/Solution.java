/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
package Offer_47_difficult;

import java.util.ArrayList;

public class Solution {
	//使用数组模拟环形链表,但是缺点是即使已经失效的数字，只是会被标记为-1，但是仍然会被比较，所以会慢一些！
	public int LastRemaining_Solution(int n, int m) {
		if (n<1 || m<1) return -1;
    	int[] array = new int[n];
		int resultIndex = -1, step = 0, count = n;
    	while (count > 0) {
			resultIndex++;
			if (resultIndex >= n) {
				resultIndex = 0;
			}
			if (array[resultIndex] == -1) {
				continue;
			}
			step++;
			if (step == m) {
				array[resultIndex] = -1;
				step = 0;
				count--;
			}
		}
		return resultIndex;
    }
	
	//使用ArrayList实现，可以动态删除已经失效的数字，下次比较就没这个数字了，但是会占用比数组更大的空间！
	public int LastRemaining_Solution2(int n, int m) {
		if (n<1 || m<1) return -1;
		int index=-1;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) list.add(i);
		while (list.size() > 1) {
			index = (index+m)%list.size();
			list.remove(index);
			index--;
		}
		return list.get(0);
	}
	
	//发现数字规律，时间复杂度及空间复杂度均很小
	public int LastRemaining_Solution3(int n, int m) {
		if (n<1 || m<1) return -1;
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last+m)%i;
		}
		return last;
	}
}