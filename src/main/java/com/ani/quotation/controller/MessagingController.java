package com.ani.quotation.controller;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping(value = "/msg")
@RestController
public class MessagingController {
    private final String url = ""; // // never never commit urls to VCS

    @Autowired
    private AmazonSQS sqs;

    @GetMapping
    public String read() {
        final var sb = new StringBuilder();
        final var messages = sqs.receiveMessage(url).getMessages();
        sb.append("messages -> ").append(messages.size());
        if (messages.size() > 0) messages.forEach(msg -> sb.append(msg.toString()));
        sb.append("end");
        return sb.toString();
    }

    @GetMapping("/{bdy}") // you should use @PostMapping here along with @RequestBody
    public String post(@PathVariable String bdy) {
        final var attrs = new HashMap<String, MessageAttributeValue>();
        attrs.put(
                "myNm", new MessageAttributeValue()
                .withStringValue("android")
                .withDataType("String")
        );

        final var req = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(bdy)
                .withMessageAttributes(attrs)
                .withDelaySeconds(0);
        final var res = sqs.sendMessage(req);
        return res.getMessageId();
    }
}
