package ma.cigma.pfe.service;

import ma.cigma.pfe.models.Client;

import javax.transaction.Transactional;
import java.util.List;

public interface IClientService {
    Client save(Client c) ;

    Client modify(Client c);

    void removeById(long id);

    Client getById(long id);


    @Transactional
    void remove(long idClt);

    Client getOne(long idClt);

    List<Client> getAll();

}
