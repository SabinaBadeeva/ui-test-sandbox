import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExoticProduct extends ParentTest {

    @Test
    @Description("При успешном добавлении нового товара ОВОЩ с актиивным чекбоксом экзотический" +
            " товар отображается в таблице с значениями: " +
            "название товара, " +
            " выбран тип товара Овощ с атрибутом VEGETABLE," +
            " чекбокс выбран = true " +
            "После удаления товар отсутствует ")
    public void addVegetableExoticVisible() throws InterruptedException {
        //Добавить товар
        app.getFood().setButtonAdd();
        app.getFood().addProduct("Пепино");
        app.getFood().choiceTypeProductVeg();
        //Проверить,что выбран Овощ (по атрибуту VEGETABLE)
        String actualName = app.getFood().getTypeProduct();
        assertEquals(actualName, "VEGETABLE", "type not vegetable");
        app.getFood().tapCheckBox();
        //Проверить, что активен чекбокс Экзотический
        boolean isSelected = app.getFood().getCheckBoxValue();
        boolean expeсted = true;
        assertEquals(expeсted, isSelected, "checkBox is not active");
        //Нажать на кнопку сохранить
        app.getFood().setButtonSave();
        //Проверить, что Пепино добавился в таблицу
        app.getFood().getTextAddProductName("Пепино");
        //Проверить,что добавился Овощ
        app.getFood().getTextAddProductType("Овощ");
        //Удалить добавленный товар
        specification();
        resetDataBase();
        // Получить  список товаров, убедиться, что добавденного товара нет
        specification();
        app.getFood().getTableList();
    }

    @Test
    @Description("При успешном добавлении нового товара ФРУКТ с актиивным чекбоксом экзотический проверить,что" +
            "товар отображается в таблице с значениями:" +
            " - название товара, " +
            " - выбран тип товара Овощ с атрибутом FRUIT," +
            " - чекбокс выбран = true " +
            "После удаления товар отсутствует")
    public void addFruitExoticVisible() throws InterruptedException {
        // Добавить товар
        app.getFood().setButtonAdd();
        app.getFood().addProduct("Арбуз");
        app.getFood().choiceTypeProdFruit();
        //Проверить,что выбран Фрукт (по атрибуту FRUIT)
        String actualName = app.getFood().getTypeProduct();
        assertEquals(actualName, "FRUIT", "type is not fruit");
        //Нажать на чекбокс Экзотический
        app.getFood().tapCheckBox();
        //Проверить, что активен чекбокс Экзотический
        boolean isSelected = app.getFood().getCheckBoxValue();
        boolean expeсted = true;
        assertEquals(expeсted, isSelected, "checkBox is not active");
        app.getFood().setButtonSave();
        //Проверить, что Арбуз добавился в таблицу
        app.getFood().getTextAddProductName("Арбуз");
        //Проверить,что добавился Фрукт
        app.getFood().getTextAddProductType("Фрукт");
        // Удалить добавленный товар
        specification();
        resetDataBase();
        // Получить список товаров, убедиться, что добавденного товара нет
        specification();
        app.getFood().getTableList();
    }

}


