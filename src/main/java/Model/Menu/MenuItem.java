package Model.Menu;

public enum MenuItem {
    Play("Play"),
    Exit("Exit");
    private final String name;

    MenuItem(String name){this.name = name;}

    @Override
    public String toString(){return name;}
}
