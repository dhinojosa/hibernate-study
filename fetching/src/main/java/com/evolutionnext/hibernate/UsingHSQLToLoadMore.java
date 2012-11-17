package com.evolutionnext.hibernate;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import java.util.Set;

public class UsingHSQLToLoadMore {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();


        tx.commit();
    }

}
