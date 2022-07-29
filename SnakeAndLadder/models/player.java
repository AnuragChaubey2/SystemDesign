class player{
    
    private String name;
    private String id; 
    
    Player(String name){
        this.name=name;
        this.id = UUID.randomUUID().toString();
    }
    
     public String getName(){
         return name;
     }
     
     public String getId(){
         return id;
     }
}