package com.example.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;


public class PrintSQSMessageHandler extends SpringBootRequestHandler<SQSEvent, String> {

}
