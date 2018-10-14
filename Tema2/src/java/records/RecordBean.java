package records;

/**
 *
 * @author LucianAlexandru
 */
public class RecordBean {
    
    String category;
    String key;
    String value;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Category=" + category + ", key=" + key + ", value=" + value;
    }
    
}
