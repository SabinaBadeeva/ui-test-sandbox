package org.example.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class QuaLitNavBar extends BasePage {

    private By navbarDropdown = By.id("navbarDropdown"); // локатор для выпадающего списка Песочница
    private By productsDropdown = By.linkText("Товары"); // локатор для перехода в Товары
    private By resetDropdown = By.linkText("Сброс данных"); // локатор для Сброса данных

    // Метод нажатия на выпадающий список Песочница
    public void setNavbarDropdown() {
        driverManager.getDriver().findElement(navbarDropdown);
        wait.until(ExpectedConditions.visibilityOfElementLocated(navbarDropdown)).click();
    }

    // Метод выбора в выпадающем списке пункта Товары
    public void setProductsDropdown() {

        driverManager.getDriver().findElement(productsDropdown);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsDropdown)).click();
    }

    //Метод выбора в выпадающем списке пункта Сброс данных
    public void setResetDropdown() {

        driverManager.getDriver().findElement(resetDropdown);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetDropdown)).click();
    }

    public void resetData() {
        setNavbarDropdown();
        setResetDropdown();
    }


}