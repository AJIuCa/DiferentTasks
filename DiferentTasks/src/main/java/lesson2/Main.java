package lesson2;

import lesson2.linkedArray.MyLinkedList;
import lesson2.linkedOneWayArray.MyOneLinkedList;

public class Main {
    public static void main(String[] args) {

//        oneWayLinkedList();
        myLinkedList();

    }

    public static void oneWayLinkedList(){
        MyOneLinkedList myOneLinkedList = new MyOneLinkedList();
        myOneLinkedList.insertFirst(12);
        myOneLinkedList.insert(0,134);
        System.out.println(myOneLinkedList.size());
        System.out.println(myOneLinkedList.getFirst());
        System.out.println(myOneLinkedList.isEmpty());
        System.out.println(myOneLinkedList.contains(12));
    }

    public static void myLinkedList(){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insertFirst(123);
        myLinkedList.insertLast(2);
        myLinkedList.insertLast(66);
        System.out.println(myLinkedList.toString());
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.getFirst());

        for (Object i: myLinkedList){
            System.out.println(i + " to iterate");
        }
    }
}
