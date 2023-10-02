package biblioteca;

import java.util.*;
import java.text.*;

public class HojeBean
{
    String str = null;
    
    public HojeBean() {
        DateFormat df = DateFormat.getDateInstance();
        //DateFormat df = DateFormat.getDateTimeInstance();
        str = df.format(new Date());
    }
    
    public String getDataAtual() {
        return str;
    }
}
