/**
 * FileName:  HashMapDemo
 * Author:    wangkai_wb
 * Date:      2020/3/14
 * Description: HashMap
 */
package com.wk.hashmap;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈HashMap〉
 *
 * @author wangkai_wb
 * @create 2020/3/14
 * @since 1.0.0
 */
public class HashMapDemo {
    public static void main(String[] args) {
        //构造一个空的HashMap
        Map map = new HashMap();
        //默认的初始容量为16,默认的负载因子是0.75
        Map map1 = new HashMap(16, (float) 0.75);
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        //方法详细信息
        //1.public int size() 返回此地图中键值映射的数量
        System.out.println("数量:"+map.size());
        //2.public boolean isEmpty() 如果此map不包含键值映射，则返回 true 。
        System.out.println("空?"+map.isEmpty());
        //3.public V get(Object key) 返回到指定键所映射的值
        System.out.println("映射值:"+map.get("1"));
        //4.public boolean containsKey(Object key) 如果此映射包含指定键的映射，则返回 true 。
        System.out.println("是否包含key 1的映射:"+map.containsKey("1"));
        //5.public V put(K key,V value) 新加映射关系。 如果地图先前包含了该键的映射，则替换旧值。
        map.put("5","e");
        //6.public void putAll(Map<? extends K,? extends V> m)
        // 将指定地图的所有映射复制到此地图,这些映射将替换此映射对当前在指定映射中的任何键的任何映射。
        map1.put("1","A");
        map1.put("2","B");
        map1.put("3","C");
        map.putAll(map1);
        System.out.println("新映射"+map.get("1"));//A
        //7.public V remove(Object key) 从该map中删除指定键的映射（如果存在）。
        map.remove("5");
        System.out.println("删除5后:"+map.get("5"));
        //8.public void clear() 从map中删除所有的映射。
        //map.clear();
        //9.public boolean containsValue(Object value)
        System.out.println("是否有value对应的映射key"+map.containsValue("C"));
        //10.public Set<K> keySet() 返回此map中包含的键的Set视图。
        Set mapSet = map.keySet();
        Iterator iterator = mapSet.iterator();
        while (iterator.hasNext()){
            System.out.println("key 的 set值"+iterator.next());
        }
        //11.public Collection<V> values() 返回此地图中包含的值的Collection视图。
        Collection collection=map.values();
        Iterator valuesIterator = collection.iterator();
        while (valuesIterator.hasNext()){
            System.out.println("values的值:"+valuesIterator.next());
        }
        //12.public V getOrDefault(Object key,V defaultValue) 返回到指定键所映射的值,如果没有显示默认值
        System.out.println("如果没有key对应的value:"+map.getOrDefault("8","aa"));
        //13.public boolean remove(Object key,Object value) 删除指定key和 value的对应关系,如果关系不对应,则不改变
        System.out.println(map.remove("4","D"));
        //14.public boolean replace(K key,V oldValue,V newValue) 替换指定key值对应的value值
        map.replace("1","A","aaa");
        //jdk8的forEach的用法
        map.forEach((key,value)->{
            System.out.println("key:"+key+" value:"+value);
        });
    }
}
