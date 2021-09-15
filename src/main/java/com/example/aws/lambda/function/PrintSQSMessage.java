package com.example.aws.lambda.function;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

public class PrintSQSMessage implements RequestHandler<SQSEvent, String> {

    @Override
    public String handleRequest(SQSEvent event, Context context) {
        System.out.println("Contexto: "+ context);

        for(SQSMessage msg : event.getRecords()){
            System.out.println("Mensagem: "+ msg);
            System.out.println("Texto: "+ msg.getBody());
        }

        return "ok!";
    }

}
