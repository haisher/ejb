package com.haisher.project.timer;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Local;

@Local
public interface TimerServiceLocal {

	public void scheduleExecution(Date timeout, Serializable parameter);
}
