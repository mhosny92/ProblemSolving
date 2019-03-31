package geeksforgeeks.amazon.assessment.cities;

public class Pair<T extends Integer, K extends Number> implements Comparable<Pair> {

    private T key;
    private K value;

    public Pair(T key, K value) {
        this.key = key;
        this.value = value;
    }


    public T getKey() {
        return key;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.value.doubleValue() == p.value.doubleValue())
            return 0;
        else if (this.value.doubleValue() > p.value.doubleValue())
            return 1;
        else return -1;
    }
}
