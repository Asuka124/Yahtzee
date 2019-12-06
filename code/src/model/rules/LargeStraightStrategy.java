package model.rules;

import model.*;

public class LargeStraightStrategy implements ITypeStrategy {

    @Override
    public int getScore(Player player) {
        int count[] = new int[6];
        for(Dice dice : player.getDiceList())
            count[dice.getValue()-1] += 1;
        int countStraight = 0;
        for(int i : count) {
            if(i > 0)
                countStraight++;
            else
                countStraight = 0;
            if(countStraight > 4)
                return 40;
        }
        return 0;
    }
}
