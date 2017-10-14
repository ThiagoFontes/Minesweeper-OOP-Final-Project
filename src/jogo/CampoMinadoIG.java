package jogo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela criação da interface gráfica do jogo.
 * 
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 * @version 5.1
 */
public class CampoMinadoIG extends JFrame implements ICampoMinadoIG {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7210406135727977517L;
	private JButton[][] botao;// array de botões
	private ActionListener botaoListener;
	private String separador = ",";
	private ISepararCoordenadas jogada;
	private ICalculaCampo logica;
	private Container campo;
	private MouseHandler mouseH;
	private IDificuldade level;
	private int linhas;
	private int colunas;
	private JMenuItem novoJogo;
	private Clock relogio;
	private int contaCasasNaoMostradas;
	private JLabel contadorTempo;
	private JLabel contadorBombas;
	private int contaBombasMarcadas = 0;
	private JMenuItem[] dificuladeItens;
	private JMenu dificuldadeMenu;
	private ImageIcon icon;
	private ImageIcon icon2;
	private Dimension dimenBotao;
	private String caminho = "Img/Temas/";
	private String tema = "laranja/";
	private String imagem;

	/**
	 * Construtor sem parametros, chama o método fazCampo()
	 */
	public CampoMinadoIG() {
		super("Dançando No Campo Minado");
		fazCampo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampoMinadoIG#fazCampo()
	 */
	@Override
	public void fazCampo() {
		setResizable(false);
		level = new Dificuldade();
		level.setDificuldade(1);
		linhas = level.getLinhas();
		colunas = level.getColunas();
		botao = new JButton[linhas][colunas];
		jogada = new SepararCoordenadas();
		relogio = new Clock();
		dimenBotao = new Dimension(30, 30);

		JMenu fileMenu = new JMenu("Jogo");
		fileMenu.setMnemonic('J');
		JMenuBar barra = new JMenuBar();
		barra.add(fileMenu);
		Cursor mouse = new Cursor(Cursor.HAND_CURSOR);
		barra.setCursor(mouse);

		novoJogo = new JMenuItem("Novo Jogo");
		novoJogo.setMnemonic('N');
		novoJogo.setCursor(mouse);
		fileMenu.add(novoJogo);
		novoJogo.setEnabled(false);
		novoJogo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent reinicia) {

				reiniciaJogo();
			}
		});

		JMenuItem sobreItem = new JMenuItem("Sobre...");
		sobreItem.setMnemonic('O');// configura mnemônico como A
		sobreItem.setCursor(mouse);
		fileMenu.add(sobreItem);// adiciona item about ao menu File
		sobreItem.addActionListener(
		// classe interna anonima
				new ActionListener() {
					// exibe um dialogo
					public void actionPerformed(ActionEvent evento) {
						JOptionPane
								.showMessageDialog(
										CampoMinadoIG.this,
										"Programa feito como parte da avaliação.\n"
												+ "Referente a disciplina Programação Orientada a Objetos.\n"
												+ "Ministrada por: Admilson Ribeiro.",
										"Sobre",
										JOptionPane.INFORMATION_MESSAGE);
					}
				});

		JMenuItem exitItem = new JMenuItem("Sair"); // cria o item exit
		exitItem.setMnemonic('S');// configura o mn...
		exitItem.setCursor(mouse);
		fileMenu.add(exitItem);// adiciona o item exit ao menu
		exitItem.addActionListener(new ActionListener() {
			// termina o aplicativo
			public void actionPerformed(ActionEvent evento) {
				System.exit(0);// encerra aplicativo
			}
		});// fim do exititem

		dificuldadeMenu = new JMenu("Dificuldade");
		dificuldadeMenu.setMnemonic('d');
		String[] dificuldades = { "1 - Iniciante", "2 - Intermediario",
				"3 - Avançado" };// vetor de strings com as dificuldades
		dificuladeItens = new JMenuItem[dificuldades.length];
		// cria cada item do menu
		for (int i = 0; i < dificuldades.length; i++) {
			dificuladeItens[i] = new JMenuItem(dificuldades[i]);
			dificuladeItens[i].setText(dificuldades[i]);
			dificuladeItens[i].setCursor(mouse);
			dificuladeItens[i].setName("" + (i + 1));// adicionei 1
			dificuldadeMenu.add(dificuladeItens[i]);
			dificuladeItens[i].addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent arg0) {
				}

				public void mousePressed(MouseEvent evento) {
					if (evento.getComponent().isEnabled()) {
						setVisible(false);
						for (int i = 0; i < linhas; i++) {
							for (int j = 0; j < colunas; j++) {
								campo.remove(botao[i][j]);
							}
						}
						int i = Integer.parseInt(evento.getComponent()
								.getName());
						level.setDificuldade(i);
						criaNovoCampoG();
						contadorBombas.setText(contabombas());
						setLocationRelativeTo(null);
					}
					setVisible(true);
				}

				public void mouseExited(MouseEvent arg0) {
				}

				public void mouseEntered(MouseEvent arg0) {
				}

				public void mouseClicked(MouseEvent arg0) {
				}
			});
		}
		barra.add(dificuldadeMenu);

		setJMenuBar(barra);
		try {
			super.setContentPane(new PainelDeConteudo(
					"watercolour_skull_design-wallpaper-1366x768.jpg"));
		} catch (NullPointerException n) {
			JOptionPane.showMessageDialog( null,"Uma das imagens não pode ser carregada."
					+ "\nFaça o download do pacote outra vez");
		}
		campo = getContentPane();

		criaNovoCampoG();

		contadorBombas = new JLabel(contabombas());
		barra.add(contadorBombas);

		contadorTempo = new JLabel();
		contadorTempo.setText(relogio.getDisplayString());
		barra.add(contadorTempo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon iconeJanela = new ImageIcon(getClass().getResource(
				"Img/" + "iconeBomba.png"));
		setIconImage(iconeJanela.getImage());
		setSize(level.getDimensoes());
		setLocationRelativeTo(null);
		setVisible(true);
		contaTempo();
	}

	/**
	 * Método ultilizado para criar um novo jogo
	 */
	private void criaNovoCampoG() {
		contaBombasMarcadas = 0;
		linhas = level.getLinhas();
		colunas = level.getColunas();
		campo.setLayout(new GridLayout(linhas, colunas));
		mouseH = new MouseHandler();
		botao = new JButton[linhas][colunas];
		campo.addMouseListener(mouseH);
		icon = new ImageIcon(getClass().getResource(
				caminho + tema + "botao.png"));
		icon2 = new ImageIcon(getClass().getResource(
				caminho + tema + "mouseSobre.png"));
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				campo.add(botao[i][j] = new JButton());
				this.botao[i][j].setMaximumSize(dimenBotao);
				this.botao[i][j].addMouseListener(mouseH);
				this.botao[i][j].setName(i + separador + j);
				this.botao[i][j].setText("");
				this.botao[i][j].setIcon(icon);
				this.botao[i][j].setRolloverIcon(icon2);
				this.botao[i][j].addActionListener(botaoListener);
			}
		}
		novoJogo.setEnabled(false);
		logica = new CalculaCampo(level);
		setSize(level.getDimensoes());
		System.gc();
		gerencStatusDoMenu();
		relogio.reiniciaRelogio();
	}

	/**
	 * Classe interna. Responsável pelos eventos dos botões.
	 * 
	 * @author Thiago dos Santos Fontes
	 * @author Victor Fonseca Araujo
	 * 
	 */
	private class MouseHandler implements MouseListener, MouseMotionListener {

		public void mouseDragged(MouseEvent arg0) {
		}

		public void mouseMoved(MouseEvent arg0) {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
		 */
		public void mouseClicked(MouseEvent evento) {
			if (evento.getComponent().isEnabled() && evento.getClickCount() < 2
					&& evento.getButton() == 1
					&& evento.getComponent().getBackground() != Color.ORANGE
					&& evento.getSource().getClass() == JButton.class) {
				logica.gerenciaJogadas((jogada.enviaJogada(evento
						.getComponent().getName(), separador)));
				if (logica.getContadorDeJogadas() == 1
						&& evento.getSource().getClass() == JButton.class) {
					novoJogo.setEnabled(true);
					relogio.setPausado(false);
				}
				atualizaCampo(logica.getCampoShow());
			}
			if (evento.getComponent().isEnabled() && evento.getButton() == 3
					&& evento.getComponent().getBackground() != Color.ORANGE
					&& evento.getSource().getClass() == JButton.class
					&& logica.getContadorDeJogadas() > 0) {
				evento.getComponent().setBackground(Color.ORANGE);
				contaBombasMarcadas++;
				contadorBombas.setText(contabombas());
				atualizaCampo(logica.getCampoShow());
			} else if (evento.getComponent().getBackground() == Color.ORANGE
					&& evento.getButton() == 3
					&& logica.getContadorDeJogadas() > 0) {
				evento.getComponent().setBackground(null);
				contaBombasMarcadas--;
				contadorBombas.setText(contabombas());
				atualizaCampo(logica.getCampoShow());
			}
		}

		public void mouseEntered(MouseEvent arg0) {
		}

		public void mouseExited(MouseEvent arg0) {
		}

		public void mousePressed(MouseEvent evento) {
		}

		public void mouseReleased(MouseEvent arg0) {
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampoMinadoIG#atualizaCampo(java.lang.String[][])
	 */
	@Override
	public void atualizaCampo(String[][] campo) {
		contaCasasNaoMostradas = 0;
		ImageIcon icone;
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {

				if (botao[i][j].getBackground() == Color.ORANGE) {
					imagem = "marcadorMouse.png";
					icone = new ImageIcon(getClass().getResource(
							caminho + tema + imagem));
					botao[i][j].setIcon(icone);
					imagem = "marcadorMouseS.png";
					icone = new ImageIcon(getClass().getResource(
							caminho + tema + imagem));
					botao[i][j].setRolloverIcon(icone);
				} else if (botao[i][j].getIcon() != icon) {
					botao[i][j].setIcon(icon);
					botao[i][j].setRolloverIcon(icon2);
				}

				if (campo[i][j].equals(" #") == false) {
					switch (campo[i][j]) {
					case " 0":
						imagem = "Vazio.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(icone);
						this.botao[i][j].setEnabled(false);
						break;
					case " 1":
						imagem = "1.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(icone);
						this.botao[i][j].setEnabled(false);
						break;
					case " 2":
						imagem = "2.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(icone);
						this.botao[i][j].setEnabled(false);
						break;
					case " 3":
						imagem = "3.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(icone);
						this.botao[i][j].setEnabled(false);
						break;
					case " 4":
						imagem = "4.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(icone);
						this.botao[i][j].setEnabled(false);
						break;
					case " 5":
						imagem = "5.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(icone);
						this.botao[i][j].setEnabled(false);
						break;
					case " 6":
						imagem = "6.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(icone);
						this.botao[i][j].setEnabled(false);
						break;
					case " 7":
						imagem = "7.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(icone);
						this.botao[i][j].setEnabled(false);
						break;
					case " 8":
						imagem = "8.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(icone);
						this.botao[i][j].setEnabled(false);
						break;
					case " 9":
						relogio.setPausado(true);
						this.botao[i][j].setEnabled(false);
						imagem = "bomba2.png";
						ImageIcon iconeb = new ImageIcon(getClass()
								.getResource(caminho + tema + imagem));
						this.botao[i][j].setDisabledIcon(iconeb);
						ICasa[][] bombas = new ICasa[linhas][colunas];
						bombas = logica.getCasasCampo();
						for (int a = 0; a < linhas; a++) {
							for (int b = 0; b < colunas; b++) {
								if (bombas[a][b].getValor() == 9
										&& botao[a][b].getDisabledIcon() != iconeb) {
									imagem = "bomba.png";
									icone = new ImageIcon(getClass()
											.getResource(
													caminho + tema + imagem));
									botao[a][b].setDisabledIcon(icone);
									botao[a][b].setEnabled(false);
								}
							}
						}
						logica.setContadorDeJogadas(0);
						contadorTempo.setText(relogio.getDisplayString());
						JOptionPane.showMessageDialog(
								CampoMinadoIG.this,
								"Você Perdeu!!! :D\nKKKKKKKKK\n"
										+ "KABOOOM(explosões!)\n"
										+ "Seu tempo: "
										+ contadorTempo.getText(), "Derrota",
								JOptionPane.INFORMATION_MESSAGE);
						reiniciaJogo();
						break;
					default:
						imagem = "botao.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						botao[i][j].setIcon(icone);
						imagem = "mouseSobre.png";
						icone = new ImageIcon(getClass().getResource(
								caminho + tema + imagem));
						botao[i][j].setRolloverIcon(icone);
						break;
					}

				}
				if (campo[i][j].equals(" #")) {
					contaCasasNaoMostradas++;
				}
			}

		}

		if (contaCasasNaoMostradas == level.getBombas()) {
			relogio.setPausado(true);
			JOptionPane.showMessageDialog(CampoMinadoIG.this,
					"Você Ganhou =/\nJogue de novo aí.\nTempo: "
							+ contadorTempo.getText(), "Vitória",
					JOptionPane.INFORMATION_MESSAGE);
			reiniciaJogo();
		}
	}

	/**
	 * Gera <code>String</code> com
	 * "número de bombas marcadas"/"número de bombas".
	 * 
	 * @return Retorna a <code>String</code> especificada
	 */
	private String contabombas() {
		return "<" + contaBombasMarcadas + "/" + level.getBombas()
				+ "bombas> |";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampoMinadoIG#reiniciaJogo()
	 */
	@Override
	public void reiniciaJogo() {
		logica.reiniciaCampo();
		icon = new ImageIcon(getClass().getResource(
				caminho + tema + "botao.png"));
		ImageIcon icon2 = new ImageIcon(getClass().getResource(
				caminho + tema + "mouseSobre.png"));
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				this.botao[i][j].setText("");
				this.botao[i][j].setIcon(icon);
				this.botao[i][j].setRolloverIcon(icon2);
				this.botao[i][j].setEnabled(true);
				if (this.botao[i][j].getBackground() == Color.ORANGE
						|| this.botao[i][j].getBackground() == Color.red)
					this.botao[i][j].setBackground(null);
			}
		}
		contaBombasMarcadas = 0;
		relogio.reiniciaRelogio();
		contadorTempo.setText(relogio.getDisplayString());
		contadorBombas.setText(contabombas());
		novoJogo.setEnabled(false);
		System.gc();
	}

	/**
	 * Responsável por iniciar o thread que vai contar o tempo.
	 */
	private void contaTempo() {
		Boolean loopInfinto = true;
		while (loopInfinto) {
			relogio.run();
			contadorTempo.setText("" + relogio.getDisplayString());
		}

	}

	/**
	 * Desativa no menu dificuldade a dificuldade vigente.
	 */
	private void gerencStatusDoMenu() {
		for (int i = 0; i < dificuladeItens.length; i++) {
			if (this.level.getNivel() == (i + 1))
				this.dificuladeItens[i].setEnabled(false);
			else
				this.dificuladeItens[i].setEnabled(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampoMinadoIG#getContaCasasNaoMostradas()
	 */
	@Override
	public int getContaCasasNaoMostradas() {
		return contaCasasNaoMostradas;
	}

	/**
	 * O objeto é criado e o jogo inicia.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new CampoMinadoIG();
	}
}
