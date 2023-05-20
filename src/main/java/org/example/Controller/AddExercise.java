package org.example.Controller;

import org.example.main.Exercise;
import org.example.main.User;
import org.example.service.ExerciseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "add-exercise", value = "/add-exercise")
public class AddExercise extends HttpServlet {
    private ExerciseService exerciseService = ExerciseService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Exercise exercise = new Exercise();
        exercise.setUserId(user.getId());
        exercise.setName(request.getParameter("exercise-name"));
        exercise.setTotalCalorie(Integer.parseInt(request.getParameter("total-calorie")));
        exercise.setDuration(Integer.parseInt(request.getParameter("duration")));
        exercise.setExDate(request.getParameter("ex-date"));
        exerciseService.addExercise(exercise);
        response.sendRedirect("table-exercise");
    }
}
