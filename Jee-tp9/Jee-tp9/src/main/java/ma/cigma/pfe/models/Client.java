package ma.cigma.pfe.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "TClients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public List<facture> getFactures() {
        return factures;
    }

    public void setFactures(List<facture> factures) {
        this.factures = factures;
    }
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private List<facture> factures;

    public void setCarteFidelio(CarteFidelio carteFidelio) {
        this.carteFidelio = carteFidelio;
    }

    public CarteFidelio getCarteFidelio() {
        return carteFidelio;
    }

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private CarteFidelio carteFidelio;
    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="my_join_table_client_promotion",joinColumns = @JoinColumn(
            name = "client_fk",
            referencedColumnName = "id"
    ),
            inverseJoinColumns = @JoinColumn(
                    name = "promotion_fk",
                    referencedColumnName = "id"
            ))
    private List<Promotion> promotions;

    public Client(String name) {
        this.name = name;
    }
    public Client() {
    }
    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column
    private String name;
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' + factures+'\''+promotions+ '}';
    }


}