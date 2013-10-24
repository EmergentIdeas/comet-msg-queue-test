package com.emergentideas.cometmsgqueue.test;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.emergentideas.cometmsgqueue.SwitchingStation;
import com.emergentideas.webhandle.output.DirectRespondent;
import com.emergentideas.webhandle.output.NoResponse;
import com.emergentideas.webhandle.output.Show;

public class Source {
	
	@Resource
	protected SwitchingStation switchingStation;
	
	@GET
	@Path("/msgs")
	public Object msgs() {
		Random r = new Random();
		try {
			Thread.sleep(r.nextInt(10000));
		}
		catch(Exception e) {}
		
		DirectRespondent dr = new DirectRespondent();
		dr.setResponseStatus(200);
		dr.getHeaders().put("Message-Queue", "/time/update");
		dr.setOutput("Last msg at: " + new Date().toString());
		return dr;
	}
	
	@POST
	@Path("/send-msg")
	public Object send(String queue, String msg, HttpServletRequest request) {
		switchingStation.sendMessage(request.getSession(), queue, msg);
		return new Show("/submit.html");
	}
	
	@POST
	@Path("/send-chat")
	public Object sendChat(String chatSession, String msg, String myName, HttpServletRequest request) {
		switchingStation.sendMessage("/chatSession/" + chatSession, "/chat-msg/" + chatSession, myName + ": " + msg + "<br/>");
		return new DirectRespondent(null, 200, null);
	}
}
