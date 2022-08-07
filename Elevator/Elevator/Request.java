package Elevator;

// Command
public class Request {
    int currentFloor;
    int finalFloor;
    Direction direction;
    Position position;
    Request(int currentFloor, int finalFloor, Direction direction, Position position){
        this.currentFloor=currentFloor;
        this.finalFloor=finalFloor;
        this.direction=direction;
        this.position=position;
    }
}
