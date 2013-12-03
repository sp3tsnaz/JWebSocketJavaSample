package com.nst.websocket;

import org.jwebsocket.api.WebSocketConnector;
import org.jwebsocket.api.WebSocketPacket;
import org.jwebsocket.api.WebSocketServer;
import org.jwebsocket.api.WebSocketServerListener;
import org.jwebsocket.config.JWebSocketConfig;
import org.jwebsocket.factory.JWebSocketFactory;
import org.jwebsocket.kit.RawPacket;
import org.jwebsocket.kit.WebSocketServerEvent;
import org.jwebsocket.server.BaseServer;
import org.jwebsocket.server.TokenServer;

public class SimpleListener implements WebSocketServerListener
{
	BaseServer server;
	String sessionId;
	WebSocketConnector con;
	
	public BaseServer getTokenServer() {
        return server;
    }
	
	public void init() {
        try {        	
        	JWebSocketFactory.printCopyrightToConsole();  
        	String[] aArgs = new String[0];
			// check if home, config or bootstrap path are passed by command line  
        	JWebSocketConfig.initForConsoleApp(aArgs );  
        	
            JWebSocketFactory.start();
            server = (BaseServer) JWebSocketFactory.getServer("ts0");
            if (server != null) {
                System.out.println("server was found");
                server.addListener(this);
            } else {
                System.out.println("server was NOT found");

            }
        } catch (Exception lEx) {
            lEx.printStackTrace();
        }
    }
	
	@Override
	public void processClosed(WebSocketServerEvent arg0) {		
	}

	@Override
	public void processOpened(WebSocketServerEvent arg0) {
		this.sessionId  = arg0.getSession().getSessionId();
		System.out.println(arg0.getSession().getSessionId());
		this.con = arg0.getConnector();
	}

	@Override
	public void processPacket(WebSocketServerEvent arg0, WebSocketPacket arg1) {		
		System.out.println(arg1.getString());		
		this.con.sendPacket(new RawPacket("You sent " + arg1.getString() + " : by server at " + System.currentTimeMillis()));		
	}

}
