package dumaya.dev.service;


import dumaya.dev.model.Topo;
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
     * @param nom nom du topo
     * @param description description du site d'escalade
     * @param lieu lieu de grimpe
     * @param auteur auteur
     * @param dispoPret true quand le topo est dispo pour être prété
     */
    public void save(String nom, String description, String lieu, String auteur, boolean dispoPret) {
        Topo topo = new Topo();
        topo.setAuteur(auteur);
        topo.setNom(nom);
        topo.setDescription(description);
        topo.setLieu(lieu);
        topo.setDispoPret(dispoPret);
        topoRepository.save(topo);
    }

    /**
     * @return liste de tous les topos
     */
    public List<Topo> listeTopos() {
        return topoRepository.findAll();
    }

    /**
     * @param topos Liste des topos modifiée, à
     */
    public void saveList(List<Topo> topos) {
        topoRepository.save(topos);
    }

    public void changeDispo(long id) {
        Topo topo = topoRepository.findById(id);
        if (topo.isDispoPret()){
            topo.setDispoPret(false);
        } else {
            topo.setDispoPret(true);
        }
        topoRepository.save(topo);
    }
}
