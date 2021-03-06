package dumaya.dev.controller;

import dumaya.dev.model.Topo;
import dumaya.dev.repository.UserRepository;
import dumaya.dev.service.TopoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class TopoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopoController.class);

    private TopoService topoService;

    @Autowired
    public void setTopoService(TopoService topoService) {
        this.topoService = topoService;
    }

    @Autowired
    private UserRepository userRepository;

    @Value("${erreur.saisie.topo}")
    private String erreurSaisieTopo;

    @Value("${erreur.bouton.topo}")
    private String erreurBoutonTopo;

    @RequestMapping("/")
    public String racine() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/mestopos")
    @Secured("UTILISATEUR")
    public String gestionTopo(Model model, Principal principal) {
        LOGGER.debug("Liste des topos de l'utilisateur");

        /** Liste des topos de l'utilisateur */
        Long idCourant = userRepository.findByEmail(principal.getName()).getId();
        List<Topo> topos= topoService.listeMesTopos(idCourant);

        model.addAttribute("topos", topos);

        return "mestopos";
    }

    @GetMapping("/ajouttopo")
    @Secured("UTILISATEUR")
    public String ajoutTopo(Model model) {

        /* Formulaire de création d'un topo */
        LOGGER.debug("Init formulaire topo");
        Topo topo = new Topo();
        model.addAttribute("topo", topo);

        return "ajouttopo";
    }


    @PostMapping(value = "/ajouttopo")
    @Secured("UTILISATEUR")
    public String proposerTopoSubmit(Model model,@Valid @ModelAttribute("topo") Topo topo,  BindingResult result, Principal principal) {

        LOGGER.debug("submit du formulaire topo");

        if (result.hasErrors()){
            /** Garder la liste des topos de l'utilisateur */
            List<Topo> topos= topoService.listeTopos();
            model.addAttribute("topos", topos);
            model.addAttribute("erreurSaisieTopo", erreurSaisieTopo);
            return "ajouttopo";
        } else {
            topoService.enregistrer(topo, userRepository.findByEmail(principal.getName()));
            return "redirect:/mestopos";
        }
    }

    @PostMapping(value = "/mestopos/modifDispoPret")
    @Secured("UTILISATEUR")
    public String modifDispoPret(@RequestParam long idTopo, RedirectAttributes ra) {
        LOGGER.debug("Changement de la disponibilité du topo");
        topoService.changeDispo(idTopo);
        ra.addFlashAttribute("successFlash", "Dispo Topo modifiée");
        return "redirect:/mestopos";
    }

    @PostMapping(value = "/mestopos/supprimerTopo")
    @Secured("UTILISATEUR")
    public String supprimerTopo(@RequestParam long idTopo, RedirectAttributes ra) {
        LOGGER.debug("suppression d'un Topo");
        topoService.supprimerDispo(idTopo);
        ra.addFlashAttribute("successFlash", "Topo supprimé.");
        return "redirect:/mestopos";
    }

    @PostMapping(value = "/mestopos/accepterEmprunt")
    @Secured("UTILISATEUR")
    public String accepterEmprunt(@RequestParam long idTopo, RedirectAttributes ra) {
        LOGGER.debug("accepter une demande d'emprunt : passer le dispo pret à false");
        topoService.accepterEmprunt(idTopo);
        ra.addFlashAttribute("successFlash", "accepter demande d'emprunt");
        return "redirect:/mestopos";
    }

    @PostMapping(value = "/mestopos/retourEmprunt")
    @Secured("UTILISATEUR")
    public String retourEmprunt(@RequestParam long idTopo, RedirectAttributes ra) {
        LOGGER.debug("retour d'emprunt : passer le dispo pret à true et user emprunteur vide");
        topoService.retourEmprunt(idTopo);
        ra.addFlashAttribute("successFlash", "retour d'emprunt");
        return "redirect:/mestopos";
    }

    @GetMapping("/topos")
    public String affichelesTopos(Model model) {
        LOGGER.debug("page afficher les topos dispos");
        List<Topo> topos= topoService.listeTopos();
        model.addAttribute("topos", topos);
        return "topos";
    }

    @PostMapping(value = "/topos/emprunt")
    @Secured("UTILISATEUR")
    public String emprunterTopo(@RequestParam long idTopo, Principal principal, RedirectAttributes ra) {
        LOGGER.debug("bouton emprunter un Topo");
        topoService.emprunterTopo(idTopo, userRepository.findByEmail(principal.getName()));
        ra.addFlashAttribute("successFlash", "Demande d'emprunt Topo.");
        return "redirect:/topos";
    }
//gestion des exceptions TOPO

}
