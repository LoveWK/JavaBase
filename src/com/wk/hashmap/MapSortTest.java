/**
 * FileName:  MapSortTest
 * Author:    wangkai_wb
 * Date:      2020/6/10
 * Description: map排序测试类
 */
package com.wk.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈map排序测试类〉
 *
 * @author wangkai_wb
 * @create 2020/6/10
 * @since 1.0.0
 */
public class MapSortTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","java");
        map.put("2","python");
        map.put("3","c");
        map.put("4","c#");
        map.put("5","php");
        //开始对map进行排序
        System.out.println("按键升序:"+MapSortUtil.sortByKeyAsc(map));
        System.out.println();
        System.out.println("按键降序:"+MapSortUtil.sortByKeyDesc(map));
        System.out.println();
        System.out.println("按值升序:"+MapSortUtil.sortByValueAsc(map));
        System.out.println();
        System.out.println("按值降序:"+MapSortUtil.sortByValueDesc(map));
    }
}
