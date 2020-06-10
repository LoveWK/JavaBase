/**
 * FileName:  MapSortUtil
 * Author:    wangkai_wb
 * Date:      2020/6/9
 * Description: map集合排序工具类
 */
package com.wk.hashmap;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈map集合排序工具类〉
 *
 * @author wangkai_wb
 * @create 2020/6/9
 * @since 1.0.0
 */
public class MapSortUtil {
    private static Comparator<Map.Entry> comparatorByKeyAsc = (Map.Entry o1,Map.Entry o2)->{
        if (o1.getKey() instanceof Comparable){
            return ((Comparable) o1.getKey()).compareTo(o2.getKey());
        }
        throw new UnsupportedOperationException("键的类型尚未实现Comparable接口");
    };

    private static Comparator<Map.Entry> comparatorByKeyDesc = (Map.Entry o1,Map.Entry o2) ->{
        if (o1.getKey() instanceof Comparable){
            return ((Comparable) o2.getKey()).compareTo(o1.getKey());
        }
        throw new UnsupportedOperationException("键的类型尚未实现Comparable接口");
    };

    private static Comparator<Map.Entry> comparatorByValueAsc = (Map.Entry o1,Map.Entry o2) ->{
        if (o1.getValue() instanceof Comparable){
            return ((Comparable) o1.getValue()).compareTo(o2.getValue());
        }
        throw new UnsupportedOperationException("值的类型尚未实现Comparable接口");
    };

    private static Comparator<Map.Entry> comparatorByValueDesc = (Map.Entry o1,Map.Entry o2) ->{
        if (o1.getValue() instanceof Comparable){
            return ((Comparable) o2.getValue()).compareTo(o1.getValue());
        }
        throw new UnsupportedOperationException("值的类型尚未实现Comparable接口");
    };

    /**
     * 按键升序排列
     * @param originMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> sortByKeyAsc(Map<K, V> originMap) {
        if (originMap == null) {
            return null;
        }
        return sort(originMap, comparatorByKeyAsc);
    }

    /**
     * 按键降序排列
     * @param originMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> sortByKeyDesc(Map<K, V> originMap) {
        if (originMap == null) {
            return null;
        }
        return sort(originMap, comparatorByKeyDesc);
    }

    /**
     * 按值升序排列
     * @param originMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> sortByValueAsc(Map<K, V> originMap) {
        if (originMap == null) {
            return null;
        }
        return sort(originMap, comparatorByValueAsc);
    }

    /**
     * 按值降序排列
     * @param originMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> sortByValueDesc(Map<K, V> originMap) {
        if (originMap == null) {
            return null;
        }
        return sort(originMap, comparatorByValueDesc);
    }

    /**
     * 排序逻辑的实现
     * @param originMap 需要排序的map集合
     * @param comparator 排序的方式
     * @param <K>
     * @param <V>
     * @return 返回一个排序好的map集合
     * stream方法:返回一个顺序Stream与此集合作为其来源。把集合操作改成流管道的操作.
     * sorted方法:返回由该流的元素组成的流，根据提供的 Comparator进行排序。
     * collect方法:流操作,使用 Collector对此流的元素执行 mutable reduction Collector 。
     * Collectors.toMap方法:返回一个 Collector ，它将元素累加到一个 Map ，其键和值是将所提供的映射函数应用于输入元素的结果。
     */
    private static <K, V> Map<K, V> sort(Map<K, V> originMap, Comparator<Map.Entry> comparator) {
        return originMap.entrySet()
                .stream()
                .sorted(comparator)
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }

}
