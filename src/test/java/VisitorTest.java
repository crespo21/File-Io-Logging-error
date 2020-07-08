import com.sun.tools.javac.util.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VisitorTest {
    @Test
    public void visitorSaveTest() throws NullPointerException, IOException {
        Assert.check(Visitor.saves("tshepo lesley seleke", 20,
                "This file was created by Test Class",
                "crespo"));
    } @Test
    public void visitorLoadTest() {

        Assert.check(true,Visitor.load("tshepo lesley seleke"));
    }
}
