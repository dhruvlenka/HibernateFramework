package domain.lenka.com.hibernate_unidirectional_mapping.onetoone.dao;

import domain.lenka.com.hibernate_unidirectional_mapping.onetoone.entity.Pan;
import domain.lenka.com.hibernate_unidirectional_mapping.onetoone.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PersonPanDao {
    EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();

    EntityTransaction et = em.getTransaction();

    //saving person
    public Person savePersonDao (Person person, Pan pan){
        try {
            et.begin();
            em.persist(pan);
            em.persist(person);

            et.commit();
            return person;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //to delete the Pan by Pan Number
    public boolean deletePanByPanNumberDao(String panNumber){
        Pan pan = em.find(Pan.class, panNumber);

        if(pan != null){
            try {
                et.begin();
                Query query = em.createNativeQuery("SELECT * FROM Pan Where panNumber=?1", Person.class);
                query.setParameter(1, panNumber);

                Person person = (Person) query.getSingleResult();
                if(person != null){
                    person.setPan(null);
                    em.merge(person);
                }
                em.remove(pan);
                et.commit();
                return true;
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public Person getPersonById(int id){
        return em.find(Person.class, id);
    }
}
