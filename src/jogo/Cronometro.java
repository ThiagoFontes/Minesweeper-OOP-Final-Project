package jogo;

/**
 * Classe usada para definir os atributos usados pela classe {@link Clock}
 * 
 */
public class Cronometro implements ICronometro {
	private int limit;
	private int value;

	/**
	 * Construtor com parametro.
	 * @param rollOverLimit Define limite da unidade ex.: 60 para minutos.
	 */
	public Cronometro(int rollOverLimit) {
		limit = rollOverLimit;
		value = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICronometro#getLimit()
	 */
	@Override
	public int getLimit() {
		return limit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICronometro#setLimit(int)
	 */
	@Override
	public synchronized void setLimit(int limit) {
		this.limit = limit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICronometro#getValue()
	 */
	@Override
	public int getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICronometro#setValue(int)
	 */
	@Override
	public synchronized void setValue(int value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICronometro#increment()
	 */
	@Override
	public synchronized void increment() {
		value = (value + 1) % limit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICronometro#getDisplayValue()
	 */
	@Override
	public synchronized String getDisplayValue() {
		if (value < 10)
			return "0" + value;
		else
			return "" + value;
	}

}
