
import org.junit.*;
import java.io.*;


public class MainTest {

    @Test
    public void testSortedRage() throws IOException {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        ByteArrayInputStream myIn = new ByteArrayInputStream("[94133,94133] [94226,94399] [94408,94501]".getBytes());
        System.setIn(myIn);
        Main.main(null);
        String standardOutput = myOut.toString();
        System.out.println(standardOutput);
        Assert.assertEquals("[94133,94133] [94226,94399] [94408,94501]\n", standardOutput);
        System.setIn(System.in);
    }

    @Test
    public void testUnsortedRange() throws IOException {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        ByteArrayInputStream myIn = new ByteArrayInputStream("[94133,94133] [94408,94501] [94226,94399]".getBytes());
        System.setIn(myIn);
        Main.main(null);
        String standardOutput = myOut.toString();
        System.out.println(standardOutput);
        Assert.assertEquals("[94133,94133] [94226,94399] [94408,94501]\n", standardOutput);
        System.setIn(System.in);
    }

    @Test
    public void testOverlappingRage() throws IOException {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        ByteArrayInputStream myIn = new ByteArrayInputStream("[94133,94133] [94300,94401] [94226,94399]".getBytes());
        System.setIn(myIn);
        Main.main(null);
        String standardOutput = myOut.toString();
        System.out.println(standardOutput);
        Assert.assertEquals("[94133,94133] [94226,94401]\n", standardOutput);
        System.setIn(System.in);
    }

    @Test
    public void testDeeplyOverlappingRange() throws IOException {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        ByteArrayInputStream myIn = new ByteArrayInputStream("[94133,94407] [94300,94401] [94226,94399] [94567,95701]".getBytes());
        System.setIn(myIn);
        Main.main(null);
        String standardOutput = myOut.toString();
        System.out.println(standardOutput);
        Assert.assertEquals("[94133,94407] [94567,95701]\n", standardOutput);
        System.setIn(System.in);
    }

    @Test
    public void testDeeplyOverlappingRageToSingle() throws IOException {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        ByteArrayInputStream myIn = new ByteArrayInputStream("[94133,94407] [94300,94401] [94401,94407] [94226,94399]".getBytes());
        System.setIn(myIn);
        Main.main(null);
        String standardOutput = myOut.toString();
        System.out.println(standardOutput);
        Assert.assertEquals("[94133,94407]\n", standardOutput);
        System.setIn(System.in);
    }

    @Test
    public void testSingleRange() throws IOException {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        ByteArrayInputStream myIn = new ByteArrayInputStream("[94133,94407]".getBytes());
        System.setIn(myIn);
        Main.main(null);
        String standardOutput = myOut.toString();
        System.out.println(standardOutput);
        Assert.assertEquals("[94133,94407]\n", standardOutput);
        System.setIn(System.in);
    }

    @Test
    public void testConsecutiveIncreasingLowerRange() throws IOException {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        ByteArrayInputStream myIn = new ByteArrayInputStream("[94133,94407] [94408,95401] [95402,96399]".getBytes());
        System.setIn(myIn);
        Main.main(null);
        String standardOutput = myOut.toString();
        System.out.println(standardOutput);
        Assert.assertEquals("[94133,96399]\n", standardOutput);
        System.setIn(System.in);
    }

    @Test
    public void testConsecutiveEqualLowerRange() throws IOException {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        ByteArrayInputStream myIn = new ByteArrayInputStream("[94133,94407] [94407,95401] [95401,96399]".getBytes());
        System.setIn(myIn);
        Main.main(null);
        String standardOutput = myOut.toString();
        System.out.println(standardOutput);
        Assert.assertEquals("[94133,96399]\n", standardOutput);
        System.setIn(System.in);
    }

    @Test
    public void testDuplicateRange() throws IOException {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        ByteArrayInputStream myIn = new ByteArrayInputStream("[94133,94407] [94409,95401] [94409,95401]".getBytes());
        System.setIn(myIn);
        Main.main(null);
        String standardOutput = myOut.toString();
        System.out.println(standardOutput);
        Assert.assertEquals("[94133,94407] [94409,95401]\n", standardOutput);
        System.setIn(System.in);
    }

}
