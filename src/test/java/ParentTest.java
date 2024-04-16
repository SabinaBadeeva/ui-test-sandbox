import org.example.managers.DriverManager;
import org.example.managers.InitManager;
import org.example.managers.PageManager;
import org.example.managers.TestPropManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.example.utils.PropConst.BASE_URL;


public class ParentTest {


    /**
     * Менеджер страничек
     *
     * @see PageManager#getPageManager()
     */
    protected static PageManager app = PageManager.getPageManager();

    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    protected final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
        app.init();
    }


    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }


    public static void specification() throws InterruptedException {
        Thread.sleep(2000);
    }
    // Удалить данные
    public void resetDataBase() {
        app.resetData();}


    }


