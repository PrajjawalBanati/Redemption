public class CopyLinkedListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return null;
        }
        if(head.next == null)
        {
            Node node = new Node(head.val);
            if(head.random == head)
            {
                node.random = node;
            }
            return node;
        }
        Node newHead = null;
        Node tempNewHead = null;
        Node temp = head;
        while(temp != null)
        {
            Node newNode = new Node(temp.val);
            if(newHead == null)
            {
                newHead = newNode;
                tempNewHead = newNode;
            }
            else{
                tempNewHead.next = newNode;
                tempNewHead = newNode;
            }
            temp = temp.next;
        }
        temp = head;
        tempNewHead = newHead;
        while(temp != null)
        {
            Node randomPointer = temp.random;
            if(randomPointer == null)
            {
                tempNewHead.random = null;
            }
            else {
                int index = 0;
                Node moveTempHead = head;
                while(randomPointer != moveTempHead)
                {
                    moveTempHead = moveTempHead.next;
                    index++;
                }
                Node moveTempNewHead = newHead;
                while(index > 0)
                {
                    moveTempNewHead = moveTempNewHead.next;
                    index--;
                }
                tempNewHead.random = moveTempNewHead;

            }
            temp = temp.next;
            tempNewHead = tempNewHead.next;
        }
        return newHead;
    }
}
