/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author LucianAlexandru
 */
@ManagedBean
@Entity
public class StudentEntity extends UserEntity implements Serializable {
    
    private int year;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<PreferenceEntity> preferences;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public List<PreferenceEntity> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<PreferenceEntity> preferences) {
        this.preferences = preferences;
    }
    
    public String getOrderedPreferences() {
        StringBuilder sb = new StringBuilder();
        List<PreferenceEntity> orderedPreferences = new ArrayList<PreferenceEntity>(preferences);
        
        Collections.sort(orderedPreferences, new Comparator<PreferenceEntity>() {
            @Override
            public int compare(PreferenceEntity o1, PreferenceEntity o2) {
                return o1.getOrd() - o2.getOrd();
            }
        });
        
        for (PreferenceEntity preference : orderedPreferences) {
            sb.append(preference.getCourse().getName());
            if (preference != orderedPreferences.get(orderedPreferences.size() - 1))
                sb.append(", ");
        }
        return sb.toString();
    }
}
