package model.rules;

import model.*;

public class FourOfAKindStrategy implements ITypeStrategy {
	
    @Override
    public int getScore(Player player) {
        return player.getDiceList().stream().distinct()
                .filter(dices -> player.countDice(dices) >= 4)
                .findFirst()
                .map(dice -> player.countDice(dice) * dice.getValue())
                .orElse(0);
    }
    
}
