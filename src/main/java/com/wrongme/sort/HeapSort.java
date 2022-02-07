package com.wrongme.sort;

/**
 * 堆排序 - 大顶堆
 * 一般升序采用大顶堆，降序采用小顶堆
 * 2022年2月7日13:46:36
 */
public class HeapSort {
    // 堆是具有以下性质的完全二叉树：
    // 每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆。
    //          大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
    // 每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
    //          小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]

    public int[] sort(int[] nums) {
        int len = nums.length;
        // 将数组整理成堆
        heapify(nums);
        // 循环不变量： 区间 [0，i]堆有序
        for (int i = nums.length - 1; i >= 1; ) {
            // 先把堆顶元素交换到数组末尾
            swap(nums, 0, i);
            i--;
            // 下标0 位置下沉操作，区间 [0,i] 有序
            siftDown(nums, 0, i);
        }
        return nums;
    }

    private void heapify(int[] nums) {
        int len = nums.length;
        // 从第一个(i = (len - 1) / 2)非叶子结点从下至上，从右至左调整结构
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    /**
     * @param nums 数组
     * @param k    当前下沉元素的下标
     * @param end  [0, end] 是 nums 的有效部分
     */
    private void siftDown(int[] nums, int k, int end) {
        // 下沉元素的左节点的下标 2 * k + 1
        while (2 * k + 1 <= end) {
            // 下沉元素的左节点的下标
            int index = 2 * k + 1;
            // 下沉元素的右节点的下标
//            int rightIndex = index + 1;
            // 右节点 大于 左节点
            if (index + 1 <= end && nums[index + 1] > nums[index]) {
                index++;
            }
            // 将较大的节点 和 父节点（下沉节点）比较,
            if (nums[index] > nums[k]) {
                swap(nums, index, k);
            }else {
                break;
            }
            k = index;
        }
    }

    /**
     * 交换数组两个元素
     *
     * @param nums
     * @param index1
     * @param index2
     */
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        int[] arr = heapSort.sort(new int[]{3, 9, 41, 1, 2, 6, 8, 10, 60});
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
