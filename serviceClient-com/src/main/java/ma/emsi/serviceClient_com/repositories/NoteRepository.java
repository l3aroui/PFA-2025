package ma.emsi.serviceClient_com.repositories;

import ma.emsi.serviceClient_com.entities.Client;
import ma.emsi.serviceClient_com.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByClient(Client client);
}