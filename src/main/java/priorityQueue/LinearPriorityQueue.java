package priorityQueue;


import linkedList.Link;

public class LinearPriorityQueue implements LinearPriorityQueueProcessor{
    private Link first;
    private Link last;

    private int size;

    public LinearPriorityQueue(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(int value){
        Link node = new Link(value, null, null);
        if (size == 0){
            first = node;
            last = node;
        }else {
            Link p = first;
            while (p.getData() <= value){
                p = p.getNext();
                if (p==null) break;
            }

            if (p == null){
                last.setNext(node);
                node.setPrev(last);
                last = node;
            } else {
                node.setPrev(p.getPrev());
                node.setNext(p);
                if (p.getPrev() == null) first = node;
                else p.getPrev().setNext(node);
                p.setPrev(node);
            }
        }

        size++;
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            return 0;
        }
        Link temp = first;
        first = first.getNext();
        if (first != null) {
            first.setPrev(null);
        } else {
            last = null;
        }
        size--;
        return temp.getData();

    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Link curr = first;
        while (curr != null) {
            int data = curr.getData();
            sb.append(data);
            if (curr!=last) sb.append(", ");
            curr = curr.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
