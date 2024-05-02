//-----------------------------------------------------
// Title: Stack class
// Author: Arda Baran
// Description:  
//Stack Data Structures implemented as Array In Order To perform DFS algorithm.
//------------------------------------------------------
public class Stack {
int top,capacity;//the last element of stack and capacity of stack.
Pit bag[];//stack array which is type of Pit structure.
public Stack(int capacity) {
	this.capacity=capacity;
    this.top=-1;
    this.bag=new Pit[this.capacity];
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public Pit[] getBag() {
	return bag;
}
public void setBag(Pit[] bag) {
	this.bag = bag;
}
public void setTop(int top) {
	this.top = top;
}
public boolean isEmpty() {
	return(top==-1);
}
public boolean isFull() {
	return (top==this.capacity-1);
}
public void addPitToStack(Pit pit) {
//Adds Pit structure instance to Stack		
	if(isFull()) {
		return;
	}
top++;
bag[top]=pit;
}
public void deletePitFromStack() {
	if(isEmpty()) {
		return;
	}
top--;
}
public Pit getTop() {
	if(!isEmpty()) {
		return bag[top];
	}
	return null;
}
}