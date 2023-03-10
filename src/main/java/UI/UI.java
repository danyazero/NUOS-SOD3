package UI;

import priorityQueue.LinearPriorityQueue;
import priorityQueue.LinearPriorityQueueProcessor;
import priorityQueue.MyPriorityQueue;
import priorityQueue.PriorityQueueProcessor;

import java.util.Random;
import java.util.Scanner;

public class UI implements UII{

    private void menu(){
        System.out.println("[1] Add Num");
        System.out.println("[2] Remove");
        System.out.println("[3] Show sorted array");
        System.out.println("[4] Exit");
    }
    @Override
    public void intArrayUI(Scanner sc, PriorityQueueProcessor hs) {

        Random random = new Random();
        for (int i = 0; i <= 1000; i++) {
            hs.add(random.nextInt(1, 999));
        }

        loop:
        while (true){
            menu();
            int m = sc.nextInt();
            switch (m) {
                case 1 -> addNum(sc, hs);
                case 2 -> System.out.println(hs.remove());
                case 3 -> System.out.println(hs.toString());
                case 4 -> {break loop;}
            }
        }
    }

    private void addNum(Scanner sc, PriorityQueueProcessor hs) {
        int num = sc.nextInt();
        hs.add(num);
    }
    @Override
    public void linkedListUI(Scanner sc, LinearPriorityQueueProcessor h) {

        Random random = new Random();
        for (int i = 0; i <= 1000; i++) {
            h.add(random.nextInt(1, 999));
        }

        loop:
        while (true) {
            menu();
            int m = sc.nextInt();
            switch (m) {
                case 1 -> addNumToLinkedList(sc, h);
                case 2 -> System.out.println(h.remove());
                case 3 -> System.out.println(h);
                case 4 -> {break loop;}
            }
        }
    }

    public void addNumToLinkedList(Scanner sc, LinearPriorityQueueProcessor h){
        int num = sc.nextInt();
        h.add(num);
    }
}
