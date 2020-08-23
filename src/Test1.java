import java.util.logging.StreamHandler;

public class Test1 {

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public Test1(Node head) {
        this.head = head;
    }

    // 3. 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    // 如果有两个中间结点，则返回第二个中间结点。
    public Node middleNode(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }




    //4. 输入一个链表，输出该链表中倒数第k个结点。
    public Node node(int k){
        if (k < 0 || k > size()){
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }


    //6. 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。
    public Node partition(int x){
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while (cur != null){
            if (cur.data < x){
                if (bs == null){
                    bs = cur;
                    be = bs;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }

            if (cur.data > x){
                if (as == null){
                    as = cur;
                    ae = as;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs == null){
            return as;
        }

        if (as != null){
            be.next = as;
            ae.next = null;
        }
        return bs;
    }








    // 7. 在一个 排序  的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 [OJ链接]
    public Node removeSame() {
        Node node = new Node(-1);
        Node tmp  = node;
        Node cur = this.head;
        while (cur != null){
            if ( cur.next != null && cur.next == cur.next.next){
                while (cur.next != null && cur.next == cur.next.next){
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return node.next;
    }







    // 8. 判断链表的回文结构。
    public boolean palinDrome (){
        Node fast = this.head;
        Node slow = this.head;
        while (fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node cur = slow.next;
        while (cur != null){
            Node Nextcur = cur.next;
            cur.next = slow;
            slow = cur;
            cur = Nextcur;
        }

        while (slow != this.head){
            if (slow.data != this.head.data){
                return false;
            }
            if (slow == this.head.next){
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }

}
