package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Food extends BasePage {

    private By buttonAdd = By.xpath(".//button[text()='Добавить']"); // локатор кнопки Добавить
    private By inputNameProduct = By.xpath(".//input[@placeholder ='Наименование']"); // локатор инпут-поля Наименование
    private By selectType = By.xpath(".//div/select[@id = 'type']"); // локатор селектора выбора Овощ/Фрукт
    private By selectTypeProduct = By.id("type");
    private By selectVegetable = By.xpath(".//div/select[@id = 'type']/option[text()='Овощ']");// локатор для выбора значения Овощ
    private By selectFruit = By.xpath(".//div/select[@id = 'type']/option[text()='Фрукт']");// локатор для выбора значения Фрукт
    //private By checkBox = By.xpath(".//label[text()='Экзотический']");// локатор чекбокса Экзотический
    private By checkBoxChoice = By.id("exotic");// локатор  чекбокса Экзотический
    private By buttonSave = By.xpath(".//button[text()='Сохранить']");// локатор кнопки Сохранить
    private By addProductName = By.xpath("//div/table/tbody/tr[5]/td[1]"); //локатор добавленного товара по Названию
    private By addProductType = By.xpath(".//div/table/tbody/tr[5]/td[2]"); //локатор добавленного товара по Названию
    private By addProductBool = By.xpath(".//div/table/tbody/tr[5]/td[3]"); // локатор значения true/false нового товара


    //Метод нажатия на кнопку Добавить (если элемент виден, кликаем по нему)
    public void setButtonAdd() {
        driverManager.getDriver().findElement(buttonAdd);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAdd)).click();
    }

    //Метод добавления товаров в инпут Наименование
    public void addProduct(String product) {
        fillInputField(driverManager.getDriver().findElement(inputNameProduct), product);

    }

    // Метод выбора типа продукта (если элемент виден, кликаем по нему)
    public void clickTypeProduct() {
        driverManager.getDriver().findElement(selectType);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectType)).click();

    }

    // Метод выбора типа Овощ (если элемент виден, кликаем по нему)
    public void clickVegetable() {
        driverManager.getDriver().findElement(selectVegetable);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectVegetable)).click();
    }

    public void choiceTypeProductVeg() {
        clickTypeProduct();
        clickVegetable();
    }

    // Метод выбора атрибуда value выпадающего списка
    public String getTypeProduct() {
        return driverManager.getDriver().findElement(selectTypeProduct).getAttribute("value");
    }


    // Метод выбора типа Фрукт (если элемент виден, кликаем по нему)
    public void choiceFruit() {
        driverManager.getDriver().findElement(selectFruit);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectFruit)).click();
    }

    public void choiceTypeProdFruit() {
        clickTypeProduct();
        choiceFruit();
    }

    //Метод выбора чекбокса Экзотический (если элемент виден, кликаем по нему)
    public void tapCheckBox() {
        driverManager.getDriver().findElement(checkBoxChoice);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxChoice)).click();

    }

    // Метод проверяющий,что чекбокс Экзотический активен
    public boolean getCheckBoxValue() {
        boolean webElement = driverManager.getDriver().findElement(checkBoxChoice).isSelected();
        return webElement;
    }

    //Метод нажать на кнопку Сохранить (если элемент виден, кликаем по нему)
    public void setButtonSave() {
        driverManager.getDriver().findElement(buttonSave);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSave)).click();
    }

    //Проверить, название добавленного товара
    public boolean getTextAddProductName(String dataTextProduct) {
        return new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(addProductName, dataTextProduct));
    }

    // Проверить тип названия добавленного товара
    public void getTextAddProductType(String dataTextProduct) {
        new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(addProductType, dataTextProduct));
    }


    // Вывод  изначального списка товаров
    public String getListProduct() {

        WebElement table = driverManager.getDriver().findElement(By.className("container-fluid"));

        // Находим  элементы с тегом tr
        List<WebElement> allList = table.findElements(By.tagName("tr"));

        // Перебираем элементы по тегу td
        for (WebElement row : allList) {
            List<WebElement> allListTd = row.findElements(By.tagName("td"));

            // Выводим список товаров
            for (WebElement list : allListTd) {
                System.out.println(list.getText());
            }
        }
        return allList.toString();
    }

    // Вывод  изначального списка товаров (более быстрый метод)
    public List<String> getTableList() {
        WebElement table = driverManager.getDriver().findElement(By.xpath("//div/table/tbody"));
        List<WebElement> rows = table.findElements(By.xpath("//tr"));
        java.util.Iterator<WebElement> iter = rows.iterator();
        while (iter.hasNext()) {
            WebElement row = iter.next();
            System.out.println(row.getText());
        }
        return Arrays.asList(rows.get(0).getText(),rows.get(1).getText(),rows.get(2).getText());
    }
}