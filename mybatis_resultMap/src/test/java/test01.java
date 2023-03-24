import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class test01 {


    public static void main(String[] args) throws IOException {

        String path = "com/atguigu/mybatis/pojo";
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);

        while(resources.hasMoreElements()){
            System.out.println(resources.nextElement());
        }

    }
}
