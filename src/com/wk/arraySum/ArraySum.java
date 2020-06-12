/**
 * FileName:  ArraySum
 * Author:    wangkai_wb
 * Date:      2020/6/12
 * Description: 给定一个数从数组中找两个数的和与它相等
 */
package com.wk.arraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈给定一个数从数组中找两个数的和与它相等〉
 *
 * @author wangkai_wb
 * @create 2020/6/12
 * @since 1.0.0
 */
public class ArraySum {
    public static void main(String[] args) {
        int[] arr = {1,1,2,4,5,7,9,11,17,27,35,66,77,99,101};
        int num =6;

        Map map1 = getSumToANum(arr,0,arr.length-1,num);
        System.out.println("第一种方法:");
        map1.forEach((k,v)->{
            System.out.println("数组中和为"+num+"的组合为:arr["+k+"]和arr["+v+"]的组合");
        });

        Map map2 = getSumToANum1(arr,num);
        System.out.println("第二种方法:");
        map2.forEach((k,v)->{
            System.out.println("数组中和为"+num+"的组合为:arr["+k+"]和arr["+v+"]的组合");
        });
    }

    /**
     * 第一种方法:
     * @param array
     * @param start
     * @param end
     * @param num
     * @return
     * 将有序数组的最小值与最大值进行相加后，与给定数进行比较，
     * 如果相等，则在数组中找出两个数之和等与给定数；
     * 如果小于给定数，则从小的位置向后移，在进行比较；
     * 如果大于给定数，则从大的位置向前移，在进行比较；
     * 如果直到开始位置大于结束位置时还没有找到这样的两个数时，输出不存在。
     * 复杂度为O（n）。
     *
     */
    public static Map<Integer, Integer> getSumToANum(int[] array, int start, int end, int num){
        Map<Integer,Integer> map = new HashMap<>();
        while (start <= end){
            if (num == (array[start]+array[end])){
                map.put(start,end);
                start++;
            }else if (num > (array[start]+array[end]))
                start++;
            else
                end--;
        }
        return map;
    }

    /**
     * 第二种方法
     * @param nums
     * @param target
     * @return
     * 将目标数与数组中的数进行差值计算，并将数组中的数以键的形式存到数组中；
     * 将差值与数组中的键进行比较，若相同则数组中存在两个数之和等于目标数。
     * 复杂度为O（n）。
     */
    public static Map<Integer, Integer> getSumToANum1(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            //将数组中的数以键的形式存到集合中
            map.put(nums[i],i);
        }
        for (int j=0;j<nums.length;j++){
            //使目标数值和数组中的数值做差值
            int complement = target - nums[j];

            if (map.containsKey(complement)) {
                map1.put(j,map.get(complement));
            }
        }
        return map1;
    }
}
