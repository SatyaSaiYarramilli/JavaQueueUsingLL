/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueusingll;

import java.util.Scanner;

/**
 *
 * @author aditya
 */
public class QueueUsingLL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int item, choice = 0;
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();

        do {
            q.sop("Enter choice:\n1.Push\n2.Pop\n3.Display\n4.Push multiple\n5.Pop all\n6.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    q.sop("Enter element: ");
                    item = sc.nextInt();
                    q.push(item);
                    break;
                case 2:
                    q.pop();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    do {
                        q.sop("Enter item: ");
                        item = sc.nextInt();
                        q.push(item);
                    } while (item != 0);
                    break;
                case 5:
                    do {
                        q.pop();
                    } while (q.front != null);
                    q.sop("All elements deleted");
                    break;
                case 6:
                    System.exit(0);
                default:
                    q.sop("Invalid choice. Try again");
            }
        } while (choice != 6);
    }

    static class Node {

        int data;
        Node link;

        public Node(int d) {
            data = d;
            link = null;
        }
    }

    static class Queue {

        public Queue() {
            front = rear = null;
        }

        Node front, rear;

        public void push(int item) {
            if (item == 0) {
                sop("Entered Zero, exiting....");
            } else {
                if (front == null) {
                    Node temp = new Node(item);
                    front = rear = temp;
                } else {
                    Node temp = new Node(item);
                    rear.link = temp;
                    rear = temp;
                }
            }
        }

        public void pop() {
            if (front == null) {
                sop("Queue is empty");
            } else {
                sop("Deleted " + front.data);
                front = front.link;
            }
        }

        public void display() {
            if (front == null) {
                sop("Queue is empty.");
            } else {
                Node temp = front;
                while (temp != null) {
                    sop("Element: " + temp.data);
                    temp = temp.link;
                }
            }
        }

        public void sop(String s) {
            System.out.println(s);
        }
    }
}
