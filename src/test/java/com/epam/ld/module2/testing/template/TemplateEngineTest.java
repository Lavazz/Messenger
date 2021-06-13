package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.exception.EmptyPlaceholderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateEngineTest {


    private TemplateEngine templateEngine=new TemplateEngine();
    private static final Template template=new Template("Dear #{name}, the purpose of my mail is #{subject}");

    @Test
    void generateMessageValid(){
        Client client=new Client("someEmail@gmail.com", "chess", "someName" );
        String actual=templateEngine.generateMessage(template, client);
        String expected="Dear someName, the purpose of my mail is chess";
        assertEquals(expected, actual);
    }


    @Test
    void generateMessageWithoutName() throws EmptyPlaceholderException {
        Client client=new Client("someEmail@gmail.com", "chess");
        String actual=templateEngine.generateMessage(template, client);
        String expected="Dear friend, the purpose of my mail is chess";
        assertEquals(expected, actual);
    }

    @Test
    void generateMessageWithoutSubject() throws EmptyPlaceholderException {
        Client client=new Client("someEmail@gmail.com");
        client.setName("someName");
        String actual=templateEngine.generateMessage(template, client);
        String expected="Dear someName, the purpose of my mail is chess";
        assertEquals(expected, actual);
    }


    @Test
    void generateMessageEmptyPlaceholder(){
        Client client=new Client("someEmail@gmail.com");

        Assertions.assertThrows(EmptyPlaceholderException.class, () -> {
            templateEngine.generateMessage(template, client);;
        });
    }



}
