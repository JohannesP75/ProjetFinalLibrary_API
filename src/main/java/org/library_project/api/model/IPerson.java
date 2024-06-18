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
}
