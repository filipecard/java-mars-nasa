package com.example.MARS.utils;
;
import com.example.MARS.enums.MarsDirection;
import com.example.MARS.exceptions.InvalidCommandException;
import org.springframework.stereotype.Service;

@Service
public class MarsPosition {
    private final int maxPosition = 5;

    private Integer currentPositionX = 0;
    private Integer currentPositionY = 0;
    private MarsDirection currentDirection = MarsDirection.NORTH;


    public Integer getPositionX() { return currentPositionX; }

    public Integer getPositionY() { return currentPositionY; }


    public void setPositionX(Integer positionX) {
        if (positionX >= maxPosition || positionX < 0 ) {
            throw new InvalidCommandException();
        }
        this.currentPositionX = positionX;
    }

    public void setPositionY(Integer positionY) {
        if (positionY >= maxPosition || positionY < 0 ) {
            throw new InvalidCommandException();
        }
        this.currentPositionY = positionY;
    }

    public void toLeft() {
        this.currentDirection = this.currentDirection.toLeft();
    }

    public void toRight() {
        this.currentDirection = this.currentDirection.toRight();
    }

    public void walk() {
        this.currentDirection.walk(this);
    }

    public void resetPosition(){
            setPositionX(0);
            setPositionY(0);
            this.currentDirection = MarsDirection.NORTH;
    }

    public String returnPosition() {
        return String.format("(%d, %d, %s)", this.currentPositionX, this.currentPositionY, this.currentDirection.name().charAt(0));
    }

}
