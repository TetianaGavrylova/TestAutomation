import org.junit.*;
import static org.junit.Assert.*;

public class Tests
{

    @Test
    public void Test1()
    {
        Solution solution = new Solution();

        assertEquals(solution.RotThirteen("Hello world"), "Uryyb jbeyq");
    }

    @Test
    public void Test2()
    {
        Solution solution = new Solution();

        assertEquals(solution.RotThirteen("Goodbye world"), "Tbbqolr jbeyq");
    }
}