package mitic.todolist.repository;

import mitic.todolist.entite.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TacheRepository extends JpaRepository<Tache, Integer> {

    Optional<Tache> findByTitle(String title);
    List<Tache> findByCompleted(boolean completed);
}
