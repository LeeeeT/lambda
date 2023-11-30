package cst;

public class Identifier implements StrippedTerm {
    public char head;
    public Identifier tail;

    public Identifier(char head, Identifier tail) {
        this.head = head;
        this.tail = tail;
    }

    public String toString() {
        return head + (tail == null ? "" : tail.toString());
    }
}