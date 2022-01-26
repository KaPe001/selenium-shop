package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


@Slf4j
public class WebListener extends AbstractWebDriverEventListener {

    @Override
    public void afterClickOn(WebElement element, WebDriver webDriver) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>EventListenerAfterClick");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver webDriver) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>EventListenerBeforeClick");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>EventListenerAfterNavigateTo");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>EventListenerBeforeNavigateTo");
    }
}
