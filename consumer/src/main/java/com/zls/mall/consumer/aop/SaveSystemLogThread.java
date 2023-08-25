package com.zls.mall.consumer.aop;

import com.zls.mall.api.model.UmsLog;
import com.zls.mall.api.service.IUserLogService;

public class SaveSystemLogThread implements Runnable{

    private UmsLog umsLog;

    private IUserLogService service;
    public SaveSystemLogThread(UmsLog umsLog, IUserLogService service){
        this.umsLog = umsLog;
        this.service = service;
    }

    @Override
    public void run() {
        if(umsLog.getLogType() != null){
            this.service.insert(umsLog);
        }
    }
}
