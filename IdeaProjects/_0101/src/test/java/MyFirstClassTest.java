import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyFirstClassTest {

    private MyFirstClass MFC = new MyFirstClass();

    @Test
    public void MyFirstClassTest()
    {
        System.out.println(MFC.myFunction());
        assertEquals(MFC.myFunction(),"Hello World","Error1");
    }
}