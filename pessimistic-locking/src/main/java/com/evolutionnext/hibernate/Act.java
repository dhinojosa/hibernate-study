package com.evolutionnext.hibernate;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Act {
    private Long id;
    private Set<Album> albums;

    public Act() {
        this.albums = new HashSet<Album>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    protected void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }
}
