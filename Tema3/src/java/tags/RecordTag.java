/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author LucianAlexandru
 */
public class RecordTag extends SimpleTagSupport {

    private String key;
    private String value;
    private String category;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        // Create dynamic content
        JspWriter out = getJspContext().getOut();
//        out.print("Test tag: " + key + ", " + value + ", " + category + "<br>");
        out.print("<tr><td>" + key + "</td><td>" + value + "</td><td>"+ category + "</td></tr>");
    }
    
}
