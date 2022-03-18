package ma.cigma.pfe.dao;

import ma.cigma.pfe.models.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static javax.persistence.Persistence.createEntityManagerFactory;

@Repository
public class ClientDaoImpl implements  IClientDao{

    //    EntityManagerFactory emf= createEntityManagerFactory("unit_clients");
//    EntityManager em=emf.createEntityManager();
//
//    public ClientDaoImpl() {
//    }
//    @Override
//    public Client save(Client c) {
//        em.getTransaction().begin();
//        em.persist(c);
//        em.getTransaction().commit();
//        return null;
//    }
//
//    @Override
//    public Client update(Client c) {
//        em.getTransaction().begin();
//        Client currentClient =
//                em.find(Client.class,c.getId());
//        currentClient.setName(c.getName());
//        em.persist(currentClient);
//        em.getTransaction().commit();
//        return null;
//
//    }
//    @Override
//    public void deleteById(long idClient) {
//        em.getTransaction().begin();
//        Client clientInDataBase = em.find(Client.class,idClient);
//        em.remove(clientInDataBase);
//        em.getTransaction().commit();
//
//    }
//    @Override
//    public Client findById(long idClient) {
//        return em.find(Client.class,idClient);
//    }
    @PersistenceContext
    private EntityManager entitymanager;
    @Override
    public Client save(Client p) {
        entitymanager.persist(p);
        return p;
    }

    @Override
    public Client update(Client c) {
        return null;
    }

    @Override
    public void deleteById(long idClient) {

    }

    @Override
    public Client findById(long idClient) {
        return null;
    }

    public ClientDaoImpl() {
        System.out.println("creation bean dao");
    }


}




