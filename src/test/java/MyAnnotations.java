import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class MyAnnotations {

    @DataProvider (name = "calculations")
    public Object[][] createData(Method m){
        switch (m.getName()){
            case "sum":
                return new Object[][]{{100, 20, 120}};
            case "difference":
                return new Object[][]{{100, 20, 80}};
            case "multiply":
                return new Object[][]{{100, 20, 2000}};
            case "division":
                return new Object[][]{{100, 20, 5}};
        }
        return null;
    }

    @Test (dataProvider = "calculations", groups = "Sum")
    public void sum(int A, int B, int result){
        Assert.assertEquals(A+B, result);
    }

    @Test (dataProvider = "calculations", groups = "Difference")
    public void difference(int A, int B, int result){
        Assert.assertEquals(A-B, result);
    }

    @Test (dataProvider = "calculations", groups = "Multiply")
    public void multiply(int A, int B, int result){
        Assert.assertEquals(A*B, result);
    }

    @Test (dataProvider = "calculations", groups = "Division")
    public void division(int A, int B, int result){
        Assert.assertEquals(A/B, result);
    }
}
