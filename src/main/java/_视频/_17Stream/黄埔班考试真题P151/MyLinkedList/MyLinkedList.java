package _视频._17Stream.黄埔班考试真题P151.MyLinkedList;

import java.util.Scanner;

public class MyLinkedList<E> {
    private int size;
    /**
     * 定义一个私有内部类，作为链表的结点
     */
    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node<E> add(){
        //头结点
        Node<E> head = null;
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("请输入当前结点数据：");
            String data = scan.next();
            if(data.equals("exit")) break;

            if(head == null){
                head = new Node(data,null);
                size++;
            }else {
                //往后面插入结点   尾插法
                Node<E> temp = head;
                //找head结点的尾结点
                while (temp.next != null){
                    temp = temp.next;
                }
                //???
                temp.next = new Node(data,null);
                size++;
            }
        }

        return head;
    }

    public void forEach(Node<E> head){
        if(head == null){
            System.out.println(head);
            return;
        }
        while (head != null){
            System.out.println(head.data + " ");
            head = head.next;
        }
    }

}
