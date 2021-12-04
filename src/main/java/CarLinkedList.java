public class CarLinkedList implements CarList {

    int size = 0;
    private Node firts;
    private Node last;

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            Node node = new Node(null, car, null);
            firts = node;
            last = node;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(Car car, int index) {
        if (index == size) {
            add(car);
            return;
        } else {
            Node nodeNext = getNode(index);
            Node nodePrevious = nodeNext.previous;
            Node newNode = new Node(nodePrevious, car, nodeNext);
            nodeNext.previous = newNode;

            if (nodePrevious != null) {
                nodePrevious.next = newNode;
            } else firts = newNode;
        }
        size++;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodePrevious = node.previous;
        Node nodeNext = node.next;

        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            firts = nodeNext;
        }

        if (nodeNext != null) {
            nodeNext.previous = nodeNext;
        } else last = nodePrevious;

        size--;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        Node node = firts;
        for (int i = 0; i < size; i++) {
            if (car.equals(node.value)) {
                return removeAt(i);
            } else node = node.next;
        }

        return false;
    }

    @Override
    public void clear() {
        size = 0;
        firts = null;
        last = null;
    }

    private Node getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = firts;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
