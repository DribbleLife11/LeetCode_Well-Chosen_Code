class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        /*
        思路一：排序输出前k个
        复杂度分析：
        时间复杂度为O(nlogn);
        空间复杂度为O(k).
        Arrays.sort(arr);
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        return temp;
        */

        /*
        思路2：大根堆
        */
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        
        //默认为小根堆，需要重写比较器实现大根堆
        Queue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr){
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num < heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        
        int[] res = new int[heap.size()];
        int index = 0;
        for (int num : heap) {
            res[index++] = num;
        }
        
        return res;
    }
    
    /**
    * 思路三：计数排序
    */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num: arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }
    
}
