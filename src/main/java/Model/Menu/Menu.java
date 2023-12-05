package Model.Menu;

public class Menu {
    private MenuItem selected;
    private boolean choosed;
    public Menu(){
        selected=MenuItem.Play;
        choosed = false;
    }

    public void selectNext(){
        if(!choosed){
            switch(selected){
                case Play -> selected=MenuItem.Exit;
            }
        }
    }
    public void selectPrevious(){
        if (!choosed){
            switch(selected){
                case Play, Exit-> selected = MenuItem.Play;
            }
        }
    }

    public MenuItem getSelected() {
        return selected;
    }
    public void choose(){this.choosed=true;}
    public boolean inChoice(){return choosed;}
}
