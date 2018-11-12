import WJ.factory.InstruGeneration;
import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){

        System.out.println(InstruGeneration.disassemblyTransfer("10001110000000110000000010010100"));
    }
    @Test
    public void test2(){
        System.out.println(InstruGeneration.disassemblyTransfer("00000011111000000000011111001000"));
    }
}
