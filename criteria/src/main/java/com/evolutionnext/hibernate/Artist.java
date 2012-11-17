package com.evolutionnext.hibernate;

import com.google.common.base.Objects;


public class Artist extends Act {
    private String stageName;
    private String firstName;
    private String lastName;


    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
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
        if (!(o instanceof Artist)) return false;
        Artist other = (Artist) o;

        return Objects.equal(other.getFirstName(), this.getFirstName()) &&
                Objects.equal(other.getLastName(), this.getLastName()) &&
                Objects.equal(other.getAlbums(), this.getAlbums()) &&
                Objects.equal(other.stageName, this.stageName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getFirstName(), this.getLastName(),
                this.getAlbums(), this.stageName);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("firstName", this.getFirstName())
                .add("lastName", this.getLastName())
                .add("albums", super.getAlbums())
                .add("stageName", this.getStageName())
                .toString();
    }
}
