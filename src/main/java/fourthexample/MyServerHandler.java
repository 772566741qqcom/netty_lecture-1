package fourthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class MyServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if(evt instanceof IdleStateEvent) {
			IdleStateEvent event=(IdleStateEvent) evt;
			String type=null;
			switch(event.state()) {
			case READER_IDLE:
				type="读空闲";
				break;
			case WRITER_IDLE:
				type="写空闲";
				break;
			case ALL_IDLE:
				type="读写空闲";
				break;
			default:
				type="什么鬼";
			}
			System.out.println(type);
			ctx.channel().close();
		}
	}
}
