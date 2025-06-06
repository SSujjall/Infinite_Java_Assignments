package Testings;

public class MyGenericModel<T>{
    private T item;

    public MyGenericModel(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
