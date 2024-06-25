package org.library_project.api.model;

public interface IPerson {
    /**
     * Returns the username of the user
     * @return Username of the user
     */
    public String getUsername();

    /**
     * Returns the age of the Person in years
     * @return The age of Person
     */
    public Long calculateAge();

    /**
     * Return all the authorities held by a person
     * @return List of the name of the authorities held
     */
    public String[] getAllAuthorities();
}
