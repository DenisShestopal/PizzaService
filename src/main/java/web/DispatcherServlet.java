package web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DispatcherServlet extends HttpServlet {

    private String message;
    private ConfigurableApplicationContext webContext;
    private ConfigurableApplicationContext[] applicationContexts;

    @Override
    public void init() throws ServletException {
        String contextConfigLocation = getServletContext().getInitParameter
                ("contextConfigLocation");
        String[] contexts = contextConfigLocation.split(" ");
        applicationContexts = new ConfigurableApplicationContext[contexts
                .length];
        for (int i = 0; i < applicationContexts.length; i++) {
            ConfigurableApplicationContext context;
            if (i == 0) {
                context = new ClassPathXmlApplicationContext(contexts[i]);
            }
            else {
                context = new ClassPathXmlApplicationContext(
                        new String[]{contexts[i]}, applicationContexts[i - 1]);
            }
            applicationContexts[i] = context;

        }

        String webContextConfigLocation = getInitParameter("contextConfigLocation");
        webContext = new ClassPathXmlApplicationContext(
                new String[]{webContextConfigLocation},
                applicationContexts[applicationContexts.length - 1]);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getRequestURI();
        String controllerName = getControllerName(url);

//        try (PrintWriter out = response.getWriter()) {
//                out.println("<br>Hello from servlet!</b>" + controllerName);}

        MyController controller = webContext.getBean(controllerName, MyController.class);
        if (controller != null) {
            controller.handleRequest(request, response);
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    private String getControllerName(String url) {
        return url.substring(url.lastIndexOf("/"));
    }

    @Override
    public void destroy() {
        webContext.close();
        for(int i = (applicationContexts.length - 1); i>=0; i--){
            applicationContexts[i].close();
        }
    }
}