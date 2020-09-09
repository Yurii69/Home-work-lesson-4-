import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class myCarsTest {
    @BeforeSuite
    public void BeforeSuite() {
 System.out.println("I'm before suit");
    }

    @Test
    public void test1() {
     myCars myCar01;
     myCar01 = new myCars();
        myCars myCar02 = new myCars("Pontiac", "G6", 2.4f, "green", 5000.5f);


    }

    @Test
    public void test2() {
        String type = "hatchback";
        myCars myCar03 = new myCars("nissan", "versa", "hatchback", 1.8f, "blue", 4000.5f);
myCar03.drive();
myCar03.bringPassenger();
    }
}
