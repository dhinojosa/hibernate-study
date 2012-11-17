package com.evolutionnext.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class UsingStandardTransactions {
    public static void main(String[] args) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            //run code

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (HibernateException he) {
                    //log he and rethrow e
                }
            }
            throw e;
        } finally {
            try {
                session.close();
            } catch (HibernateException he) {
                throw he;
            }
        }
    }

}
