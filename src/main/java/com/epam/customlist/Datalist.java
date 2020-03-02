
package com.epam.customlist;

import java.util.Arrays;

public class Datalist<E>{
    //size of list
    private int size=0;
    //Default capacity of list is 10
    private static final int DEFAULT_CAPACITY=10;
    //this array will store all elements added to list
    private Object elements[];
    
    //Default constructor 
    public DataList(){
        elements =new Object[DEFAULT_CAPACITY];
    }
    
    //add method
    public void add(E e){
        if(size == elements.length){
            ensureCapacity();
        }
        elements[size++] = e;
    }
    
    //get method
    @SuppressWarnings("unchecked")
    public E get(int i){
        if(i>=size || i<0){
            throw new IndexOutOfBoundsException("Index: "+ i +",size " + i);
        }
        return (E) elements[i];
    }
    //remove method
    @SuppressWarnings("unchecked")
    public E remove(int i){
        if(i>=size || i<0){
            throw new IndexOutOfBoundsException("index:"+ i +",size" +i);
        }
       
          Object item=elements[i];
          int numElts=elements.length-(i+1);
          System.arraycopy(elements, i+1, elements, i, numElts);
          size--;
          return (E) item;
    }
    
    //get size of list
    public int size()
    {
        return size;
    }
    
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append('[');
for(int i=0;i<size;i++){
    sb.append(elements[i].toString());
    if(i<size-1){
        sb.append(",");
    }
}
sb.append(']');
return sb.toString();
    }
    private void ensureCapacity(){
        int newSize=elements.length*2;
        elements =Arrays.copyOf(elements, newSize);
    }
        }
 
    
