package com.example.MARS.enums;

import com.example.MARS.utils.MarsPosition;

public enum MarsCommands {
    M{
        public MarsPosition execute( MarsPosition marsPosition){
            marsPosition.walk();
            return marsPosition;
        }
    },
    L{
        public MarsPosition execute( MarsPosition marsPosition){
             marsPosition.toLeft();
            return marsPosition;
        }
    },
    R{
        public MarsPosition execute( MarsPosition marsPosition){
            marsPosition.toRight();
            return marsPosition;
        }
    };

    public abstract MarsPosition execute(MarsPosition marsPosition);
}
