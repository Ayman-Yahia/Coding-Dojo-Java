public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head=null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    } 
    public void remove(){
        if(this.head==null){
            System.out.println("This list is empty");
        }
        else if(this.head.next==null){
            this.head=null;
        }
        else{
            Node runner=head;
            while(runner.next.next!=null){
                runner=runner.next;
            }
            runner.next=null;
        }
    }
    public void printValues(){
        if(head==null){
            System.out.println("This list is empty");
        }
        else{
            Node runner=head;
            while(runner!=null){
                System.out.println(runner.getValue());
                runner=runner.next;
            }
        }
    }