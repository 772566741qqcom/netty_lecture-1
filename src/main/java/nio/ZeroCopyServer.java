package nio;

import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ZeroCopyServer {

	public static void main(String[] args) throws Exception {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		ServerSocket serversocket = serverSocketChannel.socket();
		serversocket.bind(new InetSocketAddress(8898));
		serversocket.setReuseAddress(true);
		FileOutputStream f=new FileOutputStream("F:\\tmp\\t.rar");
		FileChannel fout=f.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
		while(true) {
			SocketChannel socket = serverSocketChannel.accept();
			socket.configureBlocking(true);
			int readcount=0;
			int t=0;
			while(readcount!=-1) {
				readcount=socket.read(byteBuffer);
				t+=readcount;
				byteBuffer.flip();
				fout.write(byteBuffer);
				byteBuffer.clear();
			}
			System.out.println("读取字节数:"+t);
			fout.close();
			f.close();
			
		}
		
	}
}
