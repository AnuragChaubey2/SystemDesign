class SnakeAndLadder{
    private int size;
    private List<Snake> snake;
    private List<Ladder> ladder;
    private HashMap<String, Integer> playerpieces; 
    
    SnakeAndLadder(int size){
        this.size=size;
        this.snake=new ArrayList<>();
        this.ladder=new ArrayList<>();
        this.playerprices=new HashMap<>();
    }
    //getters and setters implementation 
    
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size=size;
    }
    public List<Snake> getSnakes(){
        return snake;
    }
    public void setSnakes(List<Snake> snakes){
    this.snake=snakes;
    }
    
    public List<Ladder> getLadder(){
        return ladder;
    }
    public void setLadder(List<Snake> ladder){
        this.ladder=ladder;
    }
    public HashMap<String, Integer> getPlayerPieces(){
        return playerpieces;
    }
    public void setPlayerPeices(HashMap<String, Integer> playerpeices){
        this.playerprices=playerprices;
    }
}