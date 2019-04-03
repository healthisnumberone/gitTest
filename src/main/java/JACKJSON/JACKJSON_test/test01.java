//package JACKJSON.JACKJSON_test;
//
//import JACKJSON.JACKJSON_domain.Person;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class test01 {
//    //把java对象 转换成为JSON对象....
//    @Test
//    public void test01() throws IOException {
//        //创建Person对象
//        Person p = new Person();
//        p.setName("小李");
//        p.setAge(23);
//        p.setGender(true);
//        //创建jackjson核心对象 ObjectMapper
//        ObjectMapper objectMapper = new ObjectMapper();
//        //转换..
//        /*  writeValue(参数1:obj)
//            File  将obj对象转换成为JSON字符串, 并保存到指定的文件中
//            Writer 将obj对象转换成为JSON字符串,并将json数据天冲到字符输出流中
//            OutputStream 将obj对象转换成为JSON字符串,并将json数据天冲到字节输出流中...
//         *  writeValueAsString(obj) 将对象转为JSON对象
//         *
//         *
//         * */
//        String str = objectMapper.writeValueAsString(p);
////        System.out.println(str);//{"name":"小李","gender":true,"age":23}
//        //测试WriteValue方法 将数据输出到txt文件中...
////        objectMapper.writeValue(new File("D:\\TestOutput\\JackJSON.txt"),p);
//
//        //将数据关联到Writer中
//        objectMapper.writeValue(new FileWriter("D:\\TestOutput\\JackJSON2.txt"),p);
//        //
//    }
//    @Test
//    public void ListTransformTest(){
//
//    }
//}
