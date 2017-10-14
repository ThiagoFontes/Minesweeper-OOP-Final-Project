package jogo;

import java.util.ArrayList;
import java.util.Random;

/**
 * <br>
 * A Classe mais importante do jogo. Os calculos que geram o jogo são feitos
 * aqui.</br> </br>
 * 
 * <br>
 * -<strong>versão 1.8</strong> - 11/04/2013 -> Retirada a interface de texto da
 * classe</br> <br>
 * -<strong>versão 1.6</strong> - 07/03/2013 -> Otimização dos loops e retirada
 * de repetição de códigos</br> <br>
 * -<strong>versão 1.4</strong> - 05/03/2013 -> Nova funcionalidade: é mostrado
 * os espaços vazios ligados a jogada.</br> <br>
 * -<strong>versão 1.2</strong> - 22/02/2013 -> remoção de Bugs e novas
 * funcionalidades.</br> <br>
 * -<strong>versão 1.0</strong> - 21/02/2013 -> Classe começa a funcionar com
 * interface de texto</br>
 * 
 * <blockquote>As bombas são definidas pelo número <strong>9.</strong> O
 * <strong>0</strong> é usado para as casas vazias, os demais numeros de
 * <strong>1-8</strong> representam seus respectivos valores. </blockquote>
 * 
 * @version 1.8
 * @author Thiago dos Santos Fontes
 */
public class CalculaCampo implements ICalculaCampo {
	private int contadorDeJogadas;
	private IDificuldade level;
	private Casa[][] casasCampo;
	private Random aleatorio;
	private String[][] campoShow;
	private static ArrayList<Casa> zeros; // Coleção com coordenadas dos zeros e
											// informação se já foram mostrados

	/**
	 * Construtor com parametro
	 * 
	 * @param level
	 *            Define a dificuldade do jogo
	 * @see Dificuldade
	 */
	public CalculaCampo(IDificuldade level) {
		this.level = level;
		this.contadorDeJogadas = 0;
		aleatorio = new Random();
		zeros = new ArrayList<Casa>();
		casasCampo = new Casa[level.getLinhas()][level.getColunas()];
		campoShow = new String[level.getLinhas()][level.getColunas()];
	}

	/**
	 * Inicializa o array de <code>String</code> a sua condição inicial que é
	 * com todos os valores iguais a <strong>" #"</strong>.</br>Inicializa
	 * também o array de {@link Casa} com as coordenadas de cada casa.
	 */
	private void incializaCampo() {
		for (int i = 0; i < level.getLinhas(); i++) {
			for (int j = 0; j < level.getColunas(); j++) {
				casasCampo[i][j] = new Casa(i, j);
				campoShow[i][j] = " #";
			}
		}
	}

	/**
	 * Inicializa o jogo com base na primeira jogada.
	 * 
	 * @param casa
	 *            A jogada é do tipo {@link Casa}
	 */
	private void primeiraJogada(ICasa casa)// De acordo com a primeira jogada
											// será
											// calculado o local das bombas
	{
		int numeroDeMinas = 0;
		int aux;

		incializaCampo();

		while (numeroDeMinas < level.getBombas()) {
			for (int i = 0; i < level.getLinhas(); i++) {
				for (int j = 0; j < level.getColunas(); j++) {
					if (casasCampo[i][j].getValor() != 9 && i != casa.getX()
							&& j != casa.getY()
							&& numeroDeMinas < level.getBombas()) {
						aux = aleatorio.nextInt(10);
						if (aux == 9) {
							casasCampo[i][j].setValor(aux);
							numeroDeMinas++;
						}
					}
				}
			}
		}
		calculaCampo();
		atualizaCampoJogadasTexto(casa);
	}

	/**
	 * Incrementa valor a casa de coordenadas x e y.
	 * 
	 * @param x
	 *            Coordenada x.
	 * @param y
	 *            Coordenada y.
	 */
	private void incrementaNoCampo(int x, int y) {
		int linha = (level.getLinhas() - 1);
		int coluna = (level.getColunas() - 1);
		if (x >= 0 && x <= linha && y >= 0 && y <= coluna
				&& casasCampo[x][y].getValor() != 9)
			casasCampo[x][y].incrementaValor();
	}

	/**
	 * Calcula o campo com base no lugar das bombas.
	 */
	private void calculaCampo() { // Calcula todo o campo com base na posição
									// das bombas
		int x;
		int y;// usados para percorer as casas nos arredores
		int aux = 0;// conta casas nos arredores

		for (int i = 0; i < level.getLinhas(); i++) {
			for (int j = 0; j < level.getColunas(); j++) {
				x = i;
				y = j;
				if (casasCampo[i][j].getValor() == 9) {
					while (aux < 8)// são oito casas ao redor de uma bomba
					{
						switch (aux) {
						case 0:
							x--;
							y++;
							incrementaNoCampo(x, y);
							break;
						case 1:
							y--;
							incrementaNoCampo(x, y);
							break;
						case 2:
							y--;
							incrementaNoCampo(x, y);
							break;
						case 3:
							x++;
							incrementaNoCampo(x, y);
							break;
						case 4:
							x++;
							incrementaNoCampo(x, y);
							break;
						case 5:
							y++;
							incrementaNoCampo(x, y);
							break;
						case 6:
							y++;
							incrementaNoCampo(x, y);
							break;
						case 7:
							x--;
							incrementaNoCampo(x, y);
							break;
						}// fim do switch
						aux++;
					}// fim do while
					aux = 0;
				}// fim do if
			}// fim do "for" com "j"
		}// fim do "for" com "i"
	}// fim do método "calculaCampo"

