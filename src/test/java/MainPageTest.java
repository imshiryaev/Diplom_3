import Base.BaseTest;
import org.example.pageobject.components.Header;
import org.junit.Test;

public class MainPageTest extends BaseTest {

    Header header;

    @Test
    public void test() {
        header = new Header(driver);
        header.clickOnButtonUserCabinet();
    }
}
