package cst;

public class Whitespaces {
    public char head;
    public Whitespaces tail;

    public Whitespaces(char head, Whitespaces tail) {
        this.head = head;
        this.tail = tail;
    }

    public String toString() {
        return head + (tail == null ? "" : tail.toString());
    }
}