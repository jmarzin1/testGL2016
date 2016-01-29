package td3;

public interface IBuffer {

    void insert(String s, int position);

    void delete(int from, int to);

    String substring(int from, int to);

    String toString();

    int maxPosition();

}
