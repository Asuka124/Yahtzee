package model.rules;

import model.Dice;
import model.Player;

public class SmallStraightStrategy implements ITypeStrategy {

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
            if(countStraight > 3)
                return 30;
        }
        return 0;
    }
}
