package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Combination {
    
    private static final int WIDTH = 4;

    protected List<Color> colors;
    
    public Combination (){
        this.colors = new ArrayList<Color>();
    }

    public Combination (String ordinals){
        this.colors = new ArrayList<Color>();
        for (int i = 0 ; i < Combination.WIDTH ; i++) {
            this.colors.add(Color.values()[Integer.parseInt(String.valueOf(ordinals.charAt(i)))]);
        }
    }

    public static int getWidth() {
        return Combination.WIDTH;
    }

    @Override
    public String toString() {
        String retval = "";
        for (Color color : this.colors) {
            retval += color.ordinal();
        }
        return retval;
    }
}