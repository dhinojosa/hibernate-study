package com.evolutionnext.hibernate;

import com.google.common.base.Objects;

import java.util.Set;

public class Band {
    private Long id;
    private Set<Album> albums;
    private Set<Artist> artists;
    private String name;

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

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Band)) return false;
        Band other = (Band) o;
        return  Objects.equal(other.name, this.name) &&
                Objects.equal(other.albums, this.albums) &&
                Objects.equal(other.artists, this.artists);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.name,
                this.albums,
                this.artists);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("albums", albums)
                .add("artists", artists)
                .toString();
    }
}
