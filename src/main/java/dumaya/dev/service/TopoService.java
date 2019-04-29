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

    public void save(String nom, String description, String lieu, String auteur, boolean dispoPret) {
        Topo topo = new Topo();
        topo.setAuteur(auteur);
        topo.setNom(nom);
        topo.setDescription(description);
        topo.setLieu(lieu);
        topo.setDispoPret(dispoPret);
        topoRepository.save(topo);
    }

    public List<Topo> listeTopos() {
        return topoRepository.findAll();
    }
}