	/**
	 * Substitui a string <code>" #"</code> por uma string contendo o valor da
	 * casa.</br>Ex.: <code>" 3"</code>.
	 * 
	 * @param u
	 * @param v
	 */
	private void mostraNoCampoT(int u, int v) {
		int linha = (level.getLinhas() - 1);
		int coluna = (level.getColunas() - 1);
		int aux;
		if (u >= 0 && u <= linha && v >= 0 && v <= coluna
				&& casasCampo[u][v].getMostrarArredores()) {
			aux = casasCampo[u][v].getValor();
			campoShow[u][v] = " " + aux;
			if (u >= 0 && u <= linha && v >= 0 && v <= coluna && aux == 0
					&& casasCampo[u][v].getMostrarArredores()) {
				zeros.add(casasCampo[u][v]);
			}
		}
	}

	private void mostraAoRedor(int u, int v) { // mostra casas ao redor
		int aux2 = 0;
		while (aux2 < 8)// são oito casas ao redor de uma casa qualquer
		{
			switch (aux2) {
			case 0:
				u--;
				v++;
				mostraNoCampoT(u, v);
				break;
			case 1:
				v--;
				mostraNoCampoT(u, v);
				break;
			case 2:
				v--;
				mostraNoCampoT(u, v);
				break;
			case 3:
				u++;
				mostraNoCampoT(u, v);
				break;
			case 4:
				u++;
				mostraNoCampoT(u, v);
				break;
			case 5:
				v++;
				mostraNoCampoT(u, v);
				break;
			case 6:
				v++;
				mostraNoCampoT(u, v);
				break;
			case 7:
				u--;
				mostraNoCampoT(u, v);
				break;
			}
			aux2++;
		}
	}

	/**
	 * Gera versão do campo em texto onde as casas ainda não mostradas são
	 * representadas pela String " #"
	 * 
	 * @param casa
	 *            Recebe a jogada em um tipo {@link Casa}
	 * @see Casa
	 */
	private void atualizaCampoJogadasTexto(ICasa casa) {
		int x = casa.getX();
		int y = casa.getY();
		int aux = casasCampo[x][y].getValor();
		campoShow[x][y] = " " + aux;// o campo recebe a jogada
		if (aux == 0 && casasCampo[x][y].getMostrarArredores()) {
			zeros.add(casasCampo[x][y]);
			mostraAoRedor(x, y);
		}
		casasCampo[x][y].setMostrarArredores(false);// atualiza o status do
													// objeto para que ele não
													// entre no loop outra vez

		for (int percorreArray = 0; percorreArray < zeros.size(); percorreArray++) {
			mostraAoRedor(zeros.get(percorreArray).getX(),
					zeros.get(percorreArray).getY());
			zeros.get(percorreArray).setMostrarArredores(false);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICalculaCampo#gerenciaJogadas(jogo.Casa)
	 */
	@Override
	public void gerenciaJogadas(ICasa jogada) {
		contadorDeJogadas++;
		if (contadorDeJogadas == 1)
			primeiraJogada(jogada);
		else
			atualizaCampoJogadasTexto(jogada);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICalculaCampo#getContadorDeJogadas()
	 */
	@Override
	public int getContadorDeJogadas() {
		return contadorDeJogadas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICalculaCampo#reiniciaCampo()
	 */
	@Override
	public void reiniciaCampo() {
		contadorDeJogadas = 0;
		for (int i = 0; i < level.getLinhas(); i++) {
			for (int j = 0; j < level.getColunas(); j++) {
				casasCampo[i][j].setValor(0);
				campoShow[i][j] = " #";
				zeros.clear();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICalculaCampo#getCampoShow()
	 */
	@Override
	public String[][] getCampoShow() {
		return campoShow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICalculaCampo#getCasasCampo()
	 */
	@Override
	public ICasa[][] getCasasCampo() {
		return casasCampo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICalculaCampo#getLevel()
	 */
	@Override
	public IDificuldade getLevel() {
		return level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICalculaCampo#setLevel(jogo.IDificuldade)
	 */
	@Override
	public void setLevel(IDificuldade level) {
		this.level = level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICalculaCampo#setContadorDeJogadas(int)
	 */
	@Override
	public void setContadorDeJogadas(int contadorDeJogadas) {
		this.contadorDeJogadas = contadorDeJogadas;
	}
}