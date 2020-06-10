/**
 * FileName:  WeChatRedPackage
 * Author:    wangkai_wb
 * Date:      2020/6/9
 * Description: 微信红包的实现原理
 */
package com.wk.WeChatRedPackage;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈微信红包的实现原理〉
 *
 * @author wangkai_wb
 * @create 2020/6/9
 * @since 1.0.0
 * 微信红包算法应该主要考虑以下几个因素：
 * 1.微信红包金额是随机数
 *  只不过这个随机数有限制：精确到两位小数；最小金额是0.01；
 *  最大金额也有限制：2倍的剩余红包平均金额（2倍的数据是毕导视频给出的）
 * 2.不能超发，就是你发了3块钱红包最后红包总额不能超过3块。
 * 3.先抢和后抢的收益均值要大致相同
 */
public class WeChatRedPackage {
    public static void main(String[] args) {
        //设置红包总金额参数
        double sum = 0;
        //定义Map集合,用于获取每个人对应的金额
        Map<String,Double> map = new HashMap<>();
        //定义一个list集合,用于获取运气王
        List list = new ArrayList();
        //获得红包分配的数组集合
        ArrayList<Double> res = WXRedPackageAlgorithm(10,3);
        //遍历集合
        for (int i = 0; i <res.size() ; i++) {
            double money = res.get(i);
            sum += money;
            System.out.println("第"+i+"个人获得:"+money+"元");
            //将每个人获取的值传到map中
            map.put("第"+i+"个人",money);
        }
        System.out.println("红包已被领完");
        System.out.println();
        System.out.println("红包总金额为:"+sum+"元");
        //按升序排序
        Map<String,Double> sortedMap =sortByValue(map);
        sortedMap.forEach((key, value)->{
//            System.out.println(key+":"+value);
            list.add(key);
        });
        System.out.println();
        System.out.println("恭喜"+list.get(0)+"成为运气王,获得金额:"+sortedMap.get(list.get(0))+"元");
    }

    /**
     * 红包分配的数组集合
     * @param restMoney 红包总额
     * @param restNum 分给的人数
     * @return
     */
    private static ArrayList<Double> WXRedPackageAlgorithm(double restMoney,int restNum){
        //根据需要分配的人数进行红包总金额的分配
        ArrayList<Double> res = new ArrayList<>(restNum);
        // 生成随机数工具
        Random random = new Random();

        while (restNum >1){
            // 最大的红包为:两倍的平均红包大小
            double max = (restMoney/restNum)*2;
            // 产生[0,1)之间的随机数
            double r = random.nextDouble();
            // 抢到的红包区间[0,max)
            double money = r*max;
            if(money<0.01)
                money = 0.01;
            else//floor方法:返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数。
                money = Math.floor(money*100)/100;
            res.add(money);

            restNum--;
            //剩余总金额 = 总金额-已经获取红包的金额
            restMoney -= money;
        }
        //最后一个红包为剩余余额
        res.add(Math.floor(restMoney*100)/100);
        return res;
    }

    /**
     * 对map集合进行降序排序,为了获得运气王
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    private static <K,V extends Comparable<? super V>> Map<K,V> sortByValue(Map<K,V> map){
        //创建一个链表集合
        List<Map.Entry<K,V>> list = new LinkedList<>(map.entrySet());
        //使用集合类的排序方法
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                //按降序排序,如果不加前面的-号,就是升序排序
                return -(o1.getValue().compareTo(o2.getValue()));
            }
        });
        //遍历list,分离出map,使用另一个map集合接收拍好序的集合
        Map<K,V> result = new LinkedHashMap<>();
        for (Map.Entry<K,V> entry : list){
            result.put(entry.getKey(),entry.getValue());
        }
        return result;
    }
}
