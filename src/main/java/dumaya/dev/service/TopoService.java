package dumaya.dev.service;


import dumaya.dev.model.Topo;
import dumaya.dev.repository.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopoService {

    @Autowired
    private TopoRepository topoRepository;

    public void save(String site, String auteur,String lieuDuPret) {
        Topo topo = new Topo();
        topo.setAuteur(auteur);
        topo.setSite(site);
        topo.setLieuDuPret(lieuDuPret);
        topoRepository.save(topo);
    }
}
