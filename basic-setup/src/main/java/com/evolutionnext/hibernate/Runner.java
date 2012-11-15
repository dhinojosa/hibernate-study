package com.evolutionnext.hibernate;

import org.hibernate.classic.Session;

public class Runner {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Album thriller = new Album();
        thriller.setName("Thriller");
        thriller.setYear((short) 1982);
        session.save(thriller);

        Artist artist = new Artist();
        artist.addAlbum(thriller);

        session.getTransaction().commit();
    }

}
