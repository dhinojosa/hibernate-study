package com.evolutionnext.hibernate;

import org.hibernate.CacheMode;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class BatchInsert {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
//        session.setCacheMode(CacheMode.IGNORE);

        for (int i = 0; i < 100000; i++) {
            Album album = new Album();
            album.setName("Foo" + 1);
            album.setYear((short) (1900 + 1));

            session.save(album);
            if (i % 20 == 0) { //20, same as the JDBC batch size
                //flush a batch of inserts and release memory:
                session.flush();
                session.clear();
            }
        }
        tx.commit();
    }

}
