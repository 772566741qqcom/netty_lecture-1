package nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {

	public static void main(String[] args) throws Exception {
		FileOutputStream fin=new FileOutputStream("src/main/java/nio/Niotest.txt");
		FileChannel channel = fin.getChannel();
		byte[] bytes = "hello world!!!!!!!!!!".getBytes();
		ByteBuffer buffer=ByteBuffer.allocate(10);
		buffer.put(bytes);
		/*for(int i=0;i<bytes.length;i++) {
			buffer.put(bytes[i]);
		}*/
		buffer.flip();
		channel.write(buffer);
		fin.close();
	}
}
