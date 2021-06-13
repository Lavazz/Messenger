package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param client   the client
     * @return the string
     */
    public String generateMessage(Template template, Client client) {
        String name;
        String messageContent = "Dear #{name}, the purpose of my mail is #{subject}";
        if(client.getName()==null){
            name="friend";
        }else{
            name=client.getName();
        }
        messageContent = messageContent.replace("#{subject}", client.getSubject());
        messageContent = messageContent.replace("#{name}",name);
        return messageContent;

    }
}
