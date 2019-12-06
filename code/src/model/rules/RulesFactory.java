package model.rules;

public class RulesFactory {
	
    public ITypeStrategy getScore(String string) {
    	
    	string = string.toUpperCase();

        if(string.equals("ACES"))
        	return new Card1Strategy();
        
        if(string.equals("TWOS"))
	        return new Card2Strategy();
        
        if(string.equals("THREES"))
        	return new Card3Strategy();
        
        if(string.equals("FOURS"))
        	return new Card4Strategy();
        
        if(string.equals("FIVES"))
        	return new Card5Strategy();
        
        if(string.equals("SIXES"))
        	return new Card6Strategy();
        
        if(string.equals("THREE_OF_A_KIND"))
        	return new ThreeOfAKindStrategy();
        
        if(string.equals("FOUR_OF_A_KIND"))
        	return new FourOfAKindStrategy();
        
        if(string.equals("FULL_HOUSE"))
        	return new FullHouseStrategy();
        
        if(string.equals("SMALL_STRAIGHT"))
        	return new SmallStraightStrategy();
        
        if(string.equals("LARGE_STRAIGHT"))
        	return new LargeStraightStrategy();
       
        if(string.equals("CHANCE"))
        	return new ChanceStrategy();
        
        if(string.equals("YAHTZEE"))
        	return new YahtzeeStrategy();

        return null;
    }

    public IUpperBonusStrategy getBonus() {
        return new UpperBonusStrategy();
    }

}

