package ma.cigma.pfe;

import ma.cigma.pfe.models.*;
import ma.cigma.pfe.presentation.ClientController;
import ma.cigma.pfe.service.ClientServiceImpl;
import ma.cigma.pfe.service.IClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Arrays;
import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) {
        ApplicationContext context= new
                ClassPathXmlApplicationContext("spring.xml");
        context.getBean(IClientService.class);

        ClientController ctr= (ClientController) context.getBean("ctrl1");
        //ClientController ctr= context.getBean(ClientController.class);
        Client client1 = new Client("Omar");
        Client client2 = new Client("Said");
        Client client3 = new Client("Ahmed");
// Test1 => save 3 Clients
        ctr.save(client1);
        ctr.save(client2);
        ctr.save(client3);


// Test2 => getAll Clients before modify and remove
        ctr.getAll().stream()
                .forEach(i-> System.out.println(i));
// Test3 => getOne Client service
        System.out.println(ctr.getOne(1));
// Test4 => modify Client service
        client1.setName("Hassan");
        ctr.modify(client1);
// Test5 => remove Client service
        //ctr.remove(2);
// Test getAll Client after modify and remove
        ctr.getAll().stream()
                .forEach(i-> System.out.println(i));


//        ClientController ctrl = (ClientController) context.getBean("idCtrl");
//        // Test save use case for three clients
//        ctrl.save(new Client("OMAR"));
//        ctrl.save(new Client("ismail"));
//        ctrl.save(new Client("AHMED"));
//        ctrl.save(new Client("FARAH"));
//        ctrl.save(new Client("OMAR"));
//        ctrl.save(new CLIENTVIP("ismail","dj"));
//        ctrl.save(new ClientNormal("OMAR",2));

// Test modify use case for client with id==1
//        ctrl.modify(new Client(1,"IBTIHAL"));
//        ctrl.removeById(2);
//        Client found = ctrl.getById(1);
//        Client client = new Client("ismail");
//        List<facture> factures = Arrays.asList(
//                new facture(120.00,"ismail",client),
//                new facture(12.00,"ismail",client));
//        client.setFactures(factures);
//        List<Promotion> promotions=Arrays.asList(new Promotion("remise 10%"),new Promotion("solde 40%"));
//        client.setPromotions(promotions);
//        CarteFidelio carteFidelio = new CarteFidelio(client, "zerz");
//        carteFidelio.setClient(client);
//        client.setCarteFidelio(carteFidelio);
//        ctrl.save(client);
    }
}
