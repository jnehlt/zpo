import java.lang.reflect.Field;

public class Pola {
    private String str;
    private char chr;
    private int inn;

    @IgnoreEquals
    private Double dou;


    public void setStr(String str) { this.str = str; }

    public void setChr(char chr) { this.chr = chr; }

    public void setInn(int inn) { this.inn = inn; }

    public void setDou(Double dou) { this.dou = dou; }

    public String getStr() { return str; }

    public char getChr() { return chr; }

    public int getInn() { return inn; }

    public Double getDou() { return dou; }

//    @Override
//    public boolean equals(Object o) {
//        if( ! (o instanceof Pola)) { return false; }
//        if(this == o) { return true; }
//
//        Pola p = (Pola)o;
//        if(p.chr != chr) { return false; }
//        // if(p.dou.equals(dou)) { return false; } <- ignore
//        if(p.inn != inn) { return false; }
//        if(p.str.equals(str)) { return false; }
//
//        return true;
//    }

    @Override
    public boolean equals(Object o) {
        Class th = this.getClass();
        Class in = o.getClass();
        if( ! th.equals(in)) { return false; }

        Field fields[] = th.getDeclaredFields();

        for(Field f : fields) {
            if(f.isAnnotationPresent(IgnoreEquals.class)) { continue; }
            try {
                if( ! f.get(o).equals(f.get(this))) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                e.getMessage();
            }
        }

        return true;
    }
}
