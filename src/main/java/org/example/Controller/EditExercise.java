package org.example.Controller;

import org.example.main.Exercise;
import org.example.main.User;
import org.example.service.ExerciseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "edit-exercise", value = "/edit-exercise")
public class EditExercise extends HttpServlet {
    private ExerciseService exerciseService = ExerciseService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("exId");
        Exercise exercise = exerciseService.getExerciseById(id);
        request.setAttribute("ex", exercise);
        request.getRequestDispatcher("edit-exercise.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Exercise exercise = new Exercise();
        exercise.setId(request.getParameter("idEx"));
        exercise.setName(request.getParameter("exercise-name"));
        exercise.setTotalCalorie(Integer.parseInt(request.getParameter("total-calorie")));
        exercise.setDuration(Integer.parseInt(request.getParameter("duration")));
        exercise.setExDate(request.getParameter("ex-date"));
        exerciseService.editExercise(exercise);
        response.sendRedirect("table-exercise");
    }
}
