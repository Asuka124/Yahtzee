package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.rules.*;

public class Player {
	
    private String name;
    private String localtime;
    private int upperScore;
    private int totalScore;
    private Score scoreCard;
    
    private List<Boolean> can = new ArrayList<>();
    private List<Integer> scores = new ArrayList<>();
    private List<Dice> diceList = new ArrayList<>(5);
    
    private RulesFactory rulesFactory = new RulesFactory();
    private ITypeStrategy typeStrategy;
    private IUpperBonusStrategy upperBonusStrategy = new UpperBonusStrategy();
    
    private String[] type = Type.type;

    public Player(String playerName, Score card) {
        name = playerName;
        scoreCard = card;
        localtime = LocalDate.now() + "";
        for(int i = 0; i < 13; i++) {
            can.add(false);
            scores.add(0);
        }
    }

    public boolean start() {
        getDice();
        for (int i = 0; i < 5; i++)
            roll(i);
        return true;
    }

    private void getDice() {
        diceList.clear();
        for (int i = 0; i < 5; i++)
            diceList.add(new Dice());
    }

    public void roll(int index) {
    	Dice dice = diceList.get(index);
    	dice.roll();
    }

    public int countDice(Dice dice) {
    	int count = 0;
    	for(int i=0; i<diceList.size(); i++)
    		if(diceList.get(i).getValue()==dice.getValue())
    			count++;
    	return count;
    }

    public void chooseType(int n, Player player) {
    	typeStrategy = rulesFactory.getScore(type[n-1]);
    	scoreCard.setScores(scores);
        scoreCard.setCan(can);
        scoreCard.setScore(n-1, typeStrategy.getScore(player));
        totalScore = scoreCard.getTotalScore();
        upperScore = scoreCard.getUpperScore() + getUpperBonus();
        can = scoreCard.getCan();
        scores = scoreCard.getScoreCard();
    }

    public boolean getCan(int i) {
        return scoreCard.getCan(i);
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpperScore(int upperScore) {
        this.upperScore = upperScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getUpperScore() {
        return upperScore;
    }

    public String getName() {
        return this.name;
    }

    public int getUpperBonus()
    {
        return upperBonusStrategy.getUpperBonus(scoreCard);
    }

    public void setTime(String localtime) {
        this.localtime = localtime;
    }

    public String getTime(){
        return localtime;
    }

    public List<Dice> getDiceList() {
        return this.diceList;
    }

    public List<Boolean> getCan() {
        return can;
    }

    public void setCan(List<Boolean> can) {
        this.can = can;
    }

}

