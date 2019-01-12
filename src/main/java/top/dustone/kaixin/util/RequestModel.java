package top.dustone.kaixin.util;

public class RequestModel<T>{
    private T example;
    private int start;
    private int pageSize=10;
    private int navigatorSize;

    public T getExample() {
        return example;
    }

    public void setExample(T example) {
        this.example = example;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNavigatorSize() {
        return navigatorSize;
    }

    public void setNavigatorSize(int navigatorSize) {
        this.navigatorSize = navigatorSize;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "example=" + example +
                ", start=" + start +
                ", pageSize=" + pageSize +
                ", navigatorSize=" + navigatorSize +
                '}';
    }
}
