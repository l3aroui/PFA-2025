package ma.emsi.serviceClient_com.services;



import ma.emsi.serviceClient_com.dtos.ClientDto;
import ma.emsi.serviceClient_com.entities.Client;

import java.util.List;

public interface ClientServiceI {
    List<Client> findAllCCompanyClients(Long companyId);
    List<Client> findAllCommercialClients(Long commercialId);
    Client addClient(ClientDto clientDto, Long commercialId);
    void deleteClient(Long clientId);
    Client updateClient(Long id, ClientDto clientUpdate);
}
