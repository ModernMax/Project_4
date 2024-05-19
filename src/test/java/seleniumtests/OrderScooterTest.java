package seleniumtests;

import pageobjects.MainPage;
import pageobjects.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderScooterTest extends AbstractTest {
private final String name;
private final String surname;
private final String address;
private final String metroStation;
private final String phoneNumber;

public OrderScooterTest(String name, String surname, String address, String metroStation, String phoneNumber){
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.metroStation = metroStation;
    this.phoneNumber = phoneNumber;
}
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                { "Аргентина", "Алексеева", "Красная площадь д 1", "сокольники", "+79111213191"},
                { "Виктор", "Соленый", "Самокатинкая стриит 21", "черкизовская", "+79122132134"}
        };
    }
    @Test
    public void orderScooterTopButton() {
        new MainPage(getWebDriver())
                .clickButtonOrderTop();
        new OrderPage(getWebDriver())
                .createOrderFirstStep(name, surname, address, metroStation, phoneNumber)
                .createOrderSecondStep()
                .checkOrderStatus();
    }

    @Test
    public void orderScooterBottomButton() {
        new MainPage(getWebDriver())
                .clickBottomOrderButton();
        new OrderPage(getWebDriver())
                .createOrderFirstStep(name, surname, address, metroStation, phoneNumber)
                .createOrderSecondStep()
                .checkOrderStatus();
    }
}
