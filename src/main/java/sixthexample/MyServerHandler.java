package sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyServerHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {
		System.out.println("进入server");
		if(msg.getDataType()==DataInfo.MyMessage.DataType.PersonType) {
			System.out.println("person类");
			System.out.println(msg.getPerson().getName());
			System.out.println(msg.getPerson().getAdress());
		}else if(msg.getDataType()==DataInfo.MyMessage.DataType.StudentType) {
			System.out.println("student类");
			System.out.println(msg.getStudent().getName());
			System.out.println(msg.getStudent().getStudentNum());
		}else {
			System.out.println("teacher类");
			System.out.println(msg.getTeacher().getName());
			System.out.println(msg.getTeacher().getTeacherNum());
		}
		
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.channel().close();
	}


}
