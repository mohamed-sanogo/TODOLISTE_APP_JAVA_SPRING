package mitic.todolist.repository;

import mitic.todolist.entite.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Integer> {
}
