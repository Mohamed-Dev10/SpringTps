
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

        @GetMapping(value = {"/", "/clients"})
        public String getAll(Model model,@ModelAttribute("client") Client c) {
                List clients = restTemplate.getForObject(
                        apiUrl+"/client/all",
                        List.class);
                model.addAttribute("clients",clients);
                model.addAttribute("client",c==null ? new Client():c);
                return "index-client";
        }


        @GetMapping("/show-client/{id}")
        public String show(RedirectAttributes model , @PathVariable long id){
                Client inc = restTemplate.getForObject(apiUrl+"/client/"+id,Client.class);
                model.addFlashAttribute("client", inc);
                return "redirect:/clients";
        }

        @PostMapping(value = "/add-client")
        public String addClient(Model model,
                                @ModelAttribute("client") Client
                                        client) {
                restTemplate.postForObject(
                        apiUrl+"/client/create",
                        client,
                        Client.class);
                return "redirect:/clients";
        }
        @GetMapping(value = {"/delete-client/{id}"})
        public String deleteClientById(
                Model model, @PathVariable long id) {
                restTemplate.delete(apiUrl+"/client/"+id);
                return "redirect:/clients";
        }

}
