package ma.emsi.serviceClient_com.controllers;


import ma.emsi.serviceClient_com.entities.Address;
import ma.emsi.serviceClient_com.services.AddressServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/client/address")
public class AddressController {

    private final AddressServiceI addressServiceI;
    @Autowired
    public AddressController(AddressServiceI addressServiceI) {
        this.addressServiceI = addressServiceI;
    }

    @GetMapping("/{idCl}")
    public ResponseEntity<List<Address>> showClientAddress(@PathVariable("idCl") Long clientId) {
        return ResponseEntity.ok(addressServiceI.showClientAddress(clientId));
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Address> addAddressToClient(@RequestBody Address address,@PathVariable Long id) {
        return ResponseEntity.ok(addressServiceI.addAddressToClient(address,id));
    }

    @PostMapping("/edit")
    public Address updateAddress(@RequestBody Address updatedAddress) {
        return addressServiceI.updateAddress(updatedAddress);
    }

    @DeleteMapping("/delete/{idCl}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("idCl")Long clientId){
        addressServiceI.deleteAddress(clientId);
        return ResponseEntity.noContent().build();
    }
}