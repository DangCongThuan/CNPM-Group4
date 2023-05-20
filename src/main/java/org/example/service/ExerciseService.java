package org.example.service;

import org.example.db.ConnectMysqlExample;
import org.example.main.Exercise;
import org.example.main.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExerciseService {
    private static ExerciseService instance;
    public static ExerciseService getInstance() {
        if (instance == null) {
            instance = new ExerciseService();
        }
        return instance;
    }

    public void addExercise(Exercise exercise) {
        try {
            Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO exercises (user_id, exercise_name, calo, duration, ex_date) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, exercise.getUserId());
            ps.setString(2, exercise.getName());
            ps.setString(3, String.valueOf(exercise.getTotalCalorie()));
            ps.setString(4, String.valueOf(exercise.getDuration()));
            ps.setString(5, String.valueOf(exercise.getExDate()));

            ps.executeUpdate();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void editExercise(Exercise exercise) {
        try {
            Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
            PreparedStatement ps = conn.prepareStatement(
                    "update exercises set exercise_name = ?, calo = ?, duration = ?, ex_date = ? where exercise_id = ?");
            ps.setString(1, exercise.getName());
            ps.setString(2, String.valueOf(exercise.getTotalCalorie()));
            ps.setString(3, String.valueOf(exercise.getDuration()));
            ps.setString(4, String.valueOf(exercise.getExDate()));
            ps.setString(5, exercise.getId());

            ps.executeUpdate();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Exercise> getDailyExercises(String userId) {
        List<Exercise> exerciseList = new ArrayList<>();
        try {
            Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM exercises WHERE DATE(ex_date) = CURDATE() and user_id = ?");
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Exercise exercise = new Exercise();
                exercise.setId(rs.getString(1));
                exercise.setUserId(rs.getString(2));
                exercise.setName(rs.getString(3));
                exercise.setTotalCalorie(rs.getInt(4));
                exercise.setDuration(rs.getInt(5));
                exercise.setExDate(rs.getString(6));
                exerciseList.add(exercise);
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return exerciseList;
    }

    public Exercise getExerciseById(String id) {
        {
            try {
                Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT * from exercises WHERE exercise_id = ?");
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Exercise exercise = new Exercise();
                    exercise.setId(rs.getString(1));
                    exercise.setName(rs.getString(3));
                    exercise.setTotalCalorie(rs.getInt(4));
                    exercise.setDuration(rs.getInt(5));
                    exercise.setExDate(rs.getString(6));
                    return exercise;
                }
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        return null;
    }



    public void deleteExercise(String exId) {
        try {
            Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
            PreparedStatement ps = conn.prepareStatement(
                    "Delete from exercises where exercise_id = ?");
            ps.setString(1, exId);
            ps.executeUpdate();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
