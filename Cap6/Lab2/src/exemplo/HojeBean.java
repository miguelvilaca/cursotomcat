package exemplo;

import java.util.*;
import java.text.*;

public class HojeBean
{
    String str = null;
    
    public HojeBean() {
        DateFormat df = DateFormat.getDateInstance();
        str = df.format(new Date());
    }
    
    public String getDiaMesAno() {
        return str;
    }
}
