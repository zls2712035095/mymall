package com.zls.mall.api.service;

import com.zls.api.common.CommonPage;
import com.zls.mall.api.dto.OmsOrderQueryParam;
import com.zls.mall.api.model.OmsOrder;

public interface IOrderService {
    public CommonPage list(OmsOrderQueryParam omsOrderQueryParam, Integer pageSize, Integer pageNum);

    OmsOrder detail(Long id);

    void sendDelayMessageCancelOrder(Long aLong, int minute);

    OmsOrder cancelOrder(Long orderId);
}
