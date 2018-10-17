package nio;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class ZeroCopyClient {

	public static void main(String[] args) throws Exception {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("127.0.0.1",8898));
		socketChannel.configureBlocking(true);
		
		FileInputStream fin=new FileInputStream("E:\\software\\工作\\MQ7(windows).rar");
		FileChannel channel = fin.getChannel();
		long starttime = System.currentTimeMillis();
		long position=0;
		long size=channel.size();
		while(position<size) {
			position+=channel.transferTo(position, channel.size(), socketChannel);
		}
		
		System.out.println("发送总字节数："+channel.size()+" 耗时："+(System.currentTimeMillis()-starttime));
		fin.close();
		channel.close();
		socketChannel.close();
	}
}
