package model;

import java.util.ArrayList;
import java.util.List;

public class Score {
	
    private List<Integer> score;
    private List<Boolean> can;
 
    public Score() {
        score = new ArrayList<>();
        can = new ArrayList<>();
        for(int i = 0; i < Type.type.length; i++) {
            can.add(false);
            score.add(0);
        }
    }

    public void setScore(int index, int value) {
        if (!can.get(index)) {
            score.set(index, value);
            can.set(index, true);
        }
    }

    public boolean getCan(int index) {
        System.out.print(can.get(index));
        return can.get(index) ? true : false;
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < score.size(); i++)
            totalScore += score.get(i);
        return totalScore;
    }

    public int getUpperScore() {
        int upperScore = 0;
        for(int i = 0; i < 6; i ++)
            upperScore += score.get(i);
        return upperScore;
    }
 
    public List<Boolean> getCan() {
        return can;
    }

    public void setCan(List<Boolean> can) {
        this.can = can;
    }

    public void setScores(List<Integer> scores) {
        this.score = scores;
    }

    public List<Integer> getScoreCard() {
        return score;
    }

}
