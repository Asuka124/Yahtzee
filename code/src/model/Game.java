package model;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Game {
	
	private final String savePath = "src/save.txt";
	
    private List<Computer> computer;
    private Player player;
    
    public Game() {}

    public Game(int n, String name) {
        player = new Player(name, new Score());
        computer = new ArrayList<Computer>();
        for(int i = 0; i < n; i++)
            computer.add(new Computer(i, new Score()));
    }

    public void chooseType(int n) {
        player.chooseType(n, player);
        for(Computer _computer : computer) {
            _computer.start();
            _computer.fill();
        }
    }

    public boolean start() {
        return player.start();
    }

    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        try{
            File file = new File(savePath);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
            bw.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Game load() {
        Game game = new Game();
        StringBuilder buffer = new StringBuilder();
        try {
            File file = new File(savePath);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext())  
            	buffer.append(scanner.next());
            scanner.close();  
        } catch (IOException e) { 
            e.printStackTrace();
        }
        String str = buffer.toString()
        		.replace("{","")
        		.replace("}","")
        		.replace("[","")
        		.replace("]","")
        		.replaceAll("\":\"","")
        		.replaceAll("computer","");
        String [] values = str.split("player");
        game.setPlayer(loadPlayer(values[1]));
        game.setComputer(loadComputer(values[0]));
        return game;
    }

    private List<Computer> loadComputer(String string) {
        List<Computer> computerList = new ArrayList<>();
        String [] computerInfo = string.split("\"name");
        for(int i = 1; i < computerInfo.length; i++) {
            String[] computers = computerInfo[i].split(",\"");
            for(int j = 0; j < computers.length; j++) {
                computers[j] = computers[j]
                		.replace("\"","")
                		.replaceAll("upperScore:","")
                		.replaceAll("totalScore:","")
                		.replaceAll("can:","")
                		.replaceAll("scores:","")
                		.replaceAll("upperBonus:","")
                		.replaceAll("time","")
                		.replace("\n","");
            }

            Computer computer = new Computer(i-1, new Score());
            String[] can = computers[3].split(",");
            String[] scores = computers[4].split(",");
            List<Integer> getScores = new ArrayList<>();
            List<Boolean> getCan = new ArrayList<>();
            for(int j = 0; j < can.length; j++) {
                getCan.add(Boolean.valueOf(can[j]));
                getScores.add(Integer.valueOf(scores[j].replace(" ","")));
            }
            computer.setCan(getCan);
            computer.setScores(getScores);
            computer.setUpperScore(Integer.valueOf(computers[1].replace(" ","")));
            computer.setTotalScore(Integer.valueOf(computers[2].replace(" ","")));
            computer.setTime(computers[computers.length-1].replace(",",""));

            computerList.add(computer);
        }
        return computerList;
    }

    private Player loadPlayer(String string) {
        String playerInfo[] = string.split(",\"");
        List<Integer> getScores = new ArrayList<>();
        List<Boolean> getCan = new ArrayList<>();
        for(int i = 0; i < playerInfo.length; i++)
            playerInfo[i] = playerInfo[i]
            		.replaceAll("name","")
            		.replace("\"", "")
            		.replaceAll("upperScore:","")
            		.replaceAll("totalScore:","")
            		.replaceAll("can:","")
            		.replaceAll("scores:","")
            		.replaceAll("upperBonus:","")
            		.replaceAll("time","");

        Player player = new Player(playerInfo[0], new Score());
        String[] isCan = playerInfo[3].split(",");
        String[] scores = playerInfo[4].split(",");
        for(int i = 0; i < isCan.length; i++) {
            getScores.add(Integer.valueOf(scores[i].replace(" ","")));
            getCan.add(Boolean.valueOf(isCan[i]));
        }
        player.setScores(getScores);
        player.setCan(getCan);
        player.setUpperScore(Integer.valueOf(playerInfo[1].replace(" ","")));
        player.setTotalScore(Integer.valueOf(playerInfo[2].replace(" ","")));
        player.setTime(playerInfo[playerInfo.length-1]);
        
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setComputer(List<Computer> computer) {
        this.computer = computer;
    }

    public Iterable<Computer> getComputer() {
        return this.computer;
    }
}

