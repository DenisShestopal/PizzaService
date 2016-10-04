package Infrastructure;

public interface Context {

    <T> T getBean(String beanName);
}
