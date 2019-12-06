package controller;

import model.Game;
import model.Type;
import view.View;

public class Play {
	
    private View view = new View();
    private Game game = new Game(0, "");
    
    public void start() {
        view.displayStart();
        switch (view.getInt()) {
            case 1: 
            	view.displayInputName();
            	String name = view.getString();
	            view.displaySelectNumber();
	            int number = view.getInt();
                game = new Game(number, name);
                playGame(game);
                game.save();
                break;
            case 2: 
            	game = game.load();
            	playGame(game); 
            	break;
            default: 
            	start();
            	break;
        }
    }

    public void playGame(Game game) {
        for(int i = 0; i < Type.type.length; i++) {
            view.displayPlay();
            switch (view.getInt()) {
                case 1: 
                	game.start();
                    view.displayRoll(game);
                    break;
                case 2: 
                	view.displayCompactList(game.getPlayer(), game.getComputer());
                	break;
                case 3: 
                	view.displayFullScore(game.getPlayer());
                    view.displayFullScoreComputer(game.getComputer());
                    break;
                default: 
                	game.save();
                	start(); 
                	break;
            }
        }
    }

  
}
