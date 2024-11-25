package com.mm.algorithms;

import com.mm.algorithms.Exceptions.InvalidElementException;
import lombok.Getter;

import java.util.NoSuchElementException;

/**
 * An object which support creating a list with non-contiguous memory allocation. You cannot access a random element
 * directly using index. But if you have a pointer to a node, then you can traverse the list both in forward and
 * backward direction in the list.
 *
 * @param <E> Type of element stored in list.
 */

@Getter
public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> dummyhead;
    DoublyLinkedListNode<E> dummytail;

    public DoublyLinkedList(){
        dummyhead = new DoublyLinkedListNode<>(null);
        dummytail = new DoublyLinkedListNode<>(null);
        dummyhead.next = dummytail;
        dummytail.prev=dummyhead;
    }

    /**
     * Method to detach a random node from the doubly linked list. The node itself will not be removed from the memory.
     * Just that it will be removed from the list and becomes orphaned.
     *
     * @param node Node to be detached.
     */
    public void detachNode(DoublyLinkedListNode<E> node){
        if(node!=null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     * Helper method to add a node at the end of the list.
     *
     * @param node Node to be added.
     */
    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode prevNode = dummytail.prev;
        prevNode.next = node;
        node.prev=prevNode;
        node.next=dummytail;
        dummytail.prev = node;
    }

    /**
     * Helper method to add an element at the end.
     *
     * @param element Element to be added.
     * @return Reference to new node created for the element.
     */
    public DoublyLinkedListNode<E> addElementAtLast(E element){
        if(element!=null){
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public boolean isItemPresent(){
        return dummyhead.next!=dummytail.prev;
    }

    public DoublyLinkedListNode<E> getFirstNode() throws NoSuchElementException {
        if(!isItemPresent()){
            return null;
        }
        return dummyhead.next;
    }

    public DoublyLinkedListNode<E> getLastNode() throws NoSuchElementException{
        if(!isItemPresent()){
            return null;
        }
        return dummytail.prev;
    }

}
