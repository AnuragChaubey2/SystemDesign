package Elevator;

import java.util.PriorityQueue;


public class Service {
    int currentFloor;
    //min heap is used for the lift to go upward 
    PriorityQueue<Request> upward;
    //max heap is used for the lift to go downward 
    PriorityQueue<Request> downward;
    Direction direction;

    // Initally when lift is ideal position dosen't matter 
    Service(int currentFloor){
        this.currentFloor=currentFloor;
        upward=new PriorityQueue<>((a,b)-> a.finalFloor-b.finalFloor);  
        downward=new PriorityQueue<>((a,b)-> b.finalFloor-a.finalFloor);
        this.direction=Direction.IDLE;
    }

    public void MoveLiftUp(Request Uprequest){
    // check if person is calling the lift from outside the lift     
       if(Uprequest.position==Position.OUT){
          upward.offer(new Request(currentFloor, currentFloor, Direction.UP, Position.OUT));
          System.out.println("Append up for going upward"+ Uprequest.currentFloor);
       }
       // if people enter in the lift 
       upward.offer(Uprequest);
       System.out.println("Append when people is inside the lift"+ Uprequest.finalFloor);
       
    }

    public void MoveLiftDown(Request Downrequest){
        if(Downrequest.position==Position.OUT){
            downward.offer(new Request(currentFloor,currentFloor,Direction.DOWN,Position.OUT));
            System.out.println("Append Down for going Downward"+Downrequest.currentFloor);
        }
        downward.offer(Downrequest);
        System.out.println("Append Down for going down when person is inside"+ Downrequest.currentFloor);
    }
    
    public void run(){
        while(!upward.isEmpty() || !downward.isEmpty()){
            //someFunction 
            ProcessRequest();
        }
          //as soon as lift will process All the request
          System.out.println("Everything has been processed");
          this.direction=Direction.IDLE;
    }

    public void ProcessRequest(){
        if (this.direction == Direction.UP || this.direction == Direction.IDLE) {
            processUpRequest();
            processDownRequest();
        } else {
            processDownRequest();
            processUpRequest();
        }
    }

    public void processUpRequest(){
    while(!upward.isEmpty()){
        Request Uprequest=upward.poll(); 
        //keep updating the floors as lift will go to upwards
        this.currentFloor=Uprequest.finalFloor;
        System.out.println("Processing up requests. Elevator stopped at floor " + this.currentFloor + ".");
    }
    if(!downward.isEmpty()){
        this.direction=Direction.DOWN;
    } else{
        this.direction=Direction.IDLE;
    }
    }

    public void processDownRequest(){
    while(!downward.isEmpty()){
        Request downRequest=downward.poll();
        //keep updating the floors as lift will go to downwards
        this.currentFloor=downRequest.finalFloor;
        System.out.println("Processing up requests. Elevator stopped at floor " + this.currentFloor + ".");
    }
    if(!upward.isEmpty()){
        this.direction=Direction.UP;
    } else{
        this.direction=Direction.IDLE;
    }
  }

  public static void main(String[] args) {
    Service elevator = new Service(0);

    Request upRequest1 = new Request(elevator.currentFloor, 5, Direction.UP, Position.IN);
    Request upRequest2 = new Request(elevator.currentFloor, 3, Direction.UP, Position.IN);

    Request downRequest1 = new Request(elevator.currentFloor, 1, Direction.DOWN,Position.IN);
    Request downRequest2 = new Request(elevator.currentFloor, 2, Direction.DOWN,Position.IN);
    Request downRequest3 = new Request(4, 0, Direction.DOWN, Position.OUT);

    // Two people inside of the elevator pressed button to go up to floor 5 and 3.
    elevator.MoveLiftUp(upRequest1);
    elevator.MoveLiftUp(upRequest2);

    // One person outside of the elevator at floor 4 pressed button to go down to floor 0
    elevator.MoveLiftDown(downRequest3);

    // Two person inside of the elevator pressed button to go down to floor 1 and 2.
    elevator.MoveLiftDown(downRequest1);
    elevator.MoveLiftDown(downRequest2);

    elevator.run();
  }
}
