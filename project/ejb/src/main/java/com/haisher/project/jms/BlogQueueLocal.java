package com.haisher.project.jms;

import javax.ejb.Local;

@Local
public interface BlogQueueLocal {

	public void sendMessage(String msg);

}
