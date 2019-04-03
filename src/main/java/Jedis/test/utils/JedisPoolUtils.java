package Jedis.test.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    /*       JedisPool工具类
     *       加载配置文件 配置连接池参数
     *       提供获取连接方法
     * */
    private  static JedisPool jedisPool;
    private  static  Properties properties;
    static  {
        //读取配置文件, 创建 Properties对象 关联文件

            init();

        //获取数据,设置到JedisPoolConfig中
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        //初始化jedisPool
        jedisPool = new JedisPool(jedisPoolConfig, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));

    }
    private static void init()  {
        if (properties == null) {
            properties = new Properties();

            InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");

            try {
                 if (in !=null) {
                     properties.load(in);
                 }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Jedis getJedisPool(){
        return  jedisPool.getResource();
    }
}
