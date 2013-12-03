package com.nst.websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jwebsocket.api.WebSocketConnector;
import org.jwebsocket.api.WebSocketPacket;
import org.jwebsocket.config.JWebSocketConfig;
import org.jwebsocket.factory.JWebSocketFactory;
import org.jwebsocket.kit.RawPacket;
import org.jwebsocket.kit.WebSocketServerEvent;
import org.jwebsocket.listener.WebSocketServerTokenEvent;
import org.jwebsocket.listener.WebSocketServerTokenListener;

import org.jwebsocket.server.TokenServer;
import org.jwebsocket.token.Token;


public class JWebSocketTokenListenerSample implements WebSocketServerTokenListener {

	 private TokenServer tokenServer;

	    public TokenServer getTokenServer() {
	        return tokenServer;
	    }

	    public void init() {
	        try {
	        	
	        	JWebSocketFactory.printCopyrightToConsole();  
	        	String[] aArgs = new String[0];
				// check if home, config or bootstrap path are passed by command line  
	        	JWebSocketConfig.initForConsoleApp(aArgs );  
	        	
	            JWebSocketFactory.start();
	            tokenServer = (TokenServer) JWebSocketFactory.getServer("ts0");
	            if (tokenServer != null) {
	                System.out.println("server was found");
	                tokenServer.addListener(this);
	            } else {
	                System.out.println("server was NOT found");

	            }
	        } catch (Exception lEx) {
	            lEx.printStackTrace();
	        }
	    }

	    public void processToken(WebSocketServerTokenEvent serverTokenEvent, Token token) {
	    	
	    }

	    public void processClosed(WebSocketServerEvent arg0) {
	    }

	    public void processOpened(WebSocketServerEvent event) {
	        System.out.println("***********Client '" + event.getSessionId()
	                + "' connected.*********");
	    }

	    public void sendPacket(int slideNumber) {
	        Map lConnectorMap = getTokenServer().getAllConnectors();

	        Collection<WebSocketConnector> lConnectors = lConnectorMap.values();
	        for (WebSocketConnector wsc : lConnectors) {
	            String json = "{\"action\":\"slide\",\"uniqueId\":123,\"slideNumber\":" + System.currentTimeMillis() + "}";
	            WebSocketPacket wsPacket = new RawPacket(json);
	            getTokenServer().sendPacket(wsc, wsPacket);            
	        }
	    }

	    public void processPacket(WebSocketServerEvent arg0, WebSocketPacket arg1) {
	        System.out.println("packet received " + arg1.getString());
	        sendPacket(1);
	    }	    
}
