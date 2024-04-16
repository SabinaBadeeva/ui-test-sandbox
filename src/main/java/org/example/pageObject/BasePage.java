package org.example.pageObject;

import org.example.managers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Базовый класс всех страничек
 */
public class BasePage {
    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    protected static final DriverManager driverManager = DriverManager.getDriverManager();


    /**
     * Объект для выполнения любого js кода
     *
     * @see JavascriptExecutor
     */
    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

    /**
     * Объект явного ожидания
     * При применении будет ожидать заданного состояния 10 секунд с интервалом в 1 секунду
     */
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10, 1000));

    /**
     * Функция позволяющая производить scroll до любого элемента с помощью js
     */
    protected WebElement scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    /**
     * Явное ожидание состояния clickable элемента
     */
    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Общий метод по заполнения полей ввода
     *
     * @return
     */
    protected WebElement fillInputField(WebElement element, String value) {
        scrollSauceBlock(element);
        waitUtilElementToBeClickable(element).click();
        element.sendKeys(value);
        return element;
    }


    /**
     * Скролл до элемента
     */
    protected void scrollSauceBlock(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}


