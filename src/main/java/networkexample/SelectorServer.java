/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:22 上午 2022/7/1
 **/


package networkexample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * nio基础上的多路复用 的服务端 案例
 */
public class SelectorServer {

    public static Selector selector = null;

    public static void main(String[] args) {

        // Nio要配合着 Channel Buffer Selector使用
        try {
            selector = Selector.open();

            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            //设置为非阻塞
            socketChannel.configureBlocking(false);
            socketChannel.socket().bind(new InetSocketAddress(8080));

            socketChannel.register(selector, SelectionKey.OP_ACCEPT);//把链接事件注册到多路复用器上
            while (true) {
                selector.select();//阻塞机制，只有事件到达，它才会被唤醒
                Set<SelectionKey> selectionKeys = selector.selectedKeys();//执行到它，证明有事件过来了
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {//是一个链接事件{
                        handleAccept(key);
                    } else if (key.isReadable()) {  //是一个读的就绪事件
                        handleRead(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleAccept(SelectionKey selectionKey) {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();//一定会有一个链接
            socketChannel.configureBlocking(false);//设置成非阻塞
            socketChannel.write(ByteBuffer.wrap("Hello Client,I am NIO SERVER".getBytes()));
            socketChannel.register(selector, SelectionKey.OP_READ);//注册读事件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRead(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            socketChannel.read(byteBuffer);//这里一定有值
            System.out.println("Server reveive msg:" + new String(byteBuffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
