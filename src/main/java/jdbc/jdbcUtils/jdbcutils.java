package jdbc.jdbcUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcutils {
    private static String url, user, password, driver;
    private static Properties pro;

    static {

            init();

        url = pro.getProperty("url");
        user = pro.getProperty("user");
        password = pro.getProperty("password");
        driver = pro.getProperty("driver");
        //注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //加载properties文件的方法init()
    private static void init() {


        try {
            if (pro == null) {
                pro = new Properties();
            }
            InputStream in = jdbcutils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            if (in!=null) {
                pro.load(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    //关闭/释放资源资源方法,,,
    private static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }
//    //测试in是否加载
//    @Test
//    public void testIn(){
//        try {
//            init();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void insertTest() {
//        ResultSet resultSet =null;
//        PreparedStatement prepareStatement =null;
//        Connection connection =null;
//
//        try {
//            connection = jdbcutils.getConnection();
//            String sql ="select * from province";
//            prepareStatement = connection.prepareStatement(sql);
//            resultSet = prepareStatement.executeQuery();
//            while (resultSet.next()){
//                int i = resultSet.getInt(1);
//                String province = resultSet.getString("name");
//                System.out.println(i+"===>"+province);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            jdbcutils.close(resultSet,prepareStatement,connection);
//        }
//    }
}
