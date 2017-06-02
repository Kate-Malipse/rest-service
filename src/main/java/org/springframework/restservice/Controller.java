package org.springframework.restservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kate on 02.06.2017.
 */
@RestController
public class Controller {

    private static final String template = "Your request: ";

    @RequestMapping("/tagbody")
    public String output(@RequestParam(value = "name", required = false, defaultValue = "null") String name) {
        Output result = new Output(name);
        String out = template + "<br/>" + "<br/>" + result.getContent(name);
        return out;
    }
}
