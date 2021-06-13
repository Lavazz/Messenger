package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.exception.EmptyPlaceholderException;

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
    public String generateMessage(Template template, Client client) throws EmptyPlaceholderException {
        String name;
        String subject;
        String messageContent = "Dear #{name}, the purpose of my mail is #{subject}";
        if(client.getName()==null&&client.getSubject()==null){
            throw new EmptyPlaceholderException("empty placeholder");
        }
        if(client.getName()==null){
            name="friend";
        }else{
            name=client.getName();
        }
        if(client.getSubject()==null){
            subject="chess";
        }else{
            subject=client.getSubject();
        }
        messageContent = messageContent.replace("#{subject}", subject);
        messageContent = messageContent.replace("#{name}",name);
        return messageContent;

    }
}
