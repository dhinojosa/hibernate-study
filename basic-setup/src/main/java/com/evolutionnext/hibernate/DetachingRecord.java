package com.evolutionnext.hibernate;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 * User: Daniel Hinojosa (dhinojosa@evolutionnext.com)
 * Date: 11/17/12
 * Time: 10:08 AM
 */
public class DetachingRecord {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Album album = (Album) session.load(Album.class, 1L);
        System.out.println(album); //Album must be used.
        tx.commit();

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        album.setYear((short) 2000); //Updating a year else where.
        session.saveOrUpdate(album);
        tx.commit();
    }
}
