package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TemplateEngineTest {


    private TemplateEngine templateEngine = new TemplateEngine();
    Template template = new Template();
    Client client;

    @Test
    void generateMessageValid() {
        client = new Client("src/test/resources/inputTestData.txt");
        String actual = templateEngine.generateMessage(template, client);
        String expected = "Dear someName, the purpose of my mail is someSubject. I suggest we discuss it someDay";
        assertEquals(expected, actual);
    }


    @Test
    void generateMessageWithoutName() {
        client = new Client("src/test/resources/inputWithOutName.txt");
        String actual = templateEngine.generateMessage(template, client);
        String expected = "Dear , the purpose of my mail is someSubject. I suggest we discuss it someDay";
        assertEquals(expected, actual);
    }

    @Test
    void generateMessageEmpty() {
        client = new Client("src/test/resources/inputEmpty.txt");
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            templateEngine.generateMessage(template, client);
            ;
        });
    }
}

