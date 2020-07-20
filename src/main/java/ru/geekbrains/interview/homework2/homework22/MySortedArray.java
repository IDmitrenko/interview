package ru.geekbrains.interview.homework2.homework22;

public class MySortedArray<T extends Comparable> extends MyArray<T> {

    @Override
    public void add(T item) {
        int i = 0;
        while (i < this.getCardinality() && item.compareTo(get(i)) >= 0) {
            i++;
        }
        super.add(i, item);
    }

    public void add(int index, T item) {
        add(item);
    }

    public boolean binarySearch(T item) {
        int lo = 0;
        int hi = getCardinality() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (item.compareTo(get(mid)) < 0) {
                hi = mid - 1;
            } else if (item.compareTo(get(mid)) > 0) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
