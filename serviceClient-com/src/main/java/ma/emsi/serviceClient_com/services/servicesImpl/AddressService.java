package ma.emsi.serviceClient_com.services.servicesImpl;
import ma.emsi.serviceClient_com.entities.Address;
import ma.emsi.serviceClient_com.entities.Client;
import ma.emsi.serviceClient_com.repositories.AddressRepository;
import ma.emsi.serviceClient_com.repositories.ClientRepository;
import ma.emsi.serviceClient_com.services.AddressServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService implements AddressServiceI {

    private final AddressRepository addressRepository;

    private final ClientRepository clientRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository, ClientRepository clientRepository) {
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Address> showClientAddress(Long clientId) {
        return addressRepository.findAllByClient(clientRepository.findById(clientId).orElseThrow(()->new RuntimeException("user not found wa cant find a address")));
    }

    @Override
    public Address addAddressToClient(Address address, Long id) {
        Client client=clientRepository.findById(id).orElseThrow(()->new RuntimeException("client with "+id+" not found"));
        if (client.getAddress().size()<2){
            return addressRepository.save(address);
        }
        throw new RuntimeException("user cant have more than two address");
    }

    @Override
    public Address updateAddress(Address addressUpdate) {
        Address address=Address.builder()
                .id(addressUpdate.getId())
                .city(addressUpdate.getCity())
                .contry(addressUpdate.getContry())
                .district(addressUpdate.getDistrict())
                .build();
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long clientId) {
        addressRepository.deleteById(clientId);
    }
}