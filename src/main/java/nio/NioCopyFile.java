package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioCopyFile {

	public static void main(String[] args) throws Exception {
		FileInputStream fin=new FileInputStream("src/main/java/nio/sourcefile.txt");
		FileOutputStream fout=new FileOutputStream("src/main/java/nio/copyfile.txt");
		FileChannel finchannel = fin.getChannel();
		FileChannel foutchannel = fout.getChannel();
		ByteBuffer channelbuffer=ByteBuffer.allocate(10);
		while(true) {
			channelbuffer.clear();
			int read = finchannel.read(channelbuffer);
			if(read==-1) {
				break;
			}
			channelbuffer.flip();
			foutchannel.write(channelbuffer);
		}
		fin.close();
		fout.close();
	}
}
