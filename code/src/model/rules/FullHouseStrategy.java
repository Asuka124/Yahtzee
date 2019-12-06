package model.rules;

import model.*;

public class FullHouseStrategy implements ITypeStrategy {

    @Override
    public int getScore(Player player) {
        int count[] = new int[7];
        for(int i = 0; i < player.getDiceList().size(); i++)
            count[player.getDiceList().get(i).getValue()]++;
        boolean three = false;
        boolean two = false;
        for(int i = 1; i <= 6; i++) {
            if(count[i] == 3)
                three = true;
            if(count[i] == 2)
                two = true;
        }
        if (three && two)
            return 25;
        return 0;
    }
}
