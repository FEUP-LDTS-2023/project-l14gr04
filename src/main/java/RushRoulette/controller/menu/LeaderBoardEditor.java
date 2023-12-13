package RushRoulette.controller.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeaderBoardEditor {
    private final int newScore;
    private final String newPlayerName;
    private List<Integer> scoreContainer;
    private List<String> nameContainer;

    private int linePadding = 40;

    public LeaderBoardEditor(int score,String newPlayerName) {
        this.newScore = score;
        this.newPlayerName = newPlayerName;

        this.scoreContainer = new ArrayList<>();
        this.nameContainer = new ArrayList<>();

    }

    public void modifyLeaderBoard() throws IOException {
        parseLeaderBoard();
        updateScoresAndNames();
        createNewLeaderBoard();
    }


    private void parseLeaderBoard() {
        String rootPath = new java.io.File(System.getProperty("user.dir")).getPath();
        Path leaderBoardPathFinder = Paths.get(rootPath, "src", "main", "resources", "LeaderBoard", "LeaderBoard.txt");

        String leaderBoardFilePath = leaderBoardPathFinder.toString();

        try (BufferedReader br = new BufferedReader(new FileReader(leaderBoardFilePath))) {
            List<String> lines = readLines(br);

            //parse (line for line) all 15 player scores with new score
            for (int i = 3; i < 18; i++) {

                String[] substrings = lines.get(i).split("-"); //["|| 01 ", " Player ", " 000 ||"]

                String oldScoreString = substrings[2].replaceAll("[^0-9]", "");
                int oldScore = Integer.parseInt(oldScoreString);

                scoreContainer.add(oldScore);
                nameContainer.add(substrings[1].trim());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateScoresAndNames() {
        boolean needsUpdate = false;
        int newPlayerPosition = 0;

        for( int i=0; i < scoreContainer.size(); i++){

            if(scoreContainer.get(i) < newScore) {   //can be <= to update if the new score is equal to the old,
                needsUpdate = true;
                newPlayerPosition = i;
                break;
            }
        }

        if(needsUpdate){
            nameContainer.add(newPlayerPosition,newPlayerName);
            nameContainer.remove(nameContainer.size()-1);

            scoreContainer.add(newPlayerPosition,newScore);
            scoreContainer.remove(scoreContainer.size()-1);

        }

    }

    private void createNewLeaderBoard() throws IOException {
        List<String> newLines = new ArrayList<>();
        newLines.add("======== L E A D E R B O A R D =========");
        newLines.add("||                                    ||");
        newLines.add("||   PLAYER                     SCORE ||");

        for(int i = 0; i < scoreContainer.size(); i++){
            int rank = i+1;

            int score = scoreContainer.get(i);
            String name = nameContainer.get(i);

            int remainingPadding = linePadding - ( "|| 00".length() + " - ".length() + name.length() +
                    "000".length() + "  ||".length() + 3);

            if(rank<10){

                if(score < 10){

                    String newLine = "|| 0" + rank + " - " + name + " - " + " ".repeat(remainingPadding)
                    + "00" + score + "  ||";

                    newLines.add(newLine);
                }
                else if(score < 100){

                    String newLine = "|| 0" + rank + " - " + name + " - " + " ".repeat(remainingPadding)
                            + "0" + score + "  ||";

                    newLines.add(newLine);
                }

                else {
                    String newLine = "|| 0" + rank + " - " + name + " - " + " ".repeat(remainingPadding)
                            + score + "  ||";

                    newLines.add(newLine);
                }

            }

            else{

                if(score < 10){

                    String newLine = "|| " + rank + " - " + name + " - " + " ".repeat(remainingPadding)
                            + "00" + score + "  ||";

                    newLines.add(newLine);
                }

                else if(score < 100){

                    String newLine = "|| " + rank + " - " + name + " - " + " ".repeat(remainingPadding)
                            + "0" + score + "  ||";

                    newLines.add(newLine);
                }

                else {
                    String newLine = "|| " + rank + " - " + name + " - " + " ".repeat(remainingPadding)
                            + score + "  ||";

                    newLines.add(newLine);
                }

            }



        }

        newLines.add("||                                    ||");
        newLines.add("||                                    ||");
        newLines.add("========================================");


        writeLeaderBoard(newLines);
    }


    private void writeLeaderBoard( List<String> newLines) throws IOException {
        String rootPath = new java.io.File(System.getProperty("user.dir")).getPath();
        Path leaderBoardPathFinder = Paths.get(rootPath, "src", "main", "resources", "LeaderBoard", "LeaderBoard.txt");

        String content = String.join(System.lineSeparator(), newLines);
        Files.write(leaderBoardPathFinder, content.getBytes());

    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }
}

