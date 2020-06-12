/**
 * FileName:  MaxArray
 * Author:    wangkai_wb
 * Date:      2020/6/12
 * Description: 求一个数组中连续m个数和最大的组合
 */
package com.wk.arraySum;

import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈求一个数组中连续m个数和最大的组合〉
 *
 * @author wangkai_wb
 * @create 2020/6/12
 * @since 1.0.0
 */
public class MaxArray {
    public static void main(String[] args) {
        // int[]数组,asList返回int[];
        Integer[] paras = { 133, 445, 6768, 23, 656, 123105, 768, 234,
                787, 6321, 5677, 234, 1445, 3551, 547, 3245, 12357 };
        //引用类型的数组转化为集合
        List<Integer> lists = Arrays.asList(paras);
        int n = 6;
        //将集合转化成数组
        System.out.println(getArray((Integer[]) lists.toArray(),n));
        System.out.println(getArray(paras,n));
    }
    public static <T> String getArray(Integer[] params,int n){
        //声明maxs,初始化temp
        Integer[] maxs = null,temp = null;
        if (!(params instanceof Integer[])){
            return "参数类型错误!";
        }
        temp = new Integer[n];
        maxs = new Integer[n];
        int len = params.length;
        for (int i=0;i<len;i++){
            if (i+n<=len){
                //数组复制,相当于切片
                System.arraycopy(params,i,temp,0,n);
                if (maxs[0] ==null || (maxs[0]!=null && (getSum(maxs)<getSum(temp)))){
                    //引用相同,不可使用maxs = temp
                    //从temp复制一份给maxs
                    System.arraycopy(temp,0,maxs,0,n);
                }
            }
        }
        //将数组以字符打印
        return Arrays.toString(maxs);
    }

    //取数组或者集合的加和
    public static <T> int getSum(T t){
        int sum = 0;
        if (t instanceof List<?>){
            List<?> temp = (List<?>) t;
            int len = temp.size();
            for (int i = 0;i<len;i++){
                sum += (Integer) temp.get(i);
            }
        }else if (t instanceof Integer[]){
            Integer[] temp = (Integer[])t;
            for (int i=0;i<temp.length;i++){
                sum += temp[i];
            }
        }
        return sum;
    }
}