/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LucianAlexandru
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class LecturerManager {
    
    private List<Lecturer> lecturers = new ArrayList<Lecturer>();

    public LecturerManager() {}

    @PostConstruct
    public void populateList(){
//         for(int i = 1 ; i <= 3 ; i++){
//            Lecturer lecturer = new Lecturer();
//            lecturer.setName("Lecturer " + i);
//            lecturer.setUrl("url" + i);
//            lecturers.add(lecturer);
//        }
        try {
            lecturers = DatabaseUtils.retrieveLecturers();
        } catch (SQLException ex) {
            Logger.getLogger(LecturerManager.class.getName()).log(Level.SEVERE, null, ex);
            lecturers = new ArrayList<Lecturer>();
        }
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public void addLecturer(Lecturer lecturer) {
        try {
            DatabaseUtils.insertLecturer(lecturer);
        } catch (SQLException ex) {
            Logger.getLogger(LecturerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
