import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class HomeTest {

    HomePage homePage = new HomePage();


    @Test
    public void testPagerUrlAndTitle() {
        homePage
                .open()
                .asssertUrl("https://practice.automationbro.com/");
        homePage
                .asssertTitle("Practice E-Commerce Site – Automation Bro");
    }

    @Test
    public void testInteragitComBotaoGetStarted() {
        homePage.open()
                .getStaterdBtn()
                .click();
        homePage.asssertUrlMensage("get-started");

        // Verify heading by cssSelector
        homePage.headingTitle()
                .shouldHave(text("Think different. Make different."));

        // Verify isPresent logo;
        homePage.verifyLogoVisible()
                .shouldHave(visible);

    }

    @Test
    public void testMultipleElements() {
        open("https://practice.automationbro.com/");

        List<String> expectedLink = List.of("Home", "About", "Shop", "Blog", "Contact", "My account");

        ElementsCollection linkLists = homePage.linkList();

        // Assertion
        homePage.linkList()
                .shouldHave(CollectionCondition.texts(expectedLink));

    }

    @Test
    public void testFormFields() {
        homePage
                .open()
                .getBtnSupportForm()
                .click();

        homePage.inputSupportName("Jean");
        homePage.inputSupportEmail("jean@gmail.com");
        homePage.inputSupportSubject("Coloca o teste e vamos embora");
        homePage.selectDropDown("Technical Team");
        homePage.selectCheckinBox().click();
        homePage.getDateBtn().click();
        homePage.getDateSelect().click();
        homePage.getSubmintSelect().click();
    //Testes
    }
}
