package sixthexample;

import java.util.Random;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import sixthexample.DataInfo.MyMessage;

public class MyClientHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, MyMessage msg) throws Exception {
		
		
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		/*Person person = DataInfo.Person.newBuilder().setName("chenfeng")
		.setAge(28)
		.setAdress("江西").build();
		ctx.channel().writeAndFlush(person);*/
		int i=new Random().nextInt(3);
		DataInfo.MyMessage build=null;
		if(i==0) {
			build = DataInfo.MyMessage.newBuilder().setDataType(DataInfo.MyMessage.DataType.PersonType)
			.setPerson(DataInfo.Person.newBuilder().setName("cf").setAge(28).setAdress("jx").build())
			.build();
		}else if(i==1) {
			build =DataInfo.MyMessage.newBuilder().setDataType(DataInfo.MyMessage.DataType.StudentType)
			.setStudent(DataInfo.Student.newBuilder().setName("cf").setAge(28).setStudentNum("0808060006").build())
			.build();
		}else {
			build =DataInfo.MyMessage.newBuilder().setDataType(DataInfo.MyMessage.DataType.TercherType)
			.setTeacher(DataInfo.Teacher.newBuilder().setName("cf").setAge(28).setTeacherNum("jx").build())
			.build();
		}
		
		ctx.channel().writeAndFlush(build);
	}

}
