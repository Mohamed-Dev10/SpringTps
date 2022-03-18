package ma.cigma.pfe.presentation;

import ma.cigma.pfe.dao.ClientDaoImpl;
import ma.cigma.pfe.dao.IClientDao;
import ma.cigma.pfe.models.Client;
import ma.cigma.pfe.service.ClientServiceImpl;
import ma.cigma.pfe.service.IClientService;

public class ClientController {

    private IClientService service;

    public void setService(IClientService service) {
        this.service = service;
    }

    public void save(Client c) {
        service.save(c);
    }

    public void modify(Client c){
        service.modify(c);
    }
    public void removeById(long id){
        service.removeById(id);
    }
    public Client getById(long id){
        return service.getById(id);
    }
}
