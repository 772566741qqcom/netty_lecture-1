package com.example.tutorial.grpc;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import com.example.tutorial.grpc.GrpcStudent.MyRequest;
import com.example.tutorial.grpc.GrpcStudent.MyResponse;
import com.example.tutorial.grpc.GrpcStudent.StudentAge;
import com.example.tutorial.grpc.GrpcStudent.StudentInfo;
import com.example.tutorial.grpc.GrpcStudent.StudentResponseList;
import com.example.tutorial.grpc.StudentServiceGrpc.StudentServiceBlockingStub;
import com.example.tutorial.grpc.StudentServiceGrpc.StudentServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.StreamObservers;

public class GrpcClient {
	private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());
	
	public static void main(String[] args) throws InterruptedException {
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
			StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(channel);
			MyResponse realNameByUserName = blockingStub
					.getRealNameByUserName(MyRequest
							.newBuilder()
							.setUsername("cf")
							.build());
			System.out.println(realNameByUserName.getRealname());
			logger.info(realNameByUserName.getRealname());
			System.out.println("---------------------");
			Iterator<StudentInfo> studentByAge = blockingStub
					.getStudentByAge(StudentAge
							.newBuilder()
							.setAge(20)
							.build());
			int t=0;
			while(studentByAge.hasNext()) {
				StudentInfo next = studentByAge.next();
				System.out.println(next.getName()+" "+next.getAge()+" "+next.getAddress());
				if(t==0)
				Thread.sleep(6000);
				t++;
			}
			
			
			System.out.println("-------------客户端发送stream流数据");
			StreamObserver<StudentResponseList> streamObserver = new StreamObserver<StudentResponseList>() {

				@Override
				public void onNext(StudentResponseList value) {
					List<StudentInfo> studentInfoList = value.getStudentInfoList();
					for(StudentInfo info:studentInfoList) {
						System.out.println(info.getName()+","+info.getAge()+","+info.getAddress());
					}
					
				}

				@Override
				public void onError(Throwable t) {
					System.out.println(t.getMessage());
					
				}

				@Override
				public void onCompleted() {
					
					System.out.println("completed!");
				}
			};
			StudentServiceStub newStub = StudentServiceGrpc.newStub(channel);
			StreamObserver<StudentAge> studentWrapperByAge = newStub.getStudentWrapperByAge(streamObserver);
			studentWrapperByAge.onNext(StudentAge.newBuilder().setAge(10).build());
			studentWrapperByAge.onNext(StudentAge.newBuilder().setAge(20).build());
			studentWrapperByAge.onNext(StudentAge.newBuilder().setAge(30).build());
			studentWrapperByAge.onCompleted();
			Thread.sleep(5000);
			channel.shutdown();
		
		
	}
	
}
