package com.example.MARS.enums;

import com.example.MARS.utils.MarsPosition;

public enum MarsCommands {
    M{
        public void execute(MarsPosition marsPosition){
            marsPosition.walk();
        }
    },
    L{
        public void execute(MarsPosition marsPosition){
             marsPosition.toLeft();
        }
    },
    R{
        public void execute(MarsPosition marsPosition){
            marsPosition.toRight();
        }
    };

    public abstract void execute(MarsPosition marsPosition);
}
