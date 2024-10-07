package org.example.hw4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program
{
//    Задание: Настройте связь между вашим приложением и базой данных MySQL
//    с использованием Hibernate. Создайте несколько объектов Person и сохраните их в базу данных.

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory()){


            Session session = sessionFactory.getCurrentSession();


            session.beginTransaction();


            Person person = new Person("Pavel",33);
            session.save(person);
            System.out.println("Object student save successfully");



            session.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}