package com.evolutionnext.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Set;

public class UsingOuterJoin {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Album album = (Album) session.load(Album.class, 1L);
        System.out.println(album);

        System.out.println("----");

        Set<Act> acts = album.getActs();
        System.out.println(acts);

        tx.commit();
    }

}
