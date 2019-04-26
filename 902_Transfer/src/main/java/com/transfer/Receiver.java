package com.transfer;

public class Receiver implements Runnable{
	
	private Transfer transfer;
	
	public Receiver(Transfer transfer){
		this.transfer=transfer;
	}
	
	public void run() {
		transfer.initRece();
		
	}
}