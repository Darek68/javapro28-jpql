package ru.darek;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        initPersist();

    }
    public static void initPersist() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SingleUnit");
        EntityManager entityManager = emf.createEntityManager();
        Client client = new Client("Maniek");
        Phone phone1 = new Phone("75463325456");
        phone1.setClient(client);
        Phone phone2 = new Phone("749556254461");
        phone2.setClient(client);
        Address address = new Address("ul. Zelonaya 27");
        address.setClient(client);
        client.getPhoneSet().add(phone1);
        client.getPhoneSet().add(phone2);
        client.setAddress(address);
        System.out.println(client.getId() + "  " + client.getName() + " " + client.getPhoneSet());
        EntityTransaction transaction = entityManager.getTransaction();
//        Выполняется открытие транзакции
        transaction.begin();
//        Объект помещается в Persistence Context - INSERT не выполняется
        entityManager.persist(client);
        entityManager.persist(phone1);
        entityManager.persist(phone2);
        entityManager.persist(address);
//        Выполняется коммит транзакции - выполняется INSERT
        transaction.commit();
        entityManager.close();
    }
}
