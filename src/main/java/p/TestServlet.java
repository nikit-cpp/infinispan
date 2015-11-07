package p;

/**
 * Created by nik on 08.11.15.
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 3200037917839533696L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doIt(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doIt(req, resp);
    }

    protected void doIt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Config config = new Config();
            config.printObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}