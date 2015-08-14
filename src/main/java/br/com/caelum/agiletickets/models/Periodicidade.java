package br.com.caelum.agiletickets.models;

public enum Periodicidade {
	
	DIARIA(1), SEMANAL(7);
	private int value;
	private Periodicidade(int value) {
		this.setValue(value);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
