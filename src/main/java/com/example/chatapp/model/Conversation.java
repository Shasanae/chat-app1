package com.example.chatapp.model;

public class Conversation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column conversation.id
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column conversation.name
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column conversation.id
     *
     * @return the value of conversation.id
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column conversation.id
     *
     * @param id the value for conversation.id
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column conversation.name
     *
     * @return the value of conversation.name
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column conversation.name
     *
     * @param name the value for conversation.name
     *
     * @mbg.generated Mon Mar 03 11:09:10 ICT 2025
     */
    public void setName(String name) {
        this.name = name;
    }
}