package ma.emsi.serviceClient_com.services.servicesImpl;

import ma.emsi.serviceClient_com.dtos.ClientDto;
import ma.emsi.serviceClient_com.entities.Client;
import ma.emsi.serviceClient_com.repositories.ClientRepository;
import ma.emsi.serviceClient_com.services.ClientServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientServiceI {
    private final ClientRepository clientRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> findAllCCompanyClients(Long companyId) {
        return clientRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Client> findAllCommercialClients(Long commercialId) {
        return clientRepository.findByCommercialId(commercialId);
    }

    @Override
    public Client addClient(ClientDto clientDto, Long commercialId, Long companyId){
        Client client=new Client();
        client.setClientType(clientDto.getClientType());
        client.setEmail(clientDto.getEmail());
        client.setCategoryType(clientDto.getCategoryType());
        client.setLastname(clientDto.getLastname());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setFirstname(clientDto.getFirstname());
        client.setCompanyId(companyId);
        client.setCommercialId(commercialId);
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public Client updateClient(Long id, ClientDto updateClient) {
        Client client=Client.builder()
                .firstname(updateClient.getFirstname())
                .lastname(updateClient.getLastname())
                .phoneNumber(updateClient.getPhoneNumber())
                .categoryType(updateClient.getCategoryType())
                .clientType(updateClient.getClientType())
                .commercialId(updateClient.getCommercialId())
                .email(updateClient.getEmail())
                .build();
        return clientRepository.save(client);
    }
}
