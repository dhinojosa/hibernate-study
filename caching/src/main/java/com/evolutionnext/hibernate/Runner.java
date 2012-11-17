package com.evolutionnext.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Runner {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Album thriller = new Album();
        thriller.setName("Thriller");
        thriller.setYear((short) 1982);

        Artist artist = new Artist();
        artist.setFirstName("Michael");
        artist.setLastName("Jackson");
        artist.addAlbum(thriller);

        thriller.addAct(artist);
        session.persist(thriller);

        tx.commit();

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
        Criteria artistCriteria = session.createCriteria(Artist.class)
                .add(Restrictions.like("firstName", "Mi%"));
        Criteria albumCriteria = artistCriteria.createCriteria("albums");
        artistCriteria.addOrder(Order.asc("firstName"));
        albumCriteria.add(Restrictions.between("year", (short) 1900, (short) 2010));
        System.out.println(artistCriteria.list());
        tx.commit();
    }

}
