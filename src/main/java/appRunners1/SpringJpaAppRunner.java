package appRunners1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJpaAppRunner {

    public static void main(String ... args){
        ConfigurableApplicationContext repoContext =
                new ClassPathXmlApplicationContext("repoContext.xml");
        //указываем, на основе какой конфигурации спринга работаем

//        System.out.println(Arrays.toString(repoContext.getBeanDefinitionNames()));

        ConfigurableApplicationContext appContext =
                new ClassPathXmlApplicationContext(
                        new String[]{"appContext.xml"}, repoContext);

        repoContext.close();
        appContext.close();

    }
}
