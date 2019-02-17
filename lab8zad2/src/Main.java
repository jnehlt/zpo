public class Main {
    public static void main(String[] args) {
        Pola p = new Pola();
        p.setChr('a');
        p.setDou(123.123);
        p.setInn(123);
        p.setStr("oOo");

        Pola a = new Pola();
        a.setChr('a');
        a.setDou(123.123);
        a.setInn(123);
        a.setStr("oOo");

        Pola b = new Pola();
        b.setChr('b');
        b.setDou(123.123);
        b.setInn(123);
        b.setStr("oOo");

        Pola c = new Pola();
        c.setChr('a');
        c.setDou(124.124);
        c.setInn(123);
        c.setStr("oOo");

        Pola d = new Pola();
        d.setChr('a');
        d.setDou(123.123);
        d.setInn(124);
        d.setStr("oOo");

        Pola e = new Pola();
        e.setChr('a');
        e.setDou(123.123);
        e.setInn(124);
        e.setStr("OoO");

        System.out.println(p.equals(a));
        System.out.println(p.equals(b));
        System.out.println(p.equals(c));
        System.out.println(p.equals(d));
        System.out.println(p.equals(e));
    }
}
