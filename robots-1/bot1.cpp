
#include <cstdlib>
#include <cmath>
#include <vector>
#include <iostream>
#include "bot1.h"


using namespace std;

static loc target;


void init_robot(int w, int h, loc robot, ostream &log) {
  log << "Hello" << endl; 
  target.x = robot.x; //x coordinate in the grid
  target.y = robot.y; //y coordinate in the grid
}


//this function shows the direction where the robot is going
action choose_next_step(int w, int h, loc robot, vector<loc> dm, ostream &log) {
	int min = -1; // I set the min to be very smaller than it should be so that if the loop doesn't find anything its empty
	int max = 9999; // I set the max to be very large  so that the first thing I find is definitely closer
	
	for (int i = 0; i< dm.size(); i++) // this loop iterates through the vector of diamonds
	{
	    int distancex = abs(dm[i].x-robot.x);    //distance formula on the x and y coordinates of the diamond and current position of the robot
	    int distancey = abs(dm[i].y-robot.y);  
	    int distance = distancex + distancey;
	    
	    if (distance < max)  // if the distance is less than the maximum value
	    {
	        min = i;                 // minimum gets updated to i which is 0
	        max = distance;  // the max is updated to the value of the distance in the x and y coordinates 
	    }
	}
	
	target = dm[min];  // set the target to the closest diamond
	log << "goto (" << target.x << "," << target.y << "); ";
	
	if(robot.x < target.x){ //check in the x direction using less than inequality
	    return RIGHT;
	}
	if(robot.x > target.x){ //check in the x direction using greater than inequality
		return LEFT;
	}

	if(robot.y > target.y){ //check in the y direction using greater than inequality
		return DOWN;
	}
	else
	{
		return UP;
	}
}

// This code uses Euclidean's distance to find the distance between the robot and the diamonds. The minimum is set to be very small so that if the loop doesn't find anything it becomes empty. The maximum is set to be very large so that the first thing found is defintely closer. The loop iterates through the vector of diamonds, if the distance is less than the max, the minimum gets updated and the max becomes the distance. The target is then set to the closest diamond of minimum value and then returns the actions. 


		
	

	