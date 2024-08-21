package mitic.todolist.controller;

import mitic.todolist.entite.Tache;
import mitic.todolist.service.TacheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/tache")
@CrossOrigin(origins = "http://localhost:8100")
public class TacheController {

    private TacheService tacheService;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }

    @PostMapping
    public ResponseEntity<Tache> saveTache(@RequestBody Tache tache) {
        try {
            if (tache.getTitle() == null || tache.getTitle().trim().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Tache savedTache = tacheService.createTache(tache);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTache);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            e.getCause();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping
    public ResponseEntity<List<Tache>> getTaches() {
        List<Tache> taches = tacheService.getTache();
        return ResponseEntity.ok(taches);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Tache>> getTachesByStatus(@RequestParam boolean completed) {
        List<Tache> taches = tacheService.getTachesByStatus(completed);
        return ResponseEntity.ok(taches);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tache> modifyProduit(@PathVariable int id, @RequestBody Tache detailsTache) {
        return tacheService.findById(id)
                .map(tache -> {
                    tache.setTitle(detailsTache.getTitle());
                    tache.setDescription(detailsTache.getDescription());
                    tache.setUpdateDay(LocalDateTime.now());
                    Tache updatedTache = tacheService.createTache(tache);
                    return ResponseEntity.ok().body(updatedTache);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/completed/{id}")
    public ResponseEntity<Tache> tacheCompleted(@PathVariable int id) {
        return tacheService.findById(id)
                .map(tache -> {
                    tache.setCompleted(true);
                    tache.setUpdateDay(LocalDateTime.now());
                    Tache updatedTache = tacheService.createTache(tache);
                    return ResponseEntity.ok().body(updatedTache);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable int id) {
       tacheService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
