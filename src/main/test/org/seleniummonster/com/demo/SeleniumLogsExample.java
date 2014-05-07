package main.test.org.seleniummonster.com.demo;

import com.unitedinternet.portal.selenium.utils.logging.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import com.thoughtworks.selenium.HttpCommandProcessor;


public class SeleniumLogsExample {

    private BufferedWriter loggingWriter;
    protected LoggingSelenium selenium;

    @Before
    public void setUp() {

        final String resultPath = "absolute-path-to-where-your-result-will-be-written";
        final String resultHtmlFileName = resultPath + File.separator + "result.html";
        final String resultEncoding = "UTF-8";
        loggingWriter = LoggingUtils.createWriter(resultHtmlFileName, resultEncoding);

        LoggingResultsFormatter htmlFormatter =
                new HtmlResultFormatter(loggingWriter, resultEncoding);
        htmlFormatter.setScreenShotBaseUri(""); // this is for linking to the screenshots
        htmlFormatter.setAutomaticScreenshotPath(resultPath);
        // wrap HttpCommandProcessor from remote-control
        LoggingCommandProcessor myProcessor =
                new LoggingCommandProcessor(new HttpCommandProcessor("","",""), htmlFormatter);
        selenium = new LoggingDefaultSelenium(myProcessor);
        selenium.start();
    }


    @Test
    public void simpleTest()
    {
        System.out.println("This is the test");
    }

    @After
    public void tearDown() throws Exception{
        selenium.stop();
        try {
            if (null != loggingWriter) {
                loggingWriter.close();
            }
        } catch (IOException e) {
            // do nothing
        }
    }
}
