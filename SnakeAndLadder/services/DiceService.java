// the dice related operations can be hanled by the this diceService Rolling
//from random 6 numbers we choose a number 

class diceService{
    public static int RollDice(){
        return new Random().nextInt(6) + 1;
    }
}
