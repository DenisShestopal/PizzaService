package Infrastructure.Context;

public interface Context {

    <T> T getBean(String beanName);
}
