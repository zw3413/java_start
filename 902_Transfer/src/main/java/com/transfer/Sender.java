package com.transfer;

public class Sender implements Runnable{

	private Transfer transfer;

	public Sender(Transfer transfer){
		this.transfer=transfer;
	}
	
	public void run() {
		transfer.initSendFile();
	}

}
