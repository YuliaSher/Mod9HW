import java.util.Arrays;

public class MyArrayList<T extends Object> {
    private T[] arr;

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public T[] add(Object value) {
        int length = size() + 1;
        T[] newArr = Arrays.copyOf(arr, length);
        newArr[length - 1] = (T) value;
        this.arr = newArr;
        return arr;
    }

    public T[] remove(int index) {
        int length = size() - 1;
        T[] newArr = Arrays.copyOf(arr, length);
        int k = 0;
        for (int i = 0; i < length; i++) {
            if (k != index) {
                newArr[i] = arr[k];
            } else {
                i--;
            }
            k++;
        }
        return this.arr = newArr;
    }

    public T[] clear() {
        Object[] newArr = new Object[0];
        this.arr = (T[]) newArr;
        return arr;
    }

    public int size() {
        return arr.length;
    }

    public T get(int index) {
        return arr[index];
    }

    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList();
        numbers.setArr(new Integer[]{3, 57, 2, 7, 3, 79, 3});
        System.out.println("numbers.size() = " + numbers.size());
        System.out.println("numbers.add(66) = " + Arrays.toString(numbers.add(66)));
        System.out.println("numbers.get(5) = " + numbers.get(5));
        System.out.println("numbers.remove(5) = " + Arrays.toString(numbers.remove(5)));
        System.out.println("numbers.clear() = " + Arrays.toString(numbers.clear()));
        System.out.println("numbers.size() = " + numbers.size());
    }

}
