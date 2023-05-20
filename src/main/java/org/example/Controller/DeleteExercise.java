package org.example.Controller;

import org.example.service.ExerciseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delete-exercise", value = "/delete-exercise")
public class DeleteExercise extends HttpServlet {
    private ExerciseService exerciseService = ExerciseService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("exId");
        exerciseService.deleteExercise(id);
        response.sendRedirect("table-exercise");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
