import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ApplicationScoped
public class SessionsCount implements Serializable {
     
    private int count;
 
    public int getCount() {
        return SessionCounterManager.getInstance().getCount();
    }
}