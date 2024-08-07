
package presentacion;

import java.util.ArrayList;
import java.util.List;

public class ModeloPrincipal {
    
    
    private String msg="";
    private List lis = new ArrayList();
    private Object[] fil={"","","","",""};
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object[] getFil() {
        return fil;
    }

    public void setFil(Object[] fil) {
        this.fil = fil;
    }

    public List getLis() {
        return lis;
    }

    public void setLis(List lis) {
        this.lis = lis;
    }
    
    
}
