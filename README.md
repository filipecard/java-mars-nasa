# MARS

MARS is a robot sent to Mars and the tests must execute commands referring to a 5x5 area;

The robot starts in the quadrant (0,0) and its direction to the north: (0,0,N);


## Inputs
The input received must be a sequence of commands being: 

L(left), 

R(right), 

M(move);


### Success Example

Example:

 - Current position: (0,0,N)
 - Command: curl -s --request POST http://localhost:8080/rest/mars/MML
 - Result: (0,2,W)


### Failed Example


Example 1: If any commands are passed in addition to these, a 400 Bad Request error must be returned.

 - Current position: (0,0,N)
 - Command: curl -s --request POST http://localhost:8080/rest/mars/AAA
 - Result:  400 Bad Request

Example 2: If the boundary area is exceeded, a 400 Bad Request error must be returned.

 - Current position: (0,0,N)
 - Command: curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMM
 - Result:  400 Bad Request

