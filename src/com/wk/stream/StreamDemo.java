/**
 * FileName:  StreamDemo
 * Author:    wangkai_wb
 * Date:      2020/6/11
 * Description: Stream的API使用说明
 */
package com.wk.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Stream的API使用说明〉
 *
 * @author wangkai_wb
 * @create 2020/6/11
 * @since 1.0.0
 * Stream 是 Java 8 中集合数据处理的利器，很多本来复杂、需要写很多代码的方法，比如过滤、分组等操作，
 * 往往使用 Stream 就可以在一行代码搞定，当然也因为 Stream 都是链式操作，一行代码可能会调用好几个方法。
 */
public class StreamDemo {
    public static void main(String[] args) {
        //调用of方法
        Stream streamOf = createStream();
//        System.out.println("调用of方法创建对象:"+streamOf.count());
        //调用empty方法
        Stream streamEmpty = StreamEmpty();
//        System.out.println("调用empty方法创建空对象:"+streamEmpty.count());
        //调用concat方法
        Stream streamConcat =StreamConcat();
//        System.out.println("调用concat方法:"+streamConcat.count());
        Integer streamMax = StreamMax();
//        System.out.println("调用max方法:"+streamMax);
        Integer maxMine = MaxMine();
//        System.out.println("调用自定义comparator的max方法:"+maxMine);
        Optional<String> findFirst = findFirst();
//        System.out.println("调用findFirst方法获取的结果:"+findFirst.get());
        Optional<String> any = findAny();
//        System.out.println("调用findAny方法获取的结果:"+findAny().get());
//        System.out.println("调用peek方法:");
//        streamPeek();
//        System.out.println("调用forEach方法:");
//        streamForEach();
//        System.out.println("调用forEachOrdered方法:");
//        streamForEachOrdered();
//        System.out.println("调用limit方法:");
//        streamLimit();
//        System.out.println("调用skip方法:");
//        streamSkip();
//        System.out.println("调用disinct方法:");
//        streamDistinct();
//        System.out.println("调用无参数sorted方法:");
//        streamSorted();
//        System.out.println("调用有参数sorted方法:");
//        sortedWithComparator();
//        System.out.println("调用filter方法:");
//        streamFilter();
//        System.out.println("调用map方法:");
//        streamMap();
//        System.out.println("调用flatMap方法:");
//        flatMap();
//        System.out.println("调用collect方法:");
//        streamCollect();
//        collectList();
//        System.out.println("调用groupingBy方法:");
//        groupingBy();
//        System.out.println("调用groupingByCount方法:");
//        groupingByCount();
//        System.out.println("调用toArray方法:");
//        streamToArray();
        System.out.println("调用reduce方法:");
        streamReduce();

    }
    //of方法:可接收一个泛型对象或可变成泛型集合，构造一个 Stream 对象。
    private static Stream createStream(){
        Stream<String> stream = Stream.of("a","b","c");
        return stream;
    }
    //empty方法:创建一个空的 Stream 对象。
    private static Stream StreamEmpty(){
        Stream<String> stream = Stream.empty();
        return stream;
    }
    //concat方法:连接两个 Stream ，不改变其中任何一个 Steam 对象，返回一个新的 Stream 对象。
    private static Stream StreamConcat(){
        Stream<String> stream1 = Stream.of("a","b","c");
        Stream<String> stream2 = Stream.of("c","d");
        Stream<String> stream3 = Stream.concat(stream1,stream2);
        return stream3;
    }
    //max方法:一般用于求数字集合中的最大值，或者按实体中数字类型的属性比较，拥有最大值的那个实体。
    //它接收一个 Comparator<T>，它是一个函数式接口类型，专门用作定义两个对象之间的比较，
    //例如下面这个方法使用了 Integer::compareTo这个方法引用。
    private static Integer StreamMax(){
        Stream<Integer> integerStream = Stream.of(2,2,100,5);
        Integer max = integerStream.max(Integer::compareTo).get();
        return max;
    }
    //自己定义一个Comparator
    private static Integer MaxMine(){
        Stream<Integer> integerStream = Stream.of(2,2,100,5);
        Comparator<Integer> comparator = (x,y) -> (x.intValue() < y.intValue()) ? -1 : ((x.equals(y) ? 0 :1));
        Integer max = integerStream.max(comparator).get();
        return max;
    }

    //findFirst方法,获取stream中的第一个元素
    private static Optional<String> findFirst(){
        Stream<String> stringStream = Stream.of("a","b","c");
        Optional<String> first = stringStream.findFirst();
        return first;
    }

    //findAny方法:获取 Stream 中的某个元素，如果是串行情况下，一般都会返回第一个元素，并行情况下就不一定了。
    private static Optional<String> findAny(){
        Stream<String> stringStream = Stream.of("a","b","c");
        Optional<String> any = stringStream.findAny();
        return any;
    }

