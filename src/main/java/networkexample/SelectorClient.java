/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:37 上午 2022/7/1
 **/


package networkexample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * nio基础上的多路复用 的客户端 案例
 */
public class SelectorClient {

    static Selector selector;

    public static void main(String[] args) {
        try {
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            //设置为非阻塞。
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8080));
            //这段代码并不意味着连接已经建立好了
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isConnectable()) {//连接事件
                        handleConnect(key);
                    } else if (key.isReadable()) {
                        handleRead(key);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleConnect(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        if (channel.isConnectionPending()) {
            //

            channel.finishConnect();
        }
        channel.configureBlocking(false);//设置成非阻塞
        channel.write(ByteBuffer.wrap("Hello Server,I am Nio client".getBytes()));
        channel.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        System.out.println("client receive msg:" + new String(byteBuffer.array()));
    }
}
