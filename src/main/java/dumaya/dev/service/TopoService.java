package dumaya.dev.service;


import dumaya.dev.model.Topo;
import dumaya.dev.model.User;
import dumaya.dev.repository.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopoService {

    @Autowired
    private TopoRepository topoRepository;

    /**
     * Enregistrement du formulaire de création de Topo. Seul le nom, le lieu et l'info dispoPret sont obligatoires
     * @param topo un objet de type topo à enregistrer
     * @param user du user courant
     */
    public void enregistrer(Topo topo, User user) {
        topo.setUserProprietaire(user);
        topoRepository.save(topo);
    }

    /**
     * @return liste de tous les topos en base
     */
    public List<Topo> listeTopos() {
        return topoRepository.findAll();
    }

    /**
     * @return liste de tous les topos de l'utilisateur courant
     * @param idCourant
     */
    public List<Topo> listeMesTopos(Long idCourant)
    {
         return topoRepository.findAllByUserProprietaire_Id(idCourant);
    }

    /**
     * @param id Changer la dispo d'un topo par son id
     */

    public void changeDispo(long id) {
        Topo topo = topoRepository.findById(id);
        if (topo.isDispoPret()){
            topo.setDispoPret(false);
        } else {
            topo.setDispoPret(true);
        }
        topoRepository.save(topo);
    }

    /**
     * @param id Supprimer un topo par son id
     */
    public void supprimerDispo(long id) {
        Topo topo = topoRepository.findById(id);
        topoRepository.delete(topo);
    }

}
