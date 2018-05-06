import org.junit.*;
import static org.junit.Assert.*;

public class TestsLargestNumber
{

    @Test
    public void Test1()
    {
        SolutionLargestNumber solution = new SolutionLargestNumber();

        assertEquals(solution.GetLargestNumber(3), 3);
    }

    @Test
    public void Test2()
    {
        SolutionLargestNumber solution = new SolutionLargestNumber();

        assertEquals(solution.GetLargestNumber(36), 63);
    }

    @Test
    public void Test3()
    {
        SolutionLargestNumber solution = new SolutionLargestNumber();

        assertEquals(solution.GetLargestNumber(367902), 976320);
    }

    @Test
    public void Test4()
    {
        SolutionLargestNumber solution = new SolutionLargestNumber();

        assertEquals(solution.GetLargestNumber(1999999999), 2147483647);
    }

}