package Infrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext implements Context {

    private final Config config;
    private final Map<String, Object> beans = new HashMap<>();

    public ApplicationContext(Config config) {
        this.config = config;
    }

    @Override
    public <T> T getBean(String beanName) {

        if (beans.containsKey(beanName)) {
            return (T) beans.get(beanName);
        }

        Class<?> type = config.getImpl(beanName);
        Constructor<?> constructor = type.getConstructors()[0];
        if (constructor.getParameterCount() == 0) {
            try {
                T bean = (T) type.newInstance();
                beans.put(beanName, bean);
                return bean;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] params = new Object[constructor.getParameterCount()];
            for (int i = 0; i < constructor.getParameterCount(); i++) {
                String beanName2 = convertTypeToBeanName(parameterTypes[i].toString()); //convertTypeToBeanName -> convert first letter to lowercase
                params[i] = getBean(beanName2);
            }

            T bean = null;
            try {
                bean = (T) constructor.newInstance(params);
            } catch (Exception e) {
                e.printStackTrace();}

            beans.put(beanName, bean);
            return bean;
        }

    }

    private String convertTypeToBeanName(String parameterType) {
        char c[] = parameterType.toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        parameterType = new String(c);
        return parameterType;
    }
}
