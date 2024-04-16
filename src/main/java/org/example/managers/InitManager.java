package org.example.managers;
import java.time.Duration;
import static org.example.utils.PropConst.IMPLICITLY_WAIT;
import static org.example.utils.PropConst.PAGE_LOAD_TIMEOUT;


/**
 * Класс для инициализации фреймворка
 */
public class InitManager {
    /**
     * Менеджер properties
     */
    private static final TestPropManager props = TestPropManager.getTestPropManager();

    /**
     * Менеджер WebDriver
     */
    private static final DriverManager driverManager = DriverManager.getDriverManager();

    /**
     * Инициализация framework и запуск браузера со страницей приложения
     */
    public static void initFramework() {
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT))));
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT))));
        driverManager.getDriver().manage().window().maximize();
    }

    /**
     * Завершения работы framework - гасит драйвер и закрывает сессию с браузером
     */
    public static void quitFramework() {
        driverManager.quitDriver();
    }

}
