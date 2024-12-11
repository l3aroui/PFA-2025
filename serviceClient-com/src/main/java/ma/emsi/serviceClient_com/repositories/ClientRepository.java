package ma.emsi.serviceClient_com.repositories;

import ma.emsi.serviceClient_com.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    List<Client> findByCommercialId(Long commercialId);
    List<Client> findByCompanyId(Long companyId);
}