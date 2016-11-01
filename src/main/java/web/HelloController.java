package web;

import domain.Pizza;
import domain.enums.PizzaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.PizzaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller("/hello")
public class HelloController implements  MyController {

    @Autowired
    private PizzaService pizzaService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<br>Hello from servlet!</b>");
            pizzaService.getById(1L);
        }
    }
}
