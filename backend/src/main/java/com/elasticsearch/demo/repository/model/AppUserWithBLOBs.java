package com.elasticsearch.demo.repository.model;

public class AppUserWithBLOBs extends AppUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.last_name
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    private String lastName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.first_name
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    private String firstName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.last_name
     *
     * @return the value of app_user.last_name
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.last_name
     *
     * @param lastName the value for app_user.last_name
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.first_name
     *
     * @return the value of app_user.first_name
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.first_name
     *
     * @param firstName the value for app_user.first_name
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}