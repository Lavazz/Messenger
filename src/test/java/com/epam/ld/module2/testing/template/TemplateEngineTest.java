package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateEngineTest {

    private TemplateEngine templateEngine=new TemplateEngine();


    @Test
    void generateMessageValid(){
        Template template=new Template("Dear #{name}, the purpose of my mail is #{subject}");
        Client client=new Client("someEmail@gmail.com", "chess", "someName" );
        String actual=templateEngine.generateMessage(template, client);
        String expected="Dear someName, the purpose of my mail is chess";
        assertEquals(expected, actual);
    }


    @Test
    void generateMessageInValid(){

    }

    @Test
    void generateMessageEmptyPlaceholder(){

    }

    @Test
    void generateMessageFoundAllPlaceholders(){

    }

    @Test
    void generateMessageFoundNotAllPlaceholders(){

    }

    @Test
    void generateMessageFoundNothingPlaceholders(){

    }


}
