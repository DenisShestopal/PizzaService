//package infrastructure.context;
//
//import infrastructure1.config.configs1;
//import infrastructure1.config.JavaConfig;
//
//public class InitialContext {
//
//    private static configs1 config = new JavaConfig();
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
