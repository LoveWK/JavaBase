/**
 * FileName:  MapForeach
 * Author:    wangkai_wb
 * Date:      2020/6/10
 * Description: Map集合的遍历方法
 */
package com.wk.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Map集合的遍历方法〉
 *
 * @author wangkai_wb
 * @create 2020/6/10
 * @since 1.0.0
 */
public class MapForeach {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","Java");
        map.put("2","python");
        map.put("3","c");
        map.put("4","php");
        System.out.println("使用四种方法遍历map集合:------");
        //第一种:普遍使用,二次取值
        System.out.println("1.通过Map.keySet遍历key和value");
        for (String key : map.keySet()){
            System.out.println("key = "+key+" and value = "+map.get(key));
        }

        System.out.println();
        //第二种:使用iterator遍历
        System.out.println("2.通过Map.entrySet使用iterator遍历key和value");
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue());
        }

        System.out.println();
        //第三种:当map的容量比较大时,推荐使用
        System.out.println("3.通过Map.entrySet遍历key和value");
        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("key = "+entry.getKey()+" and value="+entry.getValue());
        }

        System.out.println();
        //第四种:jdk8的foreach用法
        System.out.println("4.通过jdk8提供的foreach方法遍历");
        map.forEach((key,value)->{
            System.out.println("key = "+key+" and value="+value);
        });
    }
}
