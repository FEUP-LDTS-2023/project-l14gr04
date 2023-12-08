package RushRoulette.Model.PopUpScreens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final List<String> entries;
    private int Entry = 0;

    public GameOver(){this.entries = Arrays.asList("Retry", "Menu");}

    public void nextEntry(){
        Entry++;
        if(Entry>this.entries.size()-1){
            Entry = 0;
        }
    }

    public void previousEntry(){
        Entry--;
        if(Entry<0){
            Entry = this.entries.size()-1;
        }

    }

    public String getEntry(int e){
        return entries.get(e);
    }
    public boolean isSelected(int e){
        return Entry==e;
    }
    public boolean tryAgainSelected() {
        return isSelected(0);
    }
    public boolean menuSelected() {
        return isSelected(1);
    }
    public int getNumberEntries(){return this.entries.size();}

}
