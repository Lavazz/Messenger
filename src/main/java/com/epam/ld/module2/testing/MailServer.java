package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.*;

/**
 * Mail server class.
 */
public class MailServer {
    public static void main(String[] args) {
       // new Messenger(new MailServer(), new TemplateEngine()).sendMessage(new Client("src/main/resources/"), new Template());
        new Messenger(new MailServer(), new TemplateEngine()).sendMessage(new Client(), new Template());
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MailServer.class);

    /**
     * Send notification.
     *
     * @param addresses      the addresses
     * @param messageContent the message content
     */
    public void send(String addresses, String messageContent) {
        if (addresses == null) {
            LOGGER.info(messageContent);
        } else {
            writeToFile(addresses, messageContent);
        }
    }

    private void writeToFile(String addresses, String messageContent) {
        String outputAddress = addresses + "output.txt";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputAddress), "utf-8"))) {
            writer.write(messageContent);
        } catch (IOException e) {
            LOGGER.error("Problem writing to the file ");
        }
    }
}
