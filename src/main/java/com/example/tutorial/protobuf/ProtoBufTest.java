package com.example.tutorial.protobuf;

import com.example.tutorial.protobuf.DataInfo.Student;
import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {

	public static void main(String[] args) throws InvalidProtocolBufferException {
		Student student = DataInfo.Student.newBuilder()
				.setAdress("江西南昌")
				.setAge(28)
				.setName("cf")
				.build();
		byte[] byteArray = student.toByteArray();
		Student parseFromstudent = DataInfo.Student.parseFrom(byteArray);
		System.out.println(parseFromstudent.getAdress());
		System.out.println(parseFromstudent.getAge());
		System.out.println(parseFromstudent.getName());
	}
}
