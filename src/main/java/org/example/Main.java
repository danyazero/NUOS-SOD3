package org.example;// Heap Sort in Java

import UI.UI;
import UI.UII;
import priorityQueue.LinearPriorityQueue;
import priorityQueue.LinearPriorityQueueProcessor;
import priorityQueue.MyPriorityQueue;
import priorityQueue.PriorityQueueProcessor;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        UII ui = new UI();
        LinearPriorityQueueProcessor h = new LinearPriorityQueue();
        PriorityQueueProcessor hs = new MyPriorityQueue();


        Scanner scanner = new Scanner(System.in);
        loop:
        while (true){
            menu();
            int m = scanner.nextInt();
            switch (m) {
                case 0 -> ui.intArrayUI(scanner, hs);
                case 1 -> ui.linkedListUI(scanner, h);
                case 2 -> {break loop;}
            }
        }

    }


    private void menu(){
        System.out.println("[0] Int array");
        System.out.println("[1] Linked List");
        System.out.println("[2] Exit");
    }

}