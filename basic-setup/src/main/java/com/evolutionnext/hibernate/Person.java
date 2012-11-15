package com.evolutionnext.hibernate;

import com.google.common.base.Objects;
import org.hibernate.annotations.Entity;

public class Person {
    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) return false;
        Person other = (Person) o;

        return Objects.equal(other.getFirstName(), this.getFirstName()) &&
                Objects.equal(other.getLastName(), this.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getFirstName(), this.getLastName());
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .toString();
    }
}
