/**
 * FileName:  StringReverse
 * Author:    wangkai_wb
 * Date:      2020/6/19
 * Description: 字符串反转算法
 */
package com.wk.arraySum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈字符串反转算法〉
 *  利用Java提供的特性
 * @author wangkai_wb
 * @create 2020/6/19
 * @since 1.0.0
 * 解题思路:利用Java语言提供的特性,比如先通过String的split()方法拆分,
 * 然后通过集合工具类Collection.reverse()方法,最后再返回字符串
 */
public class StringReverse {
    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println("原字符串:"+str);
        //使用\\s+正则来以空格拆分字符串
        String[] strs = str.split("\\s+");
        //使用工具类Arrays.asList()将其转换为list集合
        List<String> stringList = Arrays.asList(strs);
        //使用Collections.reverse()方法反转内容
        Collections.reverse(stringList);
        //使用StringJoiner来拼接反转后的字符串即可
        str = String.join(" ",stringList);
        //打印str
        System.out.println("反转后的字符串:"+str);
    }
}
