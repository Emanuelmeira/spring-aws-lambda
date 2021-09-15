package com.example.aws.lambda.function;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class PrintSimpleText implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String s, Context context) {
        System.out.println(context);
        System.out.println(s);
        return "ok!";
    }
}
