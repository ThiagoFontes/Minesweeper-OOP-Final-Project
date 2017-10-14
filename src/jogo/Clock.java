package jogo;

/**
 * Esta classe funciona em uma <i>thread</i> separada para contar o tempo.
 *
 */
public class Clock implements Runnable, IClock {
	private ICronometro minutes;
	private ICronometro segund;
	private String displayString;
	private long i = 999;
	private Boolean pausado = false;

	public Clock() {
		minutes = new Cronometro(60);
		segund = new Cronometro(60);
		updateDisplay();

	}

	/* (non-Javadoc)
	 * @see jogo.IClock#timeTick()
	 */
	@Override
	public synchronized void timeTick() {

		segund.increment();
		if (segund.getValue() == 0) {

			minutes.increment();
		}

		updateDisplay();
	}

	private synchronized void updateDisplay() {
		displayString = minutes.getDisplayValue() + ":"
				+ segund.getDisplayValue();

	}

	/* (non-Javadoc)
	 * @see jogo.IClock#getDisplayString()
	 */
	@Override
	public synchronized String getDisplayString() {
		return displayString;
	}

	/* (non-Javadoc)
	 * @see jogo.IClock#run()
	 */
	@Override
	public synchronized void run() {
		try {
			verificaPausa();
			Thread.sleep(i);
			timeTick();
			//System.out.println(getDisplayString());
		} catch (InterruptedException e) {
			System.out.println("Contagem interrompida "+e);
		}
	}

	/* (non-Javadoc)
	 * @see jogo.IClock#setPausado(boolean)
	 */
	@Override
	public synchronized void setPausado(boolean pausado) {
		this.pausado = pausado;
		if (!this.pausado)
			notifyAll();
	}

	private synchronized void verificaPausa() throws InterruptedException {
		while (pausado) {
			wait();
		}
	}

	/* (non-Javadoc)
	 * @see jogo.IClock#reiniciaRelogio()
	 */
	@Override
	public synchronized void reiniciaRelogio() {
		setPausado(true);
		segund.setValue(0);
		minutes.setValue(0);
		updateDisplay();
	}

}
