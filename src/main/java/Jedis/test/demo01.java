//package Jedis.test;
//
//import Jedis.test.utils.JedisPoolUtils;
//import org.junit.jupiter.api.Test;
//import redis.clients.jedis.Jedis;
//
//import java.io.InputStream;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class demo01 {
//
//    /*   jedis测试类
//     *   1 获取连接
//     *   2 操作
//     *   3 关闭连接
//     *
//     *
//     *
//     *
//     * */
//    private Jedis jedis = new Jedis("localhost", 6379);
//
//    @Test
//    private void test1() {
//
//
//        jedis.set("username", "Michael");
//        //将键值对 activeCode Run 20 second 键值对存入redis,并且20秒后自动删除
//
//        jedis.setex("activeCode", 20, "Run 20 second");
//
//        jedis.close();
//    }
//
//    @Test
//    private void testHash() {
//        jedis.hset("user", "name", "小张");
//        jedis.hset("user", "age", "23");
//        jedis.hset("user", "gender", "male");//key 相当于HashMap中变量名字, field为 键 value为值
//
//        String s = jedis.hget("user", "gender");
//        System.out.println(s);
//        //获取所有数据
//        Map<String, String> user = jedis.hgetAll("user");
//        Set<String> keySet = user.keySet();
//        for (String key : keySet) {
//            String value = user.get(key);
//            System.out.println(key + "<===>" + value);
//        }
//        jedis.close();
//    }
//
//    @Test
//    public void testList() {
//        List<String> list = null;
//        jedis.lpush("myList", "a", "b", "c");
//        jedis.rpush("myList", "a", "b", "c");
//        list = jedis.lrange("myList", 0, -1);
//        System.out.println(list);
//
//        String ele = jedis.lpop("myList");
//        System.out.println(ele);
//        String ele1 = jedis.rpop("myList");
//        System.out.println(ele1);
//        jedis.del("myList");
//        jedis.close();
//    }
//    @Test
//    public void testSet() {
//        jedis.sadd("mySet", "java", "PHP", "C#");
//        Set<String> set = jedis.smembers("mySet");
////        Iterator<String> iterator = set.iterator();
////        while (iterator.hasNext()){
////            String s = iterator.next();
////            System.out.println(s);
////        }
//        for (String s : set) {
//            System.out.println(s);
//        }
//        jedis.close();
//    }
//
//    @Test
//    public void testSortedSet() {
//
//        jedis.zadd("SortedSet", 9, "AA");
//        jedis.zadd("SortedSet", 5, "GG");
//        jedis.zadd("SortedSet", 7, "HH");
//        //获取
//        Set<String> sortedSet = jedis.zrange("SortedSet", 0, -1);
//        for (String s : sortedSet) {
//            System.out.println(s);
//        }
//        jedis.del("SortedSet");
//        jedis.close();
//    }
//    @Test
//    public void JedisPoolUtilsTest(){
//          //通过连接池工具类获取
//        Jedis jedisPool = JedisPoolUtils.getJedisPool();
//        jedisPool.set("aa","bb");
//        jedisPool.close();
//    }
//}
