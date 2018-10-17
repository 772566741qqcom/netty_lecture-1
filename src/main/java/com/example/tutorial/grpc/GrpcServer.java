package com.example.tutorial.grpc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

	private Server server;
	private static final Logger logger=Logger.getLogger(GrpcServer.class.getName());
	private void start() throws IOException {
		int port = 50051;
		server=ServerBuilder.forPort(port).addService(new StudentServiceGrpcImpl()).build().start();
		logger.info("server start,listening on "+port);
		Runtime.getRuntime().addShutdownHook(new Thread(()-> {
			System.out.println("在grpc服务关闭前调用的方法");
			this.stop();
		}));
		System.out.println("运行到这里");
	}
	
	private void stop() {
		if(server!=null) {
			server.shutdown();
		}
	}
	private void awaitTerminal() throws InterruptedException {
		if(server!=null) {
			server.awaitTermination();
		}
	}
	
	public static void main(String[] args) throws Exception {
		GrpcServer grpcServer=new GrpcServer();
		grpcServer.start();
		grpcServer.awaitTerminal();
	}
}
