/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author roungureanu
 */
public class Categories {
    private Map<String, String> categories;

    public Categories() {
        this.categories = new HashMap<>();
        
        categories.put("first", "First Category");
        categories.put("second", "Second Category");
        categories.put("third", "Third Category");
    }

    public Categories(Categories categoriesOld) {
        this.categories = new HashMap<>(categoriesOld.categories);
    }

    public Map<String, String> getCategories() {
        return categories;
    }
       
}
