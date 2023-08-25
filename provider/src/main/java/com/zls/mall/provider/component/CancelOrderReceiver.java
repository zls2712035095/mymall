package com.zls.mall.provider.component;

import com.zls.mall.api.service.IOrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {

    @Autowired
    private IOrderService orderService;

    @RabbitHandler
    public void handler(Long orderId){
        orderService.cancelOrder(orderId);
    }
}
