package br.com.invitedlist.controller;

import br.com.invitedlist.model.Invited;
import br.com.invitedlist.service.InvitedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvitedController {

    @Autowired
    private InvitedService service;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/invited-list")
    public String findAllInviteds(Model model) {
        Iterable<Invited> invitedList = service.findAll();
        model.addAttribute("invitedList", invitedList);

        return "invitedList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("name") String name, @RequestParam("email") String email,
                       @RequestParam("phone") String phone) {

        Invited newInvited = new Invited(name, email, phone);
        service.save(newInvited);
        return "redirect:invited-list";
    }

}
