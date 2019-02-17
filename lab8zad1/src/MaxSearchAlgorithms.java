import java.util.ArrayList;

public class MaxSearchAlgorithms {

    ArrayList<Integer> maxLtoR(int [] tab) {
        ArrayList<Integer> ret = new ArrayList<>();

        ret.add(tab[0]);
        for(int i : tab) {
            if(i > ret.get(ret.size()-1)) {
                ret.add(i);
            }
        }

        return ret;
    }

    ArrayList<Integer> maxRtoL(int [] tab) {
        ArrayList<Integer> ret = new ArrayList<>();

        ret.add(tab[tab.length-1]);
        for(int i = tab.length-1; i >= 0; i--) {
            if(tab[i] > ret.get(ret.size()-1)) {
                ret.add(tab[i]);
            }
        }

        return ret;
    }

    ArrayList<Integer> maxMesh(int [] tab) {
        ArrayList<Integer> ret = new ArrayList<>();

        ret.add(tab[0]);
        for(int i = 2; i < tab.length; i+=2) {
            if(tab[i] > ret.get(ret.size()-1)) {
                ret.add(tab[i]);
            }
        }
        for(int i = 1; i < tab.length; i+=2) {
            if(tab[i] > ret.get(ret.size()-1)) {
                ret.add(tab[i]);
            }
        }

        return ret;
    }

    public void print() {
        System.out.println("I have nothing to say.");
    }
}
