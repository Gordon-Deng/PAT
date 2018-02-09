package insertAndMerge_1025;

import java.util.Arrays;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//    }
//
//    public static void InsertSort(int[] arr)
//    {
//        int i, j;
//        int n = arr.length;
//        int temp;
//
//        //假定第一个元素被放到了正确的位置上
//        //这样，仅需遍历1 - n-1
//        for (i = 1; i < n; i++)
//        {
//            j = i;
//            temp = arr[i];
//
//            while (j > 0 && temp < arr[j - 1])
//            {
//                arr[j] = arr[j - 1];
//                j--;
//            }
//
//            arr[j] = temp;
//
//            System.out.println(Arrays.toString(arr));
//        }
//    }
//
//    public static void mergeSort(int[] arr,int low,int high){
//        int mid = (low+high)/2;
//        if(low<high){
//            mergeSort(arr,low,mid);
//            mergeSort(arr,mid+1,high);
//            //左右归并
//            merge(arr,low,mid,high);
//        }
//    }
//
//    public static void merge(int[] arr, int low, int mid, int high) {
//        int[] temp = new int[high-low+1];
//        int i= low;
//        int j = mid+1;
//        int k=0;
//        // 把较小的数先移到新数组中
//        while(i<=mid && j<=high){
//            if(arr[i]<arr[j]){
//                temp[k++] = arr[i++];
//            }else{
//                temp[k++] = arr[j++];
//            }
//        }
//        // 把左边剩余的数移入数组
//        while(i<=mid){
//            temp[k++] = arr[i++];
//        }
//        // 把右边边剩余的数移入数组
//        while(j<=high){
//            temp[k++] = arr[j++];
//        }
//        // 把新数组中的数覆盖nums数组
//        for(int x=0;x<temp.length;x++){
//            arr[x+low] = temp[x];
//        }
//    }
//}

/**
 * @Author : Gordon Deng
 * @Description :
 * 插入排序是迭代算法，逐一获得输入数据，逐步产生有序的输出序列。每步迭代中，算法从输入序列中取出一元素，将之插入有序序列中正确
 * 的位置。如此迭代直到全部元素有序。
 * 归并排序进行如下迭代操作：首先将原始序列看成N个只包含1个元素的有序子序列，然后每次迭代归并两个相邻的有序子序列，直到最后只剩
 * 下1个有序的序列。
 * 现给定原始序列和由某排序算法产生的中间序列，请你判断该算法究竟是哪种排序算法？
 *
 * @Input :
 * 输入在第一行给出正整数N (<=100)；随后一行给出原始序列的N个整数；最后一行给出由某排序算法产生的中间序列。
 * 这里假设排序的目标序列是升序。数字间以空格分隔。
 * @Output :
 * 首先在第1行中输出“Insertion Sort”表示插入排序、或“Merge Sort”表示归并排序；
 * 然后在第2行中输出用该排序算法再迭代一轮的结果序列。题目保证每组测试的结果是唯一的。数字间以空格分隔，且行末不得有多余空格。
 * @Example :
 * 10
 * 3 1 2 8 7 5 9 4 6 0
 * 1 2 3 7 8 5 9 4 6 0
 *
 * Insertion Sort
 * 1 2 3 5 7 8 9 4 6 0
 * @learn :
 * 1）如果是插入排序，当出现后一个数字比前面的小的，该位置（index）之后的序列顺序应该和原序列该位置之后的顺序相同
 * 2）如果是归并排序 index的值表示这么多的规模已经排序完，比如index==2 说明规模为2的已经排序完 下一次排序规模为4，规模内的应该是升序的，也就是有4个4个有序
 * @Date :   21:01 2018/2/9
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];//原始的
        int[] b = new int[n];//部分排序过的
        for(int i = 0;i<n;i++)
            a[i] = in.nextInt();
        for(int i = 0;i<n;i++)
            b[i] = in.nextInt();
        String type = "Insertion Sort";
        int index = 0;
        for(int i = 0;i<n-1;i++){
            if(b[i]>b[i+1]){
                index = i+1;//从i+1这里开始无序
                break;
            }
        }
        for(int i = index;i<n;i++){
            if(a[i]!=b[i]){
                type = "Merge Sort";//如果是插入排序，从index开两个数组的顺序是一样的
                break;
            }
        }
        if(type.equals("Insertion Sort")){
            int num = b[index];
            for(int j = index;j>0;j--){
                if(b[j]<b[j-1]){
                    b[j] = b[j-1];
                    b[j-1] = num;
                }
            }
        }else{
            //如果是归并排序 index的值表示这么多的规模已经排序完，
            //比如index==2 说明规模为2的已经排序完 下一次排序规模为4
            index = 2*index;
            for(int i = 0;i<n;i+=index){
                int next = i+index>n?n:i+index;
                Arrays.sort(b,i,next);
            }
        }
        System.out.println(type);
        for(int i = 0;i<n-1;i++)
            System.out.print(b[i]+" ");
        System.out.print(b[n-1]);
    }
}