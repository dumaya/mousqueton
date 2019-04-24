package dumaya.dev.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Topo extends AbstractModel<Long> {

    @Column(nullable = false, length = 40)
    private String site;

    @Column(nullable = false, length = 40)
    private String auteur;

    @Column(nullable = false, length = 40)
    private String lieuDuPret;

    @Column(name = "dateMaj", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date dateMaj;

}
