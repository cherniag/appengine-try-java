package myapp;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Gennadii Cherniaiev
 * Date: 7/23/2015
 */
public class BatchServlet extends HttpServlet {

    BatchService batchService = new BatchService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();

        String id = req.getParameter("id");
        resp.setContentType("application/json");
        if (id == null) {
            try {
                List<Batch> all = batchService.findAll();
                resp.getWriter().println(gson.toJson(all));
            } catch (EntityNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Batch one = batchService.findOne(Long.valueOf(id));
                resp.getWriter().println(gson.toJson(one));
            } catch (EntityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String name = req.getParameter("name");
        String generateCodesCount = req.getParameter("generateCodesCount");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String owner = req.getParameter("owner");


        try {
            batchService.createBatch(name, Integer.valueOf(generateCodesCount), dateFormat.parse(startDate), dateFormat.parse(endDate), owner);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
