package model.rules;

import model.Player;

public class YahtzeeStrategy implements ITypeStrategy{
	
    @Override
    public int getScore(Player player) {
    	int value = -1000;
        for(int i=0; i<player.getDiceList().size(); i++) {
        	if(value==-1) {
        		value = player.getDiceList().get(i).getValue();
        	}else {
        		if(value!=player.getDiceList().get(i).getValue()) {
        			return 0;
        		}
        	}
        }
    	return 50;
    }
    
}
