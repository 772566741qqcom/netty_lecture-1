package com.example.tutorial.grpc;

import com.example.tutorial.grpc.GrpcStudent.MyRequest;
import com.example.tutorial.grpc.GrpcStudent.MyResponse;
import com.example.tutorial.grpc.GrpcStudent.StudentAge;
import com.example.tutorial.grpc.GrpcStudent.StudentInfo;
import com.example.tutorial.grpc.GrpcStudent.StudentResponseList;

import io.grpc.stub.StreamObserver;

public class StudentServiceGrpcImpl extends StudentServiceGrpc.StudentServiceImplBase {

	@Override
	public void getRealNameByUserName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
		System.out.println(request.getUsername());
		responseObserver.onNext(MyResponse.newBuilder().setRealname("chenfeng").build());
		responseObserver.onCompleted();
	}

	@Override
	public void getStudentByAge(StudentAge request, StreamObserver<StudentInfo> responseObserver) {
		System.out.println("-----服务端接收到的数据："+request.getAge());
		responseObserver.onNext(StudentInfo
				.newBuilder()
				.setName("cf")
				.setAge(28)
				.setAddress("hz")
				.build());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		responseObserver.onNext(StudentInfo
				.newBuilder()
				.setName("cj")
				.setAge(28)
				.setAddress("nc")
				.build());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		responseObserver.onNext(StudentInfo
				.newBuilder()
				.setName("czh")
				.setAge(28)
				.setAddress("nc")
				.build());
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<StudentAge> getStudentWrapperByAge(StreamObserver<StudentResponseList> responseObserver) {
		System.out.println("-----3、客户端流式数据发送-----");
		return new StreamObserver<StudentAge>() {

			@Override
			public void onNext(StudentAge value) {
				System.out.println(value.getAge());
				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println(t.getMessage());
				
			}

			@Override
			public void onCompleted() {
				StudentResponseList responseList=StudentResponseList
						.newBuilder().addStudentInfo(StudentInfo.newBuilder().setName("cf").setAge(28).setAddress("hz").build())
						.addStudentInfo(StudentInfo.newBuilder().setName("cj").setAge(28).setAddress("nc").build())
						.addStudentInfo(StudentInfo.newBuilder().setName("czh").setAge(2).setAddress("nc").build())
						.build();
				responseObserver.onNext(responseList);
				responseObserver.onCompleted();
			}
			
		};
	}

	
	
}
