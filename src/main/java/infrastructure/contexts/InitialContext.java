//package infrastructure.context;
//
//import infrastructure.config.configs;
//import infrastructure.config.JavaConfig;
//
//public class InitialContext {
//
//    private static configs config = new JavaConfig();
//
//    public <T> T getInstance(String name) {
//        Class<?> type = config.getImpl(name);
//        try {
//            return (T) type.newInstance();
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//}
