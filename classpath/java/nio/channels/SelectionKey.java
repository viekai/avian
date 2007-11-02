package java.nio.channels;

public class SelectionKey {
  public static final int OP_READ = 1 << 0;
  public static final int OP_WRITE = 1 << 2;
  public static final int OP_ACCEPT = 1 << 4;
//   public static final int OP_CONNECT = 1 << 3;

  private final SelectableChannel channel;
  private final Selector selector;
  private int interestOps;
  private int readyOps;
  private final Object attachment;

  public SelectionKey(SelectableChannel channel, Selector selector,
                      int interestOps, Object attachment)
  {
    this.channel = channel;
    this.selector = selector;
    this.interestOps = interestOps;
    this.attachment = attachment;
    this.readyOps = 0;
  }

  public int interestOps() {
    return interestOps;
  }

  public void interestOps(int v) {
    this.interestOps = v;
  }

  public int readyOps() {
    return readyOps;
  }

  public void readyOps(int v) {
    this.readyOps = v;
  }

  public boolean isReadable() {
    return (readyOps & OP_READ) != 0;
  }

  public boolean isWritable() {
    return (readyOps & OP_WRITE) != 0;
  }

  public boolean isAcceptable() {
    return (readyOps & OP_ACCEPT) != 0;
  }

  public boolean isValid() {
    return channel.isOpen() && selector.isOpen();
  }

  public SelectableChannel channel() {
    return channel;
  }

  public Selector selector() {
    return selector;
  }

  public Object attachment() {
    return attachment;
  }
}