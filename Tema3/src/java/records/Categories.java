package records;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author roungureanu
 */
public class Categories {
    private Map<String, String> categories;

    public Categories() {
        this.categories = new TreeMap<>();
        
        categories.put("none", "None");
        categories.put("first", "First Category");
        categories.put("second", "Second Category");
        categories.put("third", "Third Category");
    }

    public Categories(Categories categoriesOld) {
        this.categories = new TreeMap<>(categoriesOld.categories);
    }

    public Map<String, String> getCategories() {
        return categories;
    }
       
}
