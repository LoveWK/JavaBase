/**
 * FileName:  StringReverse2
 * Author:    wangkai_wb
 * Date:      2020/6/19
 * Description: 字符串反转
 */
package com.wk.arraySum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 〈一句话功能简述〉<br> 
 * 〈字符串反转算法〉
 *
 * @author wangkai_wb
 * @create 2020/6/19
 * @since 1.0.0
 * 解题思路:因为双端队列可以支持从队列头部插入的方法,
 * 所以我们可以将字符串中的单词一个一个进行处理,
 * 然后将每一个单词push到队列的头部,再将队列转成字符串即可.
 */
public class StringReverse2 {
    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println("原字符串:"+str);
        int left = 0;
        int right = str.length() -1;
        //构建双端队列
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left <= right){
            char charStr = str.charAt(left);
            if ((word.length() !=0) && (charStr ==' ')){
                //将单词push到队列的头部
                deque.offerFirst(word.toString());
                word.setLength(0);
            }else if (charStr != ' '){
                word.append(charStr);
            }
            ++left;
        }
        deque.offerFirst(word.toString());
        System.out.println("反转后的字符串:"+String.join(" ",deque));
    }
}
