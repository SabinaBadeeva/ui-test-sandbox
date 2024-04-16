package org.example.managers;
import org.example.pageObject.Food;
import org.example.pageObject.QuaLitNavBar;
import static org.example.utils.PropConst.BASE_URL;


/**
 * Класс для управления страничками
 */
public class PageManager {

    private static PageManager pageManager;
    private QuaLitNavBar quaLitNavBar;
    private Food food;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     */
    private PageManager() {

    }

    /** Предварительные методы */
    public void init() {
        //Нажать на Кнопку Песочница
        getQualitNavBar().setNavbarDropdown();
        //Нажать на кнопку Товары
        getQualitNavBar().setProductsDropdown();
    }
    public  void initFramework() {
        InitManager.initFramework();}

    public void openStand() {
        TestPropManager.getTestPropManager().getProperty(BASE_URL);
        init();
    }

    /**
     * Ленивая инициализация PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }
    /**
     * Ленивая инициализация QuaLitNavBar
     */
    public QuaLitNavBar getQualitNavBar() {
        if (quaLitNavBar == null) {
            quaLitNavBar = new QuaLitNavBar();
        }

        return quaLitNavBar;
    }
    /**
     * Ленивая инициализация Food
     */
    public Food getFood() {
        if (food == null) {
            food = new Food();
        }

        return food;
    }

    public void resetData() {
        getQualitNavBar().resetData();
    }
}
