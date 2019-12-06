package model.rules;

import model.Score;

public class UpperBonusStrategy implements IUpperBonusStrategy {
    
	@Override
    public int getUpperBonus(Score scoreCard) {
        return scoreCard.getUpperScore() > 63 ? 35 : 0;
    }
    
}
