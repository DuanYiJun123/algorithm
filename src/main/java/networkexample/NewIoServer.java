/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:50 上午 2022/7/1
 **/


package networkexample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO的服务端的演示例子
 */
public class NewIoServer {

    public static void main(String[] args) {

        // Nio要配合着 Channel Buffer Selector使用
        try {
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            //设置为非阻塞
            socketChannel.configureBlocking(false);
            socketChannel.socket().bind(new InetSocketAddress(8080));
            while (true) {
                SocketChannel accept = socketChannel.accept();
                if (accept != null) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    accept.read(byteBuffer);//把数据读到缓冲区
                    System.out.println(new String(byteBuffer.array()));//读取
                    //写出数据
                    byteBuffer.flip();
                    accept.write(byteBuffer);//写出去
                } else {
                    Thread.sleep(1000);
                    System.out.println("连接未就绪");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
