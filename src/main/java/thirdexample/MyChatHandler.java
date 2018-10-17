package thirdexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatHandler extends SimpleChannelInboundHandler<String> {

	private static ChannelGroup channelGroup =new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//		System.out.println("========="+msg);
		Channel channel = ctx.channel();
		for(Channel ch:channelGroup) {
			if(ch==channel) {
				ctx.channel().writeAndFlush("[自己]-"+msg);
			}else {
				ch.writeAndFlush(channel.remoteAddress()+" 说："+msg);
			}
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("[服务器]--"+ctx.channel().remoteAddress() +"已上线");
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().remoteAddress() +"加入");
		channelGroup.writeAndFlush(ctx.channel().remoteAddress() +"加入");
		channelGroup.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().remoteAddress() +"离开");
		channelGroup.writeAndFlush(ctx.channel().remoteAddress() +"离开");
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//		cause.printStackTrace();
		ctx.close();
	}

}
