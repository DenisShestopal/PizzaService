package web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.PizzaService;

//@RestController // adds @ResponseBody to all methods
@Controller
public class PizzaAppController {

    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

//    @RequestMapping(value = "/pizzas")
//    public String pizzas(){
//        return "pizzas";
//    }

    @RequestMapping("/pizzas")
    public ModelAndView pizzas(ModelAndView mv){
//        ModelAndView mv = new ModelAndView();
        mv.setViewName("pizzas");
        mv.setStatus(HttpStatus.OK);
        mv.addObject("pizzas", pizzaService.getPizzasList());
        return mv;
    }
}
