package com.haisher.project.view.controller;

import java.net.URL;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceFactory;

import com.haisher.project.domain.Record;
import com.haisher.project.jms.BlogQueueLocal;
import com.haisher.project.service.HelloWorldLocal;
import com.haisher.project.service.RecordLocal;
import com.haisher.project.timer.TimerServiceLocal;
import com.haisher.project.webservice.WebServiceInterface;

@RequestScoped
@ManagedBean(name = "helloWorldMB")
public class HelloWorldMB {

	@EJB
	private HelloWorldLocal helloWorldService;

	@EJB
	private RecordLocal recordService;

	@EJB
	private BlogQueueLocal queue;

	@EJB
	private TimerServiceLocal timer;

	private String value;

	public void sayHello() {
		helloWorldService.printConsole(value);
	}

	public void save() {
		Record record = new Record();
		record.setValue(value);

		recordService.save(record);
	}

	public void publish() {
		queue.sendMessage(value);
	}

	public void schedule() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 1);

		timer.scheduleExecution(calendar.getTime(), value);
	}

	public void invokeWebService() {
		String wsdlUrl = "http://localhost:8080/project-ejb-1.0.0-SNAPSHOT/WebServiceImplService/WebServiceImpl?wsdl";

		String namespace = "http://webservice.tests.haisher.com";
		String serviceName = "WebServiceImplService";
		String portName = "WebServiceImplPort";

		QName serviceQn = new QName(namespace, serviceName);

		try {
			ServiceFactory factory = ServiceFactory.newInstance();

			Service webservice = factory.createService(new URL(wsdlUrl), serviceQn);

			WebServiceInterface webInterface = (WebServiceInterface) webservice.getPort(new QName(namespace, portName), WebServiceInterface.class);

			webInterface.invokeService(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