    //peek方法:建立一个通道，在这个通道中对 Stream 的每个元素执行对应的操作，对应 Consumer<T>的函数式接口，
    // 这是一个消费者函数式接口，顾名思义，它是用来消费 Stream 元素的，
    // 比如下面这个方法，把每个元素转换成对应的大写字母并输出。
    private static void streamPeek(){
        Stream<String> stream = Stream.of("a","b","c");
        List<String> list = stream.peek(e -> System.out.println(e.toUpperCase())).collect(Collectors.toList());
    }

    //forEach方法:和 peek 方法类似，都接收一个消费者函数式接口，可以对每个元素进行对应的操作，
    // 但是和 peek 不同的是，forEach 执行之后，这个 Stream 就真的被消费掉了，之后这个 Stream 流就没有了，
    // 不可以再对它进行后续操作了，而 peek操作完之后，还是一个可操作的 Stream 对象。
    // 正好借着这个说一下，我们在使用 Stream API 的时候，都是一串链式操作，这是因为很多方法，
    // 比如接下来要说到的 filter方法等，返回值还是这个 Stream 类型的，也就是被当前方法处理过的 Stream 对象，
    // 所以 Stream API 仍然可以使用。
    private static void streamForEach(){
        Stream<String> stream = Stream.of("a","b","c");
        stream.forEach(e -> System.out.println(e.toUpperCase()));
    }

    // forEachOrdered方法:功能与 forEach是一样的，不同的是，forEachOrdered是有顺序保证的，
    // 也就是对 Stream 中元素按插入时的顺序进行消费。
    // 为什么这么说呢，当开启并行的时候，forEach和 forEachOrdered的效果就不一样了。
    private static void streamForEachOrdered(){
        System.out.println("调用forEach方法:");
        Stream<String> streamForEach = Stream.of("a","b","c","d");
        streamForEach.parallel().forEach(e -> System.out.println(e.toUpperCase()));
        //当使用上面的代码时，输出的结果可能是 B、A、C、D 或者 A、C、D、B或者A、B、C、D，
        // 而使用下面的代码，则每次都是 A、 B、C、D
        System.out.println("调用forEachOrdered方法:");
        Stream<String> streamOrdered = Stream.of("a","b","c","d");
        streamOrdered.parallel().forEachOrdered(e -> System.out.println(e.toUpperCase()));

    }

    //limit方法:获取前 n 条数据，类似于 MySQL 的limit，只不过只能接收一个参数，就是数据条数。
    private static void streamLimit(){
        Stream<String> stream = Stream.of("a","b","c");
        stream.limit(2).forEach(e -> System.out.println(e));
    }

    //skip方法:跳过前 n 条数据，也可以理解成获取截取前面几条后,剩余的数据;
    private static void streamSkip(){
        Stream<String> stream = Stream.of("a","b","c");
        stream.skip(2).forEach(e -> System.out.println(e));
    }

    //distinct方法:元素去重，例如下面方法返回元素是 a、b、c，将重复的 b 只保留了一个。
    private static void streamDistinct(){
        Stream<String> stream = Stream.of("a","b","c","b","a");
        stream.distinct().forEach(e -> System.out.println(e));
    }

    //sorted方法:有两个重载，一个无参数，另外一个有个 Comparator类型的参数。
    //无参类型的按照自然顺序进行排序，只适合比较单纯的元素，比如数字、字母等。
    private static void streamSorted(){
        Stream<String> stream = Stream.of("a","c","b");
        stream.sorted().forEach(e -> System.out.println(e));
    }
    //有参数的需要自定义排序规则，例如下面这个方法，按照第二个字母的大小顺序排序，最后输出的结果是 a1、b3、c6。
    private static void sortedWithComparator() {
        Stream<String> stream = Stream.of("a1", "c6", "b3");
        stream.sorted((x, y) -> Integer.parseInt(x.substring(1)) > Integer.parseInt(y.substring(1)) ? 1 : -1).forEach(e -> System.out.println(e));
    }

    //filter方法:用于条件筛选过滤,筛选出符合条件的数据,
    //例如:下面这个方法，筛选出性别为 0，年龄大于 50 的记录。
    private static void streamFilter(){
        List<User> users = getUserData();
        Stream<User> stream = users.stream();
        stream.filter(user -> user.getGender()==0 && user.getAge()>50).forEach(e-> System.out.println(e));

        /**
         * 等同于下面这种形式,匿名内部类
         */
        /*stream.filter(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getGender() ==0 && user.getAge()>50;
            }
        }).forEach(e-> System.out.println(e));*/
    }

    //map方法:接受一个 Function函数式接口，把它翻译成映射最合适了，通过原始数据元素，映射出新的类型。
    private static void streamMap(){
        List<User> users = getUserData();
        Stream<User> stream = users.stream();
        List<UserDto> userDtos = stream.map(user -> dao2Dto(user)).collect(Collectors.toList());
        userDtos.forEach(userDto -> System.out.println(userDto));
    }

