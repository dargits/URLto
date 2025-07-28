package app.urlto.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import app.urlto.webcontants.Webcontants;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping(Webcontants.WEB_ROUTER)
public class WebControler {
    @GetMapping("")
    public String getIndex() {
        return "index.html";
    }

    @GetMapping("/auth/login")
    public String login() {
        return "auth/login.html";
    }

    @GetMapping("/auth/register")
    public String register() {
        return "auth/register.html";
    }

}
