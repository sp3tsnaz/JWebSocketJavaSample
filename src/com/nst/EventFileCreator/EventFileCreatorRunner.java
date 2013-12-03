package com.nst.EventFileCreator;

import com.nst.core.Separatify;
import com.nst.websocket.JWebSocketTokenListenerSample;
import com.nst.websocket.SimpleListener;

public class EventFileCreatorRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{	
		/*
		Separatify _separator = new Separatify();
		_separator.getFilesList("/usr/local/hadoop/jobs/secrowquanttime");
		*/
		
		//JWebSocketTokenListenerSample jst = new JWebSocketTokenListenerSample();
		//jst.init();
		
		SimpleListener sl = new SimpleListener();
		sl.init();
	}

}
