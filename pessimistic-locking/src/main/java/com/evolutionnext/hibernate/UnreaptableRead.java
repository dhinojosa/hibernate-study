package com.evolutionnext.hibernate;

import org.hibernate.LockOptions;
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

        Runnable hog = new Runnable() {
            public void run() {
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                Transaction tx = session.beginTransaction();

                Album ledZeppelin1 = (Album) session.load(Album.class, 1L, LockOptions.UPGRADE);
                ledZeppelin1.setYear((short) 1899);
                System.out.println("Hog Begin: " + System.currentTimeMillis());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hog End: " + System.currentTimeMillis());
                tx.commit();
            }
        };

        Runnable gazelle = new Runnable() {
            public void run() {
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                Transaction tx = session.beginTransaction();

                Album ledZeppelin1 = (Album) session.load(Album.class, 1L, LockOptions.UPGRADE);
                ledZeppelin1.setYear((short) 1976);
                System.out.println("Gazelle Begin: " + System.currentTimeMillis());
                tx.commit();
                System.out.println("GazelleDone: " + System.currentTimeMillis());
            }
        };

        Thread t1 = new Thread(hog);
        Thread t2 = new Thread(gazelle);

        t1.start();
        Thread.sleep(1000);
        t2.start();

        t1.join();
        t2.join();
    }
}
