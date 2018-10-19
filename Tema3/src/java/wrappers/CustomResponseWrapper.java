/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author roungureanu
 */
public class CustomResponseWrapper extends HttpServletResponseWrapper{
    private CharArrayWriter output;

    public CustomResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new CharArrayWriter();
    }
    
    
    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(output); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return output.toString();
    }
    
    
}
