package csc220.program5.jonesah2019;

import csc220.program5.sample.*;
import csc220.list.AddIterator;
import csc220.list.Node;
import java.util.NoSuchElementException;
   
/*
    Andrew Jones
    4/28/2017
    Description: This class List extends csc220.list.List<E> and contains code 
     that allows the coder to access the previous node in the list (prevNode) as
     well as the next (nextNode). In the nested class ListAddIterator, which
     extends csc220.list.List<E>.ListAddIterator<E>, these parameters are used
     with first and last to construct methods remove() and addBeforeNext(). 
     Remove() allows the user to remove the most recent node in the list 
     whenever the associated character is clicked. AddBeforeNext() allows the 
     user to add a point into the list by pausing the animation, clicking the
     character, and then clicking where they want it to go next.

*/

public class List<E> extends csc220.list.List<E> { 

       
   @Override
   public AddIterator<E> addIterator(){return new ListAddIterator<>();}
   
   
   //  This nested class replaces the one in csc220.list.List
   protected class ListAddIterator<T extends E> extends csc220.list.List<E>.ListAddIterator<E> {
       
       private static final boolean DEBUGGING = true;
      
        protected Node<E> prevNode = null;
        
        @Override
        public E next() {
            prevNode = nextNode;
            return super.next();
            
        }

        // For debugging purposes.
        private void printNodes(String s) {
            if (!DEBUGGING)
                return;
            System.out.print(s);
            if (prevNode != null) {
                System.out.print("--previous data = " + prevNode.data);
            }
            if (nextNode != null) {
                System.out.print("--next data = " + nextNode.data);               
            }
            System.out.println("");
        }
        
       
        @Override
        public void addBeforeNext(E e) {

            Node<E> newNode = new Node<>();
            newNode.data = e;
           
            newNode.next = nextNode;
            if (nextNode == first){    
                first = newNode;
            } else {
                prevNode.next = newNode;
            }
           
        }
        
        @Override
        public void remove() {
            
            printNodes("Remove under construction");
            
            if(prevNode != first && prevNode != null){
                Node<E> tmp = first;
                while(tmp.next != prevNode){
                    tmp = tmp.next;
                }
                tmp.next = nextNode;
                
            } else {
                prevNode = prevNode.next;
                first = prevNode;
            }
            prevNode = null;
            
        }
   
   }
   
   
}
