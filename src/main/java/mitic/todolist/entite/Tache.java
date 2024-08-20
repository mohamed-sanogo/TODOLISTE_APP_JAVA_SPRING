package entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tache")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    private Boolean completed = false;
    @Column(name = "create_at")
    private LocalDateTime createDay = LocalDateTime.now();
    @Column(name = "update_at")
    private LocalDateTime updateDay = LocalDateTime.now();

}
