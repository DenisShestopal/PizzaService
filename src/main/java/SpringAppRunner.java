import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppRunner {

    public static void main(String ... args){
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("appContext.xml");
        //указываем, на основе какой конфигурации спринга работаем

    }
}