package ma.emsi.serviceClient_com.controllers;

import jakarta.validation.Valid;

import ma.emsi.serviceClient_com.dtos.ClientDto;
import ma.emsi.serviceClient_com.entities.Client;
import ma.emsi.serviceClient_com.services.ClientServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/client")
public class ClientController {

    private final ClientServiceI clientServiceI;

    @Autowired
    public ClientController(ClientServiceI clientServiceI) {
        this.clientServiceI = clientServiceI;
    }

    @GetMapping("/companies/{idComp}")
    public ResponseEntity<List<Client>> findAllCompanyClients(@PathVariable("idComp") Long companyId) {
        List<Client> clients = clientServiceI.findAllCCompanyClients(companyId);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/commercials/{idComp}")
    public ResponseEntity<List<Client>> findAllCommercialClients(@PathVariable("idComp") Long commercialId) {
        List<Client> clients = clientServiceI.findAllCommercialClients(commercialId);
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/{IdComm}")
    public ResponseEntity<Client> addClient(
            @RequestBody @Valid ClientDto clientDto,
            @PathVariable("IdComm") Long commercialId
            ) {
        Client savedClient = clientServiceI.addClient(clientDto, commercialId);
        return ResponseEntity.ok(savedClient);
    }

    @DeleteMapping("/{idCl}")
    public ResponseEntity<Void> deleteClient(@PathVariable("idCl") Long clientId) {
        clientServiceI.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idCl}")
    public ResponseEntity<Client> updateClient(
            @PathVariable("idCl") Long id,
            @RequestBody @Valid ClientDto clientUpdate) {
        Client updatedClient = clientServiceI.updateClient(id, clientUpdate);
        return ResponseEntity.ok(updatedClient);
    }
}
