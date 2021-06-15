package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import java.io.*;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
    HashMap<String, String> input;

    public String generateMessage(Template template, Client client)  {
        String inputTemplate = template.templateContent;
        String address=client.getAddresses();

        input = new HashMap<>();

        if (address == "console") {
            getConsoleResources();
        }else if(address!=null){
            getDataFromFile(address);
        }else {
            throw new NoSuchElementException("address is empty");
        }

        String name = input.get("name");
        String subject = input.get("subject");
        String day = input.get("day");
        return String.format(inputTemplate, name, subject, day);

    }

    private void getConsoleResources() {
        Scanner in = new Scanner(System.in);
        input.put("name", getDataFromConsole(in, "name"));
        input.put("subject", getDataFromConsole(in, "subject"));
        input.put("day", getDataFromConsole(in, "day of the week"));
        in.close();
    }

    private void getDataFromFile(String address) {

        try(BufferedReader br = new BufferedReader(new FileReader(address))) {

            String s="";
            int count=0;
            while((s=br.readLine())!=null) {
                String[] splitString = s.split("=");
                if (splitString.length == 2) {
                    input.put(splitString[0], splitString[1]);
                } else {
                    input.put(splitString[0], "");
                    count++;
                }
            }
            if(count==3){
                throw new NoSuchElementException("All fields is empty");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }


    private String getDataFromConsole(Scanner in, String value) {
        System.out.printf("Input %s:", value);
        return in.nextLine();

    }

}
