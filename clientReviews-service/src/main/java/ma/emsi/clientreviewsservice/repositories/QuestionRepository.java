package ma.emsi.clientreviewsservice.repositories;


import ma.emsi.clientreviewsservice.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
}
