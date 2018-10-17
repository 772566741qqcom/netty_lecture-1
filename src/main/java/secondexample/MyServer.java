package secondexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyServer {

	public static void main(String[] args) throws Exception {
		EventLoopGroup bossGroup=new NioEventLoopGroup();
		EventLoopGroup workerGroup=new NioEventLoopGroup();
		ServerBootstrap serverBootStrap=new ServerBootstrap();
		serverBootStrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
		.childHandler(new MyServerInitializer());
		try {
			ChannelFuture channelFuture = serverBootStrap.bind(8899).sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
