package fifthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketInitialzer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(new HttpServerCodec());
		ch.pipeline().addLast(new ChunkedWriteHandler());
		ch.pipeline().addLast(new HttpObjectAggregator(8192));
		ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));  //建立websocket连接
		ch.pipeline().addLast(new WebSocketHandler());
	}

}
