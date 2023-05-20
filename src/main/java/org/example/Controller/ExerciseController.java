package org.example.Controller;

import org.example.main.Exercise;
import org.example.main.User;
import org.example.service.ExerciseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(urlPatterns = {"/table-exercise"})
public class ExerciseController extends HttpServlet {
    private ExerciseService exerciseService = ExerciseService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Exercise> listEx = exerciseService.getDailyExercises(user.getId());
        request.setAttribute("listEx", listEx);
        request.getRequestDispatcher("exercise-table.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
