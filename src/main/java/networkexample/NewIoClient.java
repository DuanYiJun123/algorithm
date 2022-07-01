/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:45 上午 2022/7/1
 **/


package networkexample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * NIO的客户端的演示例子
 */
public class NewIoClient {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            //设置为非阻塞。这里设置为非阻塞，会导致客户端尝试连接之后即返回
            //socketChannel.configureBlocking(false);
            //这段代码并不意味着连接已经建立好了
            socketChannel.connect(new InetSocketAddress("localhost", 8080));
            if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();
            }
            //nio需要搭配缓冲区使用
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("Hello,I'm SocketChannel Client".getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);

            //读取服务端返回的数据
            byteBuffer.clear();
            int i = socketChannel.read(byteBuffer);
            if (i > 0) {
                System.out.println("收到了服务端的数据" + new String(byteBuffer.array()));
            } else {
                //在阻塞Io中不需要考虑数据为空的情况，但是非阻塞的需要考虑
                System.out.println("没有收到数据");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
