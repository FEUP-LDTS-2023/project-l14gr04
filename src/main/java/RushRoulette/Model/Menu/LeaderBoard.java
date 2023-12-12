package RushRoulette.Model.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeaderBoard {
    private final String MenuOption;
    private final List<String> entries;
    public LeaderBoard(){
        this.entries = new ArrayList<>();
        readLeaderBoardFile();
        this.MenuOption = "Menu";

    }

    public String getMenuOption() {
        return MenuOption;
    }

    public List<String> getEntries() {
        return entries;
    }

    public void readLeaderBoardFile() {
        String rootPath = new java.io.File(System.getProperty("user.dir")).getPath();
        Path leaderBoardPathFinder = Paths.get(rootPath, "src", "main", "resources", "LeaderBoard", "LeaderBoard.txt");

        String leaderBoardFilePath = leaderBoardPathFinder.toString();

        try (BufferedReader br = new BufferedReader(new FileReader(leaderBoardFilePath))) {
            List<String> lines = readLines(br);

            entries.addAll(lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

}

