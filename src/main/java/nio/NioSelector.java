package nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class NioSelector {

	public static void main(String[] args) throws Exception {
		int[] port= {5000,5001,5002,5003,5004};
		Selector selector = Selector.open();
		for(int i=0;i<port.length;i++) {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			ServerSocket serverSocket = serverSocketChannel.socket();
			serverSocket.bind(new InetSocketAddress(port[i]));
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("监听端口："+port[i]);
		}
		
		while(true) {
			int number = selector.select();
			System.out.println("连接数："+number);
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			System.out.println("selectedKeys:"+selectedKeys);
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			while(iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				if(selectionKey.isAcceptable()) {
					ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
					SocketChannel socketChannel = channel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
					iterator.remove();
					System.out.println("获得客户端连接："+socketChannel);
				}else if (selectionKey.isReadable()) {
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					int bytesRead=0;
					while(true) {
						ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
						byteBuffer.clear();
						int read = socketChannel.read(byteBuffer);
						if(read<=0) {
							break;
						}
						byteBuffer.flip();
						socketChannel.write(byteBuffer);
						bytesRead+=read;
					}
					System.out.println("读取到的数据长度："+bytesRead);
					iterator.remove();
				}
			}
		}
	}
}
