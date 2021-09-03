import com.zyds.mapper.Mapper;
import com.zyds.pojo.ByeBye;
import com.zyds.pojo.Hello;
import com.zyds.pojo.Student;
import com.zyds.service.MapperService;
import com.zyds.service.MapperServiceIP;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //获取Spring上下文对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ///我们的对象现在都在Spring中管理了，我们要使用，直接去里面取出来就可以
        Hello hello=(Hello) context.getBean("hello");
        System.out.println(hello);
    }

    @Test
    public void test(){
        //配置文件在被加载时就已经实例化了被注册的对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student ms=(Student) context.getBean("student");
        System.out.println(ms);
    }
}
