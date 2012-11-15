package com.evolutionnext.hibernate;

import com.google.common.base.Objects;
import org.hibernate.annotations.Entity;

public class Album {
    private Long id;
    private String name;
    private short year;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Album)) return false;
        Album other = (Album) o;

        return Objects.equal(other.name, this.name) &&
                Objects.equal(other.year, this.year);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.year);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name).add("year", year).toString();
    }
}
