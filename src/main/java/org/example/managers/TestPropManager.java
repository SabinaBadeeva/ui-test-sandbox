package org.example.managers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс для управления пропертями
 */
public class TestPropManager {
    /**
     * Переменна для хранения данных считанных из файла properties и переданных пользователем
     * Т.е. переменная для хранения пользовательских properties
     * @see Properties - реализован на основе {@link java.util.Hashtable}
     */
    private final Properties properties = new Properties();

    /**
     * Переменна для хранения объекта TestPropManager
     */
    private static TestPropManager INSTANCE = null;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     * Происходит загрузка содержимого файла application.properties в переменную {@link #properties}
     */
    private TestPropManager() {
        loadApplicationProperties();
        loadCustomProperties();
    }

    /**
     * Метод ленивой инициализации TestPropManager
     *
     * @return TestPropManager - возвращает TestPropManager
     */
    public static TestPropManager getTestPropManager() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropManager();
        }
        return INSTANCE;
    }

    /**
     * Метод подгружает содержимого файла application.properties в переменную {@link #properties}
     * Либо из файла переданного пользователем через настройку -DpropFile={nameFile}
     */
    private void loadApplicationProperties() {
        try {
            properties.load(new FileInputStream(
                    new File(System.getProperty("prop","src\\main\\resources\\aplication.properties"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод заменяет значение содержащиеся в ключах переменной {@link #properties}
     * Заменяет на те значения, что передал пользователь через maven '-D{name.key}={value.key}'
     * Замена будет происходить только в том случае если пользователь передаст совпадающий key из application.properties
     */
    private void loadCustomProperties() {
        properties.forEach((key, value) -> System.getProperties()
                .forEach((customUserKey, customUserValue) -> {
                    if (key.toString().equals(customUserKey.toString()) &&
                            !value.toString().equals(customUserValue.toString())) {
                        properties.setProperty(key.toString(), customUserValue.toString());
                    }
                }));
    }


    /**
     * Метод возвращает значения записанное в ключе в переменной {@link #properties}, если нет переменной вернет null
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
