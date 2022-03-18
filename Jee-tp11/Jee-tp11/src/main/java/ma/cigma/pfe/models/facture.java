package ma.cigma.pfe.models;
import lombok.ToString;
import javax.persistence.*;

@Entity
@ToString
public class facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double amount;
    private String description;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    public facture() {
    }
    public facture(double amount, String description,Client client) {
        this.amount = amount;
        this.description = description;
        this.client =client;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
