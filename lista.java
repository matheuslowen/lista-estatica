public class Lista {
    private int[] data;
    private int size;

    public Lista(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public void clear() {
        size = 0;
    }

    public void add(int value) {
        if (isFull()) {
            throw new IllegalStateException("Lista cheia.");
        }
        data[size++] = value;
    }

    public void add(int value, int pos) {
        if (isFull() || pos < 0 || pos > size) {
            throw new IllegalArgumentException("Operação inválida.");
        }
        System.arraycopy(data, pos, data, pos + 1, size - pos);
        data[pos] = value;
        size++;
    }

    public int remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        int removedValue = data[pos];
        System.arraycopy(data, pos + 1, data, pos, size - pos - 1);
        size--;
        return removedValue;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void setData(int value, int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        data[pos] = value;
    }

    public int getData(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        return data[pos];
    }

    public int getSize() {
        return size;
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
