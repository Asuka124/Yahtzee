package model.rules;

import model.Player;

public class Card6Strategy implements ITypeStrategy {

    @Override
    public int getScore(Player player) {
    	int score = 0;
    	for(int i=0; i<player.getDiceList().size(); i++)
    		if(player.getDiceList().get(i).getValue()==6)
    			score ++;
    	return score * 6;
    }
}
