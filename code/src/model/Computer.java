package model;

public class Computer extends Player {

    public Computer(int id, Score scoreCard) {
        super("Com: "+id, scoreCard);
    }

    public void fill() {
        for(int i = 0; i < Type.type.length; i++ ) {
            if(!this.getCan().get(i)) {
                chooseType(i+1, this);
                break;
            }
        }
    }

}
