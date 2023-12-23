package Projeto.Model.PopUpScreens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveScore {
    private final List<String> entries;
    private int score;;
    private int entryCounter = 0;

    private String nickname;
    private static List<String> nickNameKeyList = new ArrayList<String>(); //todo: tem q dar reset como o score
    private static boolean nextisAvailable = false;

    public SaveScore(int score){
        this.entries = Arrays.asList("Menu", "Next",
                "Q", "W","E","R","T","Y","U","I","O","P",
                "A","S","D","F","G","H","J","K","L",
                "Z","X","C","V","B","N","M");


        this.score = score;

    }

    public String getNickname(){
        StringBuilder stringBuilder = new StringBuilder();

        for (String str : nickNameKeyList) {
            stringBuilder.append(str);
        }

        nickname = stringBuilder.toString();
        return nickname;
    }

    public void addKey(String newkey){
        nickNameKeyList.add(newkey);
    }

    public void nextEntry(){
        entryCounter++;
        if(entryCounter >this.entries.size()-1){
            entryCounter = 0;
        }
    }

    public void skipNext(){
        entryCounter+=2;
        if(entryCounter >this.entries.size()-1){
            entryCounter = 0;
        }
    }

    public void setNextisAvailable(boolean nextisAvailable) {
        SaveScore.nextisAvailable = nextisAvailable;
    }

    public static boolean isNextisAvailable() {
        return nextisAvailable;
    }

    public void previousEntry(){
        entryCounter--;
        if(entryCounter < 0){
            entryCounter = this.entries.size()-1;
        }

    }

    public void jumpCharDistance(int distance){
        entryCounter += distance;
        if(entryCounter < 0){
            entryCounter = this.entries.size()-1;
        }

    }

    public void resetNickName(){
        nickNameKeyList = new ArrayList<String>();
    }

    public String getEntry(int e){
        return entries.get(e);
    }

    public List<String> getNickNameKeyList() {
        return nickNameKeyList;
    }

    public boolean isSelected(int e){
        return entryCounter ==e;
    }

    public int getNumberEntries(){return this.entries.size();}
    public int getScore() {
        return score;
    }
    public boolean menuSelected() {
        return isSelected(0);
    }
    public boolean nextSelected() {
        return isSelected(1);
    }
    public boolean qSelected() {
        return isSelected(2);
    }
    public boolean wSelected() {
        return isSelected(3);
    }

    public boolean eSelected() {
        return isSelected(4);
    }

    public boolean rSelected() {
        return isSelected(5);
    }

    public boolean tSelected() {
        return isSelected(6);
    }

    public boolean ySelected() {
        return isSelected(7);
    }

    public boolean uSelected() {
        return isSelected(8);
    }

    public boolean iSelected() {
        return isSelected(9);
    }

    public boolean oSelected() {
        return isSelected(10);
    }

    public boolean pSelected() {
        return isSelected(11);
    }

    public boolean aSelected() {
        return isSelected(12);
    }

    public boolean sSelected() {
        return isSelected(13);
    }

    public boolean dSelected() {
        return isSelected(14);
    }

    public boolean fSelected() {
        return isSelected(15);
    }

    public boolean gSelected() {
        return isSelected(16);
    }

    public boolean hSelected() {
        return isSelected(17);
    }

    public boolean jSelected() {
        return isSelected(18);
    }

    public boolean kSelected() {
        return isSelected(19);
    }

    public boolean lSelected() {
        return isSelected(20);
    }

    public boolean zSelected() {
        return isSelected(21);
    }

    public boolean xSelected() {
        return isSelected(22);
    }

    public boolean cSelected() {
        return isSelected(23);
    }

    public boolean vSelected() {
        return isSelected(24);
    }

    public boolean bSelected() {
        return isSelected(25);
    }

    public boolean nSelected() {
        return isSelected(26);
    }

    public boolean mSelected() {
        return isSelected(27);
    }
}
