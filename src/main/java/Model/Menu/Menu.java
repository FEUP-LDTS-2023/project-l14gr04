package Model.Menu;


import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int Entry=0;

    public Menu(){
        this.entries= Arrays.asList("Play", "Exit");
    }

    public void nextEntry(){
        Entry++;
        if(Entry>this.entries.size()-1){
            Entry =0;
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
    public boolean playSelected(){
        return isSelected(0);
    }
    public boolean exitSelected(){
        return isSelected(1);
    }
    public int getNumberEntries(){return this.entries.size();}
}
