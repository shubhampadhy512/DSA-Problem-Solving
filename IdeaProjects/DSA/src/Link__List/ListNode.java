package Link__List;

//public class LinkList {
//
//    // Node Class
//    private class Node {
//       private int data;
//       private Node next;
//
//        public Node(int data) {
//            this.data = data;
//        }
//        public Node (int data,Node next) {
//            this.data = data;
//            this.next = next;
//        }
//    }
//    private Node head;
//    private Node tail;
//    private int size;
//
//    // ================= INSERT =================
//
//    // Insert at beginning
//    public void addFirst(int data) {
//        Node node = new Node(data);
//
//        if (head == null) {
//            head = tail = node;
//        } else {
//            node.next = head;
//            head = node;
//        }
//        size++;
//    }
//
//    // Insert at end
//    public void addLast(int data) {
//        Node node = new Node(data);
//
//        if (head == null) {
//            head = tail = node;
//        } else {
//            tail.next = node;
//            tail = node;
//        }
//        size++;
//    }
//
//    // Insert at specific position
//    public void addAt(int index, int data) {
//
//        if (index < 0 || index > size) {
//            System.out.println("Invalid Index");
//            return;
//        }
//
//        if (index == 0) {
//            addFirst(data);
//            return;
//        }
//
//        if (index == size) {
//            addLast(data);
//            return;
//        }
//
//        Node temp = head;
//
//        for (int i = 0; i < index - 1; i++) {
//            temp = temp.next;
//        }
//
//        Node node = new Node(data);
//        node.next = temp.next;
//        temp.next = node;
//
//        size++;
//    }
//
//    // ================= DELETE =================
//
//    // Delete first node
//    public void removeFirst() {
//
//        if (head == null) {
//            System.out.println("List Empty");
//            return;
//        }
//
//        head = head.next;
//
//        if (head == null)
//            tail = null;
//
//        size--;
//    }
//
//    // Delete last node
//    public void removeLast() {
//
//        if (head == null) {
//            System.out.println("List Empty");
//            return;
//        }
//
//        if (head == tail) {
//            head = tail = null;
//            size--;
//            return;
//        }
//
//        Node temp = head;
//
//        while (temp.next != tail) {
//            temp = temp.next;
//        }
//
//        temp.next = null;
//        tail = temp;
//        size--;
//    }
//
//    // Delete by index
//    public void removeAt(int index) {
//
//        if (index < 0 || index >= size) {
//            System.out.println("Invalid Index");
//            return;
//        }
//
//        if (index == 0) {
//            removeFirst();
//            return;
//        }
//
//        if (index == size - 1) {
//            removeLast();
//            return;
//        }
//
//        Node temp = head;
//
//        for (int i = 0; i < index - 1; i++) {
//            temp = temp.next;
//        }
//
//        temp.next = temp.next.next;
//        size--;
//    }
//
//    // ================= SEARCH =================
//
//    // Search element
//    public boolean contains(int value) {
//
//        Node temp = head;
//
//        while (temp != null) {
//            if (temp.data == value)
//                return true;
//            temp = temp.next;
//        }
//
//        return false;
//    }
//
//    // Return index of element
//    public int indexOf(int value) {
//
//        Node temp = head;
//        int index = 0;
//
//        while (temp != null) {
//
//            if (temp.data == value)
//                return index;
//
//            temp = temp.next;
//            index++;
//        }
//
//        return -1;
//    }
//
//    // ================= GET =================
//
//    public int getFirst() {
//        if (head == null)
//            throw new RuntimeException("List Empty");
//        return head.data;
//    }
//
//    public int getLast() {
//        if (tail == null)
//            throw new RuntimeException("List Empty");
//        return tail.data;
//    }
//
//    public int getAt(int index) {
//
//        if (index < 0 || index >= size)
//            throw new RuntimeException("Invalid Index");
//
//        Node temp = head;
//
//        for (int i = 0; i < index; i++)
//            temp = temp.next;
//
//        return temp.data;
//    }
//
//    // ================= REVERSE =================
//
//    public void reverse() {
//
//        Node prev = null;
//        Node current = head;
//        Node next;
//
//        tail = head;
//
//        while (current != null) {
//
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//
//        head = prev;
//    }
//
//    // ================= MIDDLE =================
//
//    public int middle() {
//
//        if (head == null)
//            throw new RuntimeException("List Empty");
//
//        Node slow = head;
//        Node fast = head;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return slow.data;
//    }
//
//    // ================= SIZE =================
//
//    public int size() {
//        return size;
//    }
//
//    // ================= EMPTY =================
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    // ================= CLEAR =================
//
//    public void clear() {
//        head = tail = null;
//        size = 0;
//    }
//
//    // ================= DISPLAY =================
//
//    public void display() {
//
//        Node temp = head;
//
//        while (temp != null) {
//            System.out.print(temp.data + " -> ");
//            temp = temp.next;
//        }
//
//        System.out.println("null");
//    }
//    public void RemoveDuplicated(){
////        System.out.print(head.data);
//        Node node = head;
//        while(node.next != null){
//            System.out.println(node.data);
//            if(node.data==node.next.data){
//                node.next = node.next.next;
//            }else{
//                node = node.next;
//            }
//        }
//    }
////    public static LinkList MergeDuplicated(LinkList list1, LinkList list2){
////        Node f = list1.head;
////        Node s = list2.head;
////        LinkList ans = new LinkList();
////        LinkList list = new LinkList();
////        while(f!=null&&s!=null){
////            if(f.data==s.data){
////                ans.addLast(f.data);
////                ans.addLast(s.data);
////                s = s.next;
////                f = f.next;
////            }else if(f.data<s.data){
////                ans.addLast(f.data);
////                f = f.next;
////            }else{
////                ans.addLast(s.data);
////                s = s.next;
////            }
////        }
////        while(f!=null){
////                ans.addLast(f.data);
////                f=f.next;
////        }
////        while(s!=null){
////                ans.addLast(s.data);
////                s=s.next;
////        }
////
////        return ans;
////    }
////    second method
////public static LinkList MergeDuplicated(LinkList list1, LinkList list2){
////
////    }
///
/// Definition for singly-linked list.
 public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    private ListNode head;
    private ListNode tail;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void addFirst(int data) {
        ListNode node = new ListNode(data);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void display() {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
    public ListNode deleteDuplicates() {
        ListNode pre = head;
        if(head==null||head.next==null)return head;
        ListNode temp = head.next;
        boolean flag = false;
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next = temp.next.next;
                flag =true;
            }
            else if(head.val==temp.val){
                pre = temp.next;
                head = pre;
                System.out.println(temp.val);
                if(temp.next.next==null)temp = temp.next;
                else temp = temp.next.next;
            }
            else if(flag){
                pre.next=temp.next;
                temp = temp.next;
                flag = false;
            }else{
                pre = temp;
                temp= temp.next;
            }
        }
        if(flag)pre.next=null;
        return head;
    }

    public static void main() {
        ListNode list = new ListNode();
//        LinkList list2 = new LinkList();
        list.addFirst(4);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(1);
//        list.addFirst(1);
//        list2.addLast(1);
//        list2.addLast(2);
//        list2.addLast(3);
//        list2.addLast(4);
//        list2.addLast(13);
//        list2.addLast(14);
//        list.display();
//        list.RemoveDuplicated();
//        list.display();
//        list2 = MergeDuplicated(list,list2);
        list.display();
        list.deleteDuplicates();
        list.display();
    }
}
//}
