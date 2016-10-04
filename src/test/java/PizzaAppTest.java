import org.junit.Test;

public class AppRunnerTest {
    public AppRunnerTest(){

    }

    @Test
    public void testMain(){
        System.out.println("main");
        String[] args = null;
        AppRunner.main(args);
    }
}
