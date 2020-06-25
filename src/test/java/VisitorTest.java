import com.sun.tools.javac.util.Assert;
import org.junit.Test;

import java.io.IOException;

public class VisitorTest {
    @Test
    public void visitorsaveTest() throws NullPointerException, IOException {
        Assert.check(true, Visitor.saves("tshepo lesley seleke",20 ,
                "This file was created by Test Class",
                "crespo"));
    } @Test
    public void visitorloadTest() throws IOException {

        Assert.check(true,Visitor.load("tshepo lesley seleke"));
    }
}
