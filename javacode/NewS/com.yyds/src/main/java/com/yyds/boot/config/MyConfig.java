package com.yyds.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.yyds.boot.bean.Car;
import com.yyds.boot.bean.Pet;
import com.yyds.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


/*
* 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
* 2.配置本身也是组件
* 3.proxyBeanMethods:代理bean的方法
*       Full(proxyBeanMethods = true)、默认为true
*       Lite(proxyBeanMethods = false)
*       组件依赖
*       true是检测组件之间是否存在依赖
*       false不检测是否存在依赖，启动快
*/

/*
*
*
*/
@Import({User.class, DBHelper.class})//导入外部组件
@Configuration(proxyBeanMethods = true)//告诉SpringBoot这是一个配置类 == 配置文件
@EnableConfigurationProperties(Car.class)//代替类上的@Component组件
public class MyConfig {

    /*
    * 外部无论对配置类中的这个组件注册方法调用多少此获取的都是之前注册容器中的单实例对象
    * @return
    */
//    @ConditionalOnMissingBean(name = "tom")
    @Bean("user01")//给容器中添加组件。以方法名作为组件的id，返回类型就是组件类型。返回的值，就是组件在容器中的实例,bean名默认为方法名
    public User user01(){
        User zhangsan = new User("zhangsan",20);
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
