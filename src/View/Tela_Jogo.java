package View;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_Heroi;
import Controller.Controller_Inimigo;



public class Tela_Jogo extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Tela_Jogo frame = new Tela_Jogo();

					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}



	/**

	 * Create the frame.

	 */

	public Tela_Jogo() {

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		setBounds(100, 100, 800, 1000);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(new CardLayout(0, 0));

		
		Controller_Heroi controllerHeroi = new Controller_Heroi();

		controllerHeroi.criarHeroi("Aragorn", 30, 20);


		Controller_Inimigo controllerInimigo = new Controller_Inimigo();

		
		JPanel panel = new JPanel();

		contentPane.add(panel, "name_6600797548400");

		panel.setLayout(new GridLayout(1, 3, 0, 0));

		

		JPanel panelEsquerda = new JPanel();
		panel.add(panelEsquerda);
		panelEsquerda.setLayout(new GridLayout(2, 1, 0, 0));

		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "INVENTÁRIO", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelEsquerda.add(scrollPane);

		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Item");
		model.addColumn("Quantidades");

		

		table = new JTable(model);

		scrollPane.setViewportView(table);

		
		JPanel panel_5 = new JPanel();
		panelEsquerda.add(panel_5);

	
		/*ImageIcon teste = new ImageIcon(getClass().getResource("/Imagens/Entrada_Caverna.png"));

		Image imagem = teste.getImage();

		JPanel panelCentro = new JPanel() {

			

			@Override

		    protected void paintComponent(Graphics g) {

		        super.paintComponent(g);



		        g.drawImage(

		            imagem,

		            0, 0,

		            getWidth(), getHeight(),

		            this

		        );

		}

		

		};

		panel.add(panelCentro);*/

		JPanel panelCentro = new JPanel();
		
		panel.add(panelCentro);
		

		JPanel panelDireita = new JPanel();

		panel.add(panelDireita);

		

		JPanel panel_1 = new JPanel();

		contentPane.add(panel_1, "name_6672811809400");



	}



}

