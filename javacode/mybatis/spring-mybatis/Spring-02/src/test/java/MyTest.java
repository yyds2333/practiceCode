import com.uuyd.config.YdsConfig;
import com.uuyd.pojo.Dog;
import com.uuyd.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(YdsConfig.class);
        User user=context.getBean("getUser",User.class);
        Dog dog=context.getBean("getDog",Dog.class);
        System.out.println(dog);
        System.out.println("==========================");
        System.out.println(user);
    }
}
