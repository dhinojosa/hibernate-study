package com.evolutionnext.hibernate;

import com.google.common.base.Objects;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Set;

public class Band extends Act {
    private Long id;
    private Set<Artist> artists;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @ManyToMany(mappedBy = "bands")
    @JoinTable(name="band_artists",
            joinColumns = {@JoinColumn(name = "artistID")},
            inverseJoinColumns = {@JoinColumn(name = "bandID")})
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
                Objects.equal(other.getAlbums(), this.getAlbums()) &&
                Objects.equal(other.artists, this.artists);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.name,
                this.getAlbums(),
                this.artists);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("albums", getAlbums())
                .add("artists", artists)
                .toString();
    }
}
