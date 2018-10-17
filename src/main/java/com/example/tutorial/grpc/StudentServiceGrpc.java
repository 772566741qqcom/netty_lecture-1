package com.example.tutorial.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: GrpcStudent.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.tutorial.grpc.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.tutorial.grpc.GrpcStudent.MyRequest,
      com.example.tutorial.grpc.GrpcStudent.MyResponse> getGetRealNameByUserNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNameByUserName",
      requestType = com.example.tutorial.grpc.GrpcStudent.MyRequest.class,
      responseType = com.example.tutorial.grpc.GrpcStudent.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.tutorial.grpc.GrpcStudent.MyRequest,
      com.example.tutorial.grpc.GrpcStudent.MyResponse> getGetRealNameByUserNameMethod() {
    io.grpc.MethodDescriptor<com.example.tutorial.grpc.GrpcStudent.MyRequest, com.example.tutorial.grpc.GrpcStudent.MyResponse> getGetRealNameByUserNameMethod;
    if ((getGetRealNameByUserNameMethod = StudentServiceGrpc.getGetRealNameByUserNameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUserNameMethod = StudentServiceGrpc.getGetRealNameByUserNameMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUserNameMethod = getGetRealNameByUserNameMethod = 
              io.grpc.MethodDescriptor.<com.example.tutorial.grpc.GrpcStudent.MyRequest, com.example.tutorial.grpc.GrpcStudent.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.example.tutorial.grpc.StudentService", "GetRealNameByUserName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tutorial.grpc.GrpcStudent.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tutorial.grpc.GrpcStudent.MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetRealNameByUserName"))
                  .build();
          }
        }
     }
     return getGetRealNameByUserNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.tutorial.grpc.GrpcStudent.StudentAge,
      com.example.tutorial.grpc.GrpcStudent.StudentInfo> getGetStudentByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentByAge",
      requestType = com.example.tutorial.grpc.GrpcStudent.StudentAge.class,
      responseType = com.example.tutorial.grpc.GrpcStudent.StudentInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.tutorial.grpc.GrpcStudent.StudentAge,
      com.example.tutorial.grpc.GrpcStudent.StudentInfo> getGetStudentByAgeMethod() {
    io.grpc.MethodDescriptor<com.example.tutorial.grpc.GrpcStudent.StudentAge, com.example.tutorial.grpc.GrpcStudent.StudentInfo> getGetStudentByAgeMethod;
    if ((getGetStudentByAgeMethod = StudentServiceGrpc.getGetStudentByAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentByAgeMethod = StudentServiceGrpc.getGetStudentByAgeMethod) == null) {
          StudentServiceGrpc.getGetStudentByAgeMethod = getGetStudentByAgeMethod = 
              io.grpc.MethodDescriptor.<com.example.tutorial.grpc.GrpcStudent.StudentAge, com.example.tutorial.grpc.GrpcStudent.StudentInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.example.tutorial.grpc.StudentService", "GetStudentByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tutorial.grpc.GrpcStudent.StudentAge.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tutorial.grpc.GrpcStudent.StudentInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentByAge"))
                  .build();
          }
        }
     }
     return getGetStudentByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.tutorial.grpc.GrpcStudent.StudentAge,
      com.example.tutorial.grpc.GrpcStudent.StudentResponseList> getGetStudentWrapperByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentWrapperByAge",
      requestType = com.example.tutorial.grpc.GrpcStudent.StudentAge.class,
      responseType = com.example.tutorial.grpc.GrpcStudent.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.tutorial.grpc.GrpcStudent.StudentAge,
      com.example.tutorial.grpc.GrpcStudent.StudentResponseList> getGetStudentWrapperByAgeMethod() {
    io.grpc.MethodDescriptor<com.example.tutorial.grpc.GrpcStudent.StudentAge, com.example.tutorial.grpc.GrpcStudent.StudentResponseList> getGetStudentWrapperByAgeMethod;
    if ((getGetStudentWrapperByAgeMethod = StudentServiceGrpc.getGetStudentWrapperByAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentWrapperByAgeMethod = StudentServiceGrpc.getGetStudentWrapperByAgeMethod) == null) {
          StudentServiceGrpc.getGetStudentWrapperByAgeMethod = getGetStudentWrapperByAgeMethod = 
              io.grpc.MethodDescriptor.<com.example.tutorial.grpc.GrpcStudent.StudentAge, com.example.tutorial.grpc.GrpcStudent.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.example.tutorial.grpc.StudentService", "GetStudentWrapperByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tutorial.grpc.GrpcStudent.StudentAge.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.tutorial.grpc.GrpcStudent.StudentResponseList.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentWrapperByAge"))
                  .build();
          }
        }
     }
     return getGetStudentWrapperByAgeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    return new StudentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUserName(com.example.tutorial.grpc.GrpcStudent.MyRequest request,
        io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUserNameMethod(), responseObserver);
    }

    /**
     */
    public void getStudentByAge(com.example.tutorial.grpc.GrpcStudent.StudentAge request,
        io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.StudentInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentByAgeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.StudentAge> getStudentWrapperByAge(
        io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentWrapperByAgeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUserNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.tutorial.grpc.GrpcStudent.MyRequest,
                com.example.tutorial.grpc.GrpcStudent.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USER_NAME)))
          .addMethod(
            getGetStudentByAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.tutorial.grpc.GrpcStudent.StudentAge,
                com.example.tutorial.grpc.GrpcStudent.StudentInfo>(
                  this, METHODID_GET_STUDENT_BY_AGE)))
          .addMethod(
            getGetStudentWrapperByAgeMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.example.tutorial.grpc.GrpcStudent.StudentAge,
                com.example.tutorial.grpc.GrpcStudent.StudentResponseList>(
                  this, METHODID_GET_STUDENT_WRAPPER_BY_AGE)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractStub<StudentServiceStub> {
    private StudentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUserName(com.example.tutorial.grpc.GrpcStudent.MyRequest request,
        io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentByAge(com.example.tutorial.grpc.GrpcStudent.StudentAge request,
        io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.StudentInfo> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.StudentAge> getStudentWrapperByAge(
        io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentWrapperByAgeMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.tutorial.grpc.GrpcStudent.MyResponse getRealNameByUserName(com.example.tutorial.grpc.GrpcStudent.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUserNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.tutorial.grpc.GrpcStudent.StudentInfo> getStudentByAge(
        com.example.tutorial.grpc.GrpcStudent.StudentAge request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.tutorial.grpc.GrpcStudent.MyResponse> getRealNameByUserName(
        com.example.tutorial.grpc.GrpcStudent.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USER_NAME = 0;
  private static final int METHODID_GET_STUDENT_BY_AGE = 1;
  private static final int METHODID_GET_STUDENT_WRAPPER_BY_AGE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USER_NAME:
          serviceImpl.getRealNameByUserName((com.example.tutorial.grpc.GrpcStudent.MyRequest) request,
              (io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENT_BY_AGE:
          serviceImpl.getStudentByAge((com.example.tutorial.grpc.GrpcStudent.StudentAge) request,
              (io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.StudentInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_WRAPPER_BY_AGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentWrapperByAge(
              (io.grpc.stub.StreamObserver<com.example.tutorial.grpc.GrpcStudent.StudentResponseList>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.tutorial.grpc.GrpcStudent.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUserNameMethod())
              .addMethod(getGetStudentByAgeMethod())
              .addMethod(getGetStudentWrapperByAgeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
