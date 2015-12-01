package com.haisher.project.timer;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class TimerServiceImpl implements TimerServiceLocal {

	@Resource
	private SessionContext ctx;

	@Override
	public void scheduleExecution(Date timeout, Serializable parameter) {
		TimerService timerService = ctx.getTimerService();
		timerService.createTimer(timeout, parameter);
	}

	@Timeout
	public void executarTimer(Timer timer) {
		System.out.println("Timer message: " + timer.getInfo());

		timer.cancel();
	}

}
