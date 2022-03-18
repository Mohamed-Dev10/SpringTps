package ma.cigma.pfe;

import ma.cigma.pfe.models.CarteFidelio;
import ma.cigma.pfe.models.Client;
import ma.cigma.pfe.models.Promotion;
import ma.cigma.pfe.models.facture;
import ma.cigma.pfe.presentation.ClientController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) {
        ApplicationContext context= new
                ClassPathXmlApplicationContext("spring.xml");
        ClientController ctrl = (ClientController)
                context.getBean("idCtrl");
        // Test save use case for three clients
        ctrl.save(new Client("OMAR"));
        ctrl.save(new Client("ismail"));
        ctrl.save(new Client("AHMED"));
        ctrl.save(new Client("FARAH"));
// Test modify use case for client with id==1
        ctrl.modify(new Client(1,"IBTIHAL"));
        ctrl.removeById(2);
        Client found = ctrl.getById(1);
        Client client = new Client("ismail");
        List<facture> factures = Arrays.asList(
                new facture(120.00,"ismail",client),
                new facture(12.00,"ismail",client));
        client.setFactures(factures);
        List<Promotion> promotions=Arrays.asList(new Promotion("remise 10%"),new Promotion("solde 40%"));
        client.setPromotions(promotions);
        CarteFidelio carteFidelio = new CarteFidelio(client, "zerz");
        carteFidelio.setClient(client);
        client.setCarteFidelio(carteFidelio);
        ctrl.save(client);
    }
}
