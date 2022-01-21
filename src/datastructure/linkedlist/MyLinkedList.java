package datastructure.linkedlist;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 2. add(위치, 데이터)
    public void add(int index, Object data) {
        // index = 2에 넣는다면
        // index = 1인 Node를 가져와서 생성한 노드를 연결하고 기존에 index = 2 위치에 있던 노드를 연결
        Node prevNode = this.getNodeByIndex(index - 1);
        Node nextNode = prevNode.getNext();
        Node insertNode = new Node(data);
        prevNode.setNext(insertNode);
        insertNode.setNext(nextNode);
        size++;
        if (insertNode.getNext() == null) {
            tail = insertNode;
        }
    }

    // 3. addFirst()
    public void addFirst(Object data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        size++;
        if (head.getNext() == null) {
            tail = head;
        }
    }

    // 4. addLast()
    public void addLast(Object data) {
        Node node = new Node(data);
        if (tail == null) {
            addFirst(data);
            return;
        }
        tail.setNext(node);
        tail = node;
        size++;
    }

    // 5. pop()
    public Node pop() {
        Node node = head;
        Node result;
        while (true) {
            if (node.getNext() == tail) {
                result = node.getNext();
                tail = node;
                tail.setNext(null);
                size -= 1;
                break;
            }
            node = node.getNext();
        }
        return result;
    }

    // 6. peek()
    public Node peek() {
        return tail;
    }

    // 7. size()
    public int size() {
        return size;
    }

    // 8. remove(int index)
    public Node remove(int index) {
        Node prevNode = this.getNodeByIndex(index - 1);
        Node removeNode = prevNode.getNext();
        Node nextNode = removeNode.getNext();
        prevNode.setNext(nextNode);
        size--;
        return removeNode;
    }

    public Node getNodeByIndex(int index) {
        Node node = head;
        int count = 0;
        while (head.getNext() != null) {
            if (count == index) {
                break;
            }
            node = node.getNext();
            count++;
        }
        return node;
    }

    public void printAllNode() {
        System.out.print("목록 출력 : ");
        Node node = head;
        while (true) {
            System.out.print(node.getData() + " ");
            if (node.getNext() == null) {
                break;
            }
            node = node.getNext();
        }
        System.out.println();
    }
}
