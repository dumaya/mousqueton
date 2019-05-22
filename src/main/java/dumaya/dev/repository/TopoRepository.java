package dumaya.dev.repository;

import dumaya.dev.model.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Long> {


    Topo findById(long id);

    List<Topo> findAllByDispoPretTrueAndUserEmprunteurIsNull();

    Topo findByIdAndDispoPretTrueAndUserEmprunteurIsNull(long id);

    Topo findByIdAndUserEmprunteurIsNull(long id);

    List<Topo> findAllByUserProprietaire_Id(Long idCourant);

    Topo findByIdAndUserEmprunteurIsNotNull(long id);
}
