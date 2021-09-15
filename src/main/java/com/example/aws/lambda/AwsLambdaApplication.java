package com.example.aws.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.example.aws.lambda.function.PrintSQSMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class AwsLambdaApplication implements ApplicationContextInitializer<GenericApplicationContext> {

	@Override
	public void initialize(GenericApplicationContext context) {

		context.registerBean("printSQSMessage", FunctionRegistration.class,
					() -> new FunctionRegistration<RequestHandler<SQSEvent, String>>(new PrintSQSMessage())
							.type(FunctionType.from(SQSEvent.class).to(String.class)
									.getType()));

	}

	public static void main(String[] args) {
		SpringApplication.run(AwsLambdaApplication.class, args);
	}
}
