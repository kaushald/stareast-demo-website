package com.kaushaldalvi.javamemdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class HomeController {

    // Define the logger object for this class
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/")
    public String loadHomePage(HttpSession session, Model model) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        final byte[] leaky = new byte[1024 * 1024 * 100];
        session.setAttribute("uid", uid);
        model.addAttribute("uid", uid);
        try {
            long time = (long) (Math.random() * 1000);
            Thread.sleep(time);
            log.info("" + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "se";
    }

}
