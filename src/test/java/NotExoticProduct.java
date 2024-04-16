import jdk.jfr.Description;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class NotExoticProduct extends ParentTest {


    @Test
    @Description("При успешном добавлении нового товара ОВОЩ без активации чекбокса Экзотический, " +
            "товар отображается в таблице с значениями: " +
            " название товара, " +
            "выбран тип товара Овощ с атрибутом VEGETABLE, " +
            "чекбокс не выбран = false " +
            "После удаления товар отсутствует ")
    public void addProductVegetableNotExotic() throws InterruptedException {
        //Добавить товар
        app.getFood().setButtonAdd();
        app.getFood().addProduct("Морковь");
        app.getFood().clickVegetable();
        //Проверить,что Овощ соответствует атрибуту VEGETABLE
        String actualName = app.getFood().getTypeProduct();
        assertEquals(actualName, "VEGETABLE", "type not vegetable");
        //Проверить, что  чекбокс Экзотический не активен
        boolean isSelected = app.getFood().getCheckBoxValue();
        boolean expeсted = false;
        assertEquals(isSelected, expeсted, "vegetable is exotic");
        //Нажать Сохранить
        app.getFood().setButtonSave();
        //Проверить, что Морковь добавилась в таблицу
        app.getFood().getTextAddProductName("Морковь");
        //Проверить,что добавился Овощ
        app.getFood().getTextAddProductType("Овощ");
        //Удалить продукт
        resetDataBase();
        // Получить список товаров, убедиться, что добавденного товара нет
        specification();
        app.getFood().getTableList();
    }

    @Test
    @Description("При успешном добавлении нового товара ФРУКТ с не актиивным чекбоксом экзотический " +
            "товар отображается в таблице с значениями:" +
            " название товара, " +
            " выбран тип товара Фрукт с атрибутом FRUIT," +
            " чекбокс выбран = false ")
    public void addFruitExoticVisible() throws InterruptedException {
        // Добавить товар
        app.getFood().setButtonAdd();
        app.getFood().addProduct("Слива");
        //Выбрать тип фрукт
        app.getFood().choiceTypeProdFruit();
        //Проверить,что Фрукт соответствует атрибуту FRUIT
        String actualName = app.getFood().getTypeProduct();
        assertEquals(actualName, "FRUIT", "type not fruit");
        //Проверить, что  чекбокс Экзотический не активен
        specification();
        boolean isSelected = app.getFood().getCheckBoxValue();
        boolean expeсted = false;
        assertEquals(isSelected, expeсted, "fruit is exotic");
        //Нажать Сохранить
        app.getFood().setButtonSave();
        //Проверить, что Слива добавилась в таблицу
        app.getFood().getTextAddProductName("Слива");
        //Проверить,что добавился Фрукт
        app.getFood().getTextAddProductType("Фрукт");
        //Удалить продукт
        resetDataBase();
        // Получить  список товаров, убедиться, что добавденного товара нет
        specification();
        app.getFood().getTableList();
    }

}