package com.example.MARS.enums;

import com.example.MARS.utils.MarsPosition;

public enum MarsDirection {
    NORTH{
        public void walk(MarsPosition masMarsPosition){
            masMarsPosition.setPositionY(masMarsPosition.getPositionY() + 1);
        }
        public MarsDirection toLeft(){ return WEST; }

        public MarsDirection toRight(){ return EAST; }

    },
    SOUTH{
        public void walk(MarsPosition masMarsPosition){
            masMarsPosition.setPositionY(masMarsPosition.getPositionY() - 1);
        }
        public MarsDirection toLeft(){ return EAST; }

        public MarsDirection toRight(){ return WEST; }

    },
    EAST{
        public void walk(MarsPosition masMarsPosition){
            masMarsPosition.setPositionX(masMarsPosition.getPositionX() + 1);
        }
        public MarsDirection toLeft(){ return NORTH; }

        public MarsDirection toRight(){ return SOUTH; }

    },
    WEST{
        public void walk(MarsPosition masMarsPosition){
            masMarsPosition.setPositionX(masMarsPosition.getPositionX() - 1);
        }
        public MarsDirection toLeft(){ return SOUTH; }

        public MarsDirection toRight(){ return NORTH; }
    };

    public abstract MarsDirection toLeft();

    public abstract MarsDirection toRight();

    public abstract void walk(MarsPosition marsPosition);
}