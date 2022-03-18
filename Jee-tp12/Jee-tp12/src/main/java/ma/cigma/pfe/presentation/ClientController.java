package ma.cigma.pfe.presentation;

import ma.cigma.pfe.models.Client;
import ma.cigma.pfe.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private IClientService service;

    @PostMapping("/create")
    public Client save(@RequestBody Client clt) {
        return service.save(clt);
    }

    @PutMapping("/update")
    public Client modify(@RequestBody Client clt) {
        return service.modify(clt);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") long id) {
        service.remove(id);
    }

    @GetMapping("/{id}")
    public Client getOne(@PathVariable("id") long id) {
        return service.getOne(id);
    }
    @GetMapping("/all")
    public List<Client> getAll() {
        return service.getAll();
    }
}
