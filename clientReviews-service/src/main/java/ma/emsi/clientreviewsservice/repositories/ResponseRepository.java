package ma.emsi.clientreviewsservice.repositories;

import ma.emsi.clientreviewsservice.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response,Long> {
    List<Response> findAllByClientId(Long saleId);

}
