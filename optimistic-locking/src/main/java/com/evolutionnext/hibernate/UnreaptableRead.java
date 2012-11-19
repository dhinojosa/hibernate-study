package com.evolutionnext.hibernate;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class UnreaptableRead {


    public static void main(String[] args) throws InterruptedException {

        //User1 is doing the following
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Album ledZeppelin1 = (Album) session.load(Album.class, 1L);
        Album ledZeppelin2 = (Album) session.load(Album.class, 1L);
        System.out.println(ledZeppelin1); //Use the reference
        System.out.println(ledZeppelin2); //Use the reference
        tx.commit();

        Runnable runnable = new Runnable() {
            public void run() {
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                Transaction tx = session.beginTransaction();
                Album ledZeppelin1 = (Album) session.load(Album.class, 1L);
                ledZeppelin1.setYear((short) 1999);
                tx.commit();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
