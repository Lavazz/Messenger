package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class MailServerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    MailServer mailServer = new MailServer();
    TemplateEngine templateEngine = new TemplateEngine();
    Messenger messenger = new Messenger(mailServer, templateEngine);
    String messageContent = "Hello dear friend";
    Template template = new Template();

    @Test
    void MailServerToFile() {
        Client client = new Client("src/test/resources/");

        mailServer.send(client.getAddresses(), messageContent);
        String expected = messageContent;
        String actual = "";
        try (BufferedReader br = new BufferedReader(new FileReader(client.getAddresses() + "output.txt"))) {
            String s = "";
            while ((s = br.readLine()) != null) {
                actual = s;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void MAilServerToConsole() {
        Client client = new Client();
        mailServer.send(client.getAddresses(), messageContent);

        //  Assert.assertEquals("Hello dear friend", outputStreamCaptor.toString().trim());
        Assert.assertEquals("Hello dear friend", systemOutRule.getLog()
                .trim());
    }
}




