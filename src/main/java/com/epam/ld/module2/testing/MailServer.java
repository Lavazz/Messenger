package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

import java.io.*;

/**
 * Mail server class.
 */
public class MailServer {
    public static void main(String[] args) {
        new Messenger(new MailServer() , new TemplateEngine()).sendMessage(new Client("src/main/resources/inputData.txt"), new Template());
    }
    /**
     * Send notification.
     *
     * @param addresses  the addresses
     * @param messageContent the message content
     */
    public void send(String addresses, String messageContent) {
if(addresses=="console"){
    System.out.println(messageContent);
}else if(addresses!=null){
    writeToFile(addresses, messageContent);
}else{
    System.out.println("message don't send");
}
    }

    private void writeToFile(String addresses, String messageContent) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(addresses), "utf-8"))) {
            writer.write(messageContent);
        } catch (IOException e) {
            System.err.println("Problem writing to the file ");
        }
    }
}
