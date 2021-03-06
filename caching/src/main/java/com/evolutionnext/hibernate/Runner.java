package com.evolutionnext.hibernate;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class Runner {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Album album = (Album) session.load(Album.class, 1L);
        System.out.println(album.getName());
        tx.commit();
        System.out.println("---");
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        album = (Album) session.load(Album.class, 1L);
        System.out.println(album.getName());
        tx.commit();
    }

}
