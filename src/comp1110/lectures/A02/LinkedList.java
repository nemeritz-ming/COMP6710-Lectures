package comp1110.lectures.A02;

public class LinkedList<T> implements List<T> {

    LLN first;
    LLN last;
    int elements;

    class LLN {
        T value;
        LLN next;

        public LLN(T value, LLN next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            // return value + (next != null ? " " + next : "");

            String rtn = ""+value;
            if (next != null)
                rtn += " "+next;
            return rtn;
        }
    }

    @Override
    public void add(T value) {
        LLN lln = new LLN(value, null);
        if (first == null) {
            first = last = lln;
        } else {
            last.next = lln;
            last = lln;
        }
        elements++;
    }

    @Override
    public T remove(int index) {
        T rtn;
        if (index == 0) {
            rtn = first.value;
            first = first.next;
            if (first == null) // removed only element in list
                last = null;
        } else {
            LLN prior = getLLN(first, index - 1);
            LLN target = prior.next;
            rtn = target.value;
            prior.next = target.next;
            if (prior.next == null)
                last = null;
        }

        elements--;
        return rtn;
    }

    @Override
    public int size() {
        return elements;
    }

    private LLN getLLN(LLN start, int index) {
        if (index == 0)
            return start;
        else
            return getLLN(start.next, index -1);
    }

    @Override
    public T get(int index) {
        return getLLN(first, index).value;
    }

    @Override
    public void reverse() {

    }

    @Override
    public String toString() {
        if (first == null)
            return "";
        return ""+first;
    }
}
