package PR.lab2.client.common;

public interface Connection {
    public static final int Port = 8989;

    public void Send(Message msg);
    public void close();
}
