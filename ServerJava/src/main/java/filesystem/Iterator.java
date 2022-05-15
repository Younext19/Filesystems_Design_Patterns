package filesystem;

public interface Iterator {
    Node getNext();
    boolean hasMore();
}
