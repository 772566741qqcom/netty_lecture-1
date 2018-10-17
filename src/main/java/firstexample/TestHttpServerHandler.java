package firstexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
		System.out.println(msg.getClass());
		System.out.println(ctx.channel().remoteAddress());
		if(msg instanceof HttpRequest) {
			HttpRequest httpRequest=(HttpRequest) msg;
			System.out.println("请求方法名："+httpRequest.method().name()+" uri:"+httpRequest.uri()
			+" version:"+httpRequest.protocolVersion().toString()
			+" header:"+httpRequest.headers());
			ByteBuf content=Unpooled.copiedBuffer("hello world",CharsetUtil.UTF_8);
			FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);
			response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
			response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
			ctx.writeAndFlush(response);
			ctx.channel().close();
		}
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelRegistered");
		super.channelRegistered(ctx);
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelUnregistered");
		super.channelUnregistered(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelActive");
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelInactive");
		super.channelInactive(ctx);
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		System.out.println("handlerAdded");
		super.handlerAdded(ctx);
	}
	
	
	


}
