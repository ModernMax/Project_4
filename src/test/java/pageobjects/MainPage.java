package pageobjects;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Шаблон Xpath кнопки заказа
    private final String orderButtonXpathTemplate = "(.//button[text() = 'Заказать'])[%s]";
    //Шаблон Xpath вопроса
    private final String questionXpathTemplate = ".//div[@id='accordion__heading-%s']/parent::div";
    //Шаблон Xpath ответа
    private final String answerXpathTemplate = ".//div[@id='accordion__panel-%s']";


    public void clickButtonOrderTop() {
        getWebDriver().findElement(By.xpath(String.format(orderButtonXpathTemplate, 1))).click();
    }


    public MainPage checkAnswerIsHidden(int index) {
        Assert.assertFalse(getWebDriver().findElement(By.xpath(String.format(answerXpathTemplate, index))).isDisplayed());
        return this;
    }

    public void checkAnswerIsDisplayedWithText(int index, String expectedText) {
        By answer = By.xpath(String.format(answerXpathTemplate, index));
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer));
        String actualText = getWebDriver().findElement(answer).getText();
        Assert.assertEquals("Фактический текст ответа не совпал с ожидаемым", expectedText, actualText);
    }

    public MainPage clickQuestionButton(int number) {
        WebElement question = getWebDriver().findElement(By.xpath(String.format(questionXpathTemplate, number)));
        scrollTo(question);
        question.click();
        return this;
    }

    public void clickBottomOrderButton() {
        WebElement orderButton = getWebDriver().findElement(By.xpath(String.format(orderButtonXpathTemplate, 1)));
        scrollTo(orderButton);
        orderButton.click();
    }
}
