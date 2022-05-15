package filesystem;

import java.util.List;

public class NodeIterator implements Iterator {
    private List<Node> fs;
    private int iteratorState;


    NodeIterator(List<Node> fs) {
        this.fs = fs;
        this.iteratorState = 0;
    }

    public Node getNext() {
        if (this.hasMore()) {
            iteratorState++;
            return this.fs.get(iteratorState - 1);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public boolean hasMore() {
        return !(this.fs.size() == this.iteratorState);
    }
}