    //flatMap方法:用于将原有二维结构扁平化
    private static void flatMap(){
        List<User> users = getUserData();
        List<User> users1 = getUserData();
        List<List<User>> userList = new ArrayList<>();
        userList.add(users);
        userList.add(users1);
        Stream<List<User>> stream = userList.stream();
        List<UserDto> userDtos = stream.flatMap(subUserList -> subUserList.stream()).map(user -> dao2Dto(user)).collect(Collectors.toList());
        for (UserDto userDto : userDtos){
            System.out.println(userDto.toString());
        }
    }

    // 在进行了一系列操作之后，我们最终的结果大多数时候并不是为了获取 Stream 类型的数据，而是要把结果变为 List、Map 这样的常用数据结构，
    // 而 collection就是为了实现这个目的。
    private static void streamCollect(){
        Stream<Integer> integerStream = Stream.of(1,2,5,7,8,12,33);
        List<Integer> list = integerStream.filter(s -> s.intValue()>7).collect(Collectors.toList());
        for (Integer l : list){
            System.out.println(l);
        }
    }

    //这是 collect的另一个重载方法，你可以理解为它的参数是按顺序执行的，这样就清楚了，
    // 这就是个 ArrayList 从创建到调用 addAll方法的一个过程。
    private static void collectList(){
        Stream<Integer> integerStream1 = Stream.of(1,2,5,7,8,12,33);
        List<Integer> list1 = integerStream1.filter(s -> s.intValue()>7).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        for (Integer ls : list1){
            System.out.println(""+ls);
        }
    }

    //groupingBy方法:按照 userId 字段分组，返回以 userId 为key，List 为value 的 Map
    private static void groupingBy(){
        List<User> users = getUserData();
        User user = new User();
        user.setUserId(1);
        user.setUserName("新加的风筝1号");
        user.setAge(12);
        user.setGender(1);
        user.setPhone("13500011111");
        user.setAddress("无");
        users.add(user);
        User user1 = new User();
        user1.setUserId(2);
        user1.setUserName("新加的风筝2号");
        user1.setAge(15);
        user1.setGender(0);
        user1.setPhone("13700011111");
        user1.setAddress("无");
        users.add(user1);
        Map<Integer,List<User>> map = users.stream().collect(Collectors.groupingBy(User::getUserId));
        map.forEach((key,value) -> System.out.println("key:"+key+" value:"+value));
    }

    //groupingBy方法:返回每个 key 的个数
    private static void groupingByCount(){
        List<User> users = getUserData();
        User user = new User();
        user.setUserId(1);
        user.setUserName("新加的风筝1号");
        user.setAge(12);
        user.setGender(1);
        user.setPhone("13500011111");
        user.setAddress("无");
        users.add(user);
        User user1 = new User();
        user1.setUserId(2);
        user1.setUserName("新加的风筝2号");
        user1.setAge(15);
        user1.setGender(0);
        user1.setPhone("13700011111");
        user1.setAddress("无");
        users.add(user1);
        Map<Integer,Long> map = users.stream().collect(Collectors.groupingBy(User::getUserId,Collectors.counting()));
        map.forEach((key, value)-> System.out.println("key:"+key+" value:"+value));
    }

    //toArray方法:返回 User 数组，长度为最后的 Stream 长度。
    private static void streamToArray(){
        List<User> users = getUserData();
        Stream<User> stream = users.stream();
        User[] userArray = stream.filter(user -> user.getGender() ==0 && user.getAge()>50).toArray(User[]::new);
        Arrays.asList(userArray).forEach(user -> System.out.println(user));
    }

    //reduce方法:它的作用是每次计算的时候都用到上一次的计算结果，比如求和操作，前两个数的和加上第三个数的和，
    // 再加上第四个数，一直加到最后一个数位置，最后返回结果，就是 reduce的工作过程。
    private static void streamReduce(){
        Stream<Integer> stream = Stream.of(1,2,5,7,8,12,33);
        Integer sum = stream.reduce(0,(x,y)->x+y);
        System.out.println("累加的和:"+sum);
    }

    /**
     * 把User对象属性传给UserDto对象
     * @param user
     * @return
     */
    private static UserDto dao2Dto(User user){
        UserDto dto = new UserDto();
        try {
            BeanUtils.CopySameBean(user,dto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //其他额外处理
        return dto;
    }

    /**
     * 模拟客户信息
     * @return
     */
    private static List<User> getUserData(){
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for(int i=1; i<=10; i++){
            User user = new User();
            user.setUserId(i);
            user.setUserName(String.format("古时的风筝%s号",i));
            user.setAge(random.nextInt(100));
            user.setGender(i%2);
            user.setPhone("18311111111");
            user.setAddress("无");
            users.add(user);
        }
        return users;
    }

}
