package model.rules;

import model.Player;

public class Card3Strategy implements ITypeStrategy {
    @Override
    public int getScore(Player player) {
    	int score = 0;
    	for(int i=0; i<player.getDiceList().size(); i++)
    		if(player.getDiceList().get(i).getValue()==3)
    			score ++;
    	return score * 3;
    }
}
