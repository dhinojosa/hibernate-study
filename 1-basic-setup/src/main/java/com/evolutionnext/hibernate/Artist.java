package com.evolutionnext.hibernate;

import com.google.common.base.Objects;

import java.util.HashSet;
import java.util.Set;

public class Artist extends Person {
    private Set<Album> albums;
    private String stageName;

    public Artist() {
        this.albums = new HashSet<Album>();
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Artist)) return false;
        Artist other = (Artist) o;

        return Objects.equal(other.getFirstName(), this.getFirstName()) &&
                Objects.equal(other.getLastName(), this.getLastName()) &&
                Objects.equal(other.albums, this.albums) &&
                Objects.equal(other.stageName, this.stageName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getFirstName(), this.getLastName(),
                this.albums, this.stageName);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("firstName", super.getFirstName())
                .add("lastName", super.getLastName())
                .add("albums", this.getAlbums())
                .add("stageName", this.getStageName())
                .toString();
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }
}
