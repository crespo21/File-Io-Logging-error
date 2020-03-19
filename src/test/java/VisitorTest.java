import com.sun.tools.javac.util.Assert;
import org.junit.Test;

import java.io.IOException;

public class VisitorTest {
    @Test
    public void visitorsaveTest()throws IOException {
        Assert.check(true, Visitor.saves("tshepo lesley seleke",20,"This is file created by a Test class","crespo"));
    } @Test
    public void visitorloadTest()throws IOException {
        Assert.check(true, Visitor.load("tshepo lesley seleke"));
    }
}
