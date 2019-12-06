package model.rules;

import model.*;

public class Card1Strategy implements ITypeStrategy {

    @Override
    public int getScore(Player player) {
    	int score = 0;
    	for(int i=0; i<player.getDiceList().size(); i++)
    		if(player.getDiceList().get(i).getValue()==1)
    			score ++;
    	return score * 1;
    }
}
