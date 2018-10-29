/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LucianAlexandru
 */

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LecturerManager {
    
    private List<Lecturer> lecturers = new ArrayList<Lecturer>();

    public LecturerManager() {}

    @PostConstruct
    public void populateList(){
         for(int i = 1 ; i <= 3 ; i++){
            Lecturer lecturer = new Lecturer();
            lecturer.setName("Lecturer " + i);
            lecturer.setUrl("url" + i);
            lecturers.add(lecturer);
        }
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }
    
}
