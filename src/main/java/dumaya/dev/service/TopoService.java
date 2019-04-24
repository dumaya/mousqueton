package dumaya.dev.service;

import dumaya.dev.model.Topo;
import dumaya.dev.repository.MousquetonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TopoService extends AbstractService<Topo, Long> {

    @Autowired
    private MousquetonRepository mousquetonRepository;

    @Override
    protected JpaRepository<Topo, Long> getRepository() {
        return mousquetonRepository;
    }

}
