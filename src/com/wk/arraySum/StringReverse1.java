/**
 * FileName:  StringReverse1
 * Author:    wangkai_wb
 * Date:      2020/6/19
 * Description: 字符串反转算法
 */
package com.wk.arraySum;

/**
 * 〈一句话功能简述〉<br> 
 * 〈字符串反转算法〉
 *
 * @author wangkai_wb
 * @create 2020/6/19
 * @since 1.0.0
 * 解题思路:使用双指针的核心思想:一个指针负责循环遍历,另一个指针负责条件处理
 */
public class StringReverse1 {
    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println("原字符串:"+str);
        //定义左右指针,右指针不动,左指针向左移动取单词
        int right = str.length() -1;
        int left = right;
        //存放反转后的字符串
        StringBuilder stringBuilder = new StringBuilder();
        while (left >= 0){
            //查找第一次出现的空格
            while (left>=0 && str.charAt(left) !=' ')
                left --;
            //将单词方到stringBuilder对象中
            stringBuilder.append(str.substring(left+1,right+1)+" ");
            //跳动单词之间的空格
            while (left >= 0 && str.charAt(left) ==' ')
                left --;
            //right指向下个单词的词尾,左指针继续前进
            right = left;
        }
        //去掉末尾的空格
        System.out.println("反转后的字符串:"+stringBuilder.toString().trim());
    }
}
