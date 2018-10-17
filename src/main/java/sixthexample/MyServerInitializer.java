package sixthexample;

import com.google.protobuf.MessageLite;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public  class  MyServerInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
//		ch.pipeline().addLast(new ProtobufDecoder((MessageLite) Class.forName("").newInstance()));
		ch.pipeline().addLast(new ProtobufDecoder(DataInfo.MyMessage.getDefaultInstance()));
		ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
		ch.pipeline().addLast(new ProtobufEncoder());
		ch.pipeline().addLast(new MyServerHandler());
		
	}

}
