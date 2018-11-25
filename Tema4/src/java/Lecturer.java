/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LucianAlexandru
 */

import entities.LecturerEntity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Lecturer {
    private LecturerEntity entity = new LecturerEntity();

    public LecturerEntity getEntity() {
        return entity;
    }

    public void setEntity(LecturerEntity entity) {
        this.entity = entity;
    }
    
    
    
}
