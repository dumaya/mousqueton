package dumaya.dev.controller;

import dumaya.dev.model.Topo;
import dumaya.dev.service.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TopoController {

    private TopoService topoService;

    @Autowired
    public void setTopoService(TopoService topoService) {
        this.topoService = topoService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/proposer-topo")
    public String add(Model model) {

        model.addAttribute("customer", new Topo());
        return "/proposer-topo";
    }

    @RequestMapping(value = "/proposer-topo/save", method = RequestMethod.POST)
    public String save(Topo topo, final RedirectAttributes ra) {

        Topo save = topoService.save(topo);
        ra.addFlashAttribute("successFlash", "Topo accepté, mis dans la liste des prêts");
        return "redirect:/proposer-topo";

    }
}
