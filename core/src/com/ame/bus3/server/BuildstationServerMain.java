package com.ame.bus3.server;

import com.ame.bus3.common.Variables;
import com.ame.bus3.common.packetsorters.SorterList;

/**
 * Main class for the server. Handles initalisation.
 * @author Grant
 *
 */
public class BuildstationServerMain {
	/**
	 * Starts the server.
	 */
	public void create() {
		SorterList.loadSorters();
		Variables.isServer = true;
		Variables.port = 25566;
		ConnectionAccepter accepter = new ConnectionAccepter();
		Thread accepterThread = new Thread(accepter);
		accepterThread.start();
		
		System.out.println("[Info] Finished initalising");
	}
}
