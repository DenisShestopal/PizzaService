package web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController // adds @ResponseBody to all methods
public class PizzaRestController {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "<b>Hello from rest Controller</b>";
    }
}
