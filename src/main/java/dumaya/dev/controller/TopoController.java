package dumaya.dev.controller;

import dumaya.dev.model.Topo;
import dumaya.dev.service.TopoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TopoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopoController.class);

    private TopoService topoService;

    @Autowired
    public void setTopoService(TopoService topoService) {
        this.topoService = topoService;
    }

    @RequestMapping("/")
    public String racine() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/mes-topos")
    public String add(Model model) {
        LOGGER.debug("Liste des topos de l'utilisateur");

        /** Liste des topos de l'utilisateur */
        List<Topo> topos= topoService.listeTopos();

        model.addAttribute("topos", topos);

        /** Formulaire de création d'un topo */
        LOGGER.debug("Init formulaire topo");
        Topo topo = new Topo();
        model.addAttribute("topo", topo);

        return "mes-topos";
    }

    @PostMapping(value = "/mes-topos/save")
    public String proposerTopoSubmit(@RequestParam String nom, @RequestParam(required=false) String description, @RequestParam String lieu,@RequestParam(required = false) String auteur, @RequestParam(required = false) Boolean dispoPret,RedirectAttributes ra) {
        LOGGER.debug("submit du formulaire topo");
        if (dispoPret == null){
            dispoPret=false;
        }
        topoService.save(nom,description,lieu,auteur, dispoPret);
        ra.addFlashAttribute("successFlash", "Topo enregistré.");
        return "redirect:/mes-topos";
    }

    @PostMapping(value = "/mes-topos/validerModif")
    public String validerModifListe(@RequestParam long idTopo, RedirectAttributes ra) {
        LOGGER.debug("validation des modif de la liste");
        long idN =5;
        topoService.changeDispo(idTopo);
        ra.addFlashAttribute("successFlash", "Topo enregistré.");
        return "redirect:/mes-topos";
    }

    @GetMapping("/topos")
    public String affichelesTopos(Model model) {
        LOGGER.debug("page affiche un topo");
        List<Topo> topos= topoService.listeTopos();
        model.addAttribute("topos", topos);
        return "topos";
    }
}
