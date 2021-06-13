package com.epam.ld.module2.testing;

/**
 * The type Client.
 */
public class Client {
    private String addresses;
    private String subject;
    private String name;

    /**
     * Gets addresses.
     *
     * @return the addresses
     */
    public String getAddresses() {
        return addresses;
    }

    public Client() {
    }

    public Client(String addresses, String subject, String name) {
        this.addresses = addresses;
        this.subject = subject;
        this.name = name;
    }

    public Client(String addresses, String subject) {
        this.addresses = addresses;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    /**
     * Sets addresses.
     *
     * @param addresses the addresses
     */
    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
