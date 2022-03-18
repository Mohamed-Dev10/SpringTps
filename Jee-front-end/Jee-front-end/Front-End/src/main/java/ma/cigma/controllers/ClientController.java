package ma.cigma.controllers;
import ma.cigma.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class ClientController {
    @Value("${api.url}")
    private String apiUrl;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = {"/", "/client"})
    public String home(Model model) {
        List<Client> client = restTemplate.getForObject(apiUrl+"/client/all", List.class);
        model.addAttribute("clients",client);
        model.addAttribute("client",new Client());
        System.out.println(client);
        return "index-client";

    }
    @GetMapping(value = {"/delete-client/{id}"})
    public String deleteClientById(
            Model model, @PathVariable long id) {
        restTemplate.delete(apiUrl+"/client/remove/"+id);
        return "redirect:/client";
    }
    @PostMapping(value = "/add-client")
    public String addClient(Model model,
                            @ModelAttribute("client") Client
                                    client) {
        restTemplate.postForObject(
                apiUrl+"/client/create/",
                client,
                Client.class);
        return "redirect:/client";
    }
    @GetMapping("/show-client/{id}")
    public String show(RedirectAttributes ra, @PathVariable long id) {
        Client client = restTemplate.getForObject(apiUrl+"/client/"+id, Client.class);
        ra.addFlashAttribute("client",client);
        return "edit";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Client client) {
        //save employee to database
        client.save(client);
        return "redirect:/";
    }

}
