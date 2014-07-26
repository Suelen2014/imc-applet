import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PessoaTest extends JApplet implements ActionListener {

	private static final long serialVersionUID = 1L; 
	private JTextField nome, dataNascimento;
	private JLabel labelNome, labelDataNascimento, labelPeso, labelAltura, labelNomeApp;
	private JButton button1, button2; 
	private JRadioButton femButton, masButton;
	private JPanel panelNome, panelData, panelPeso, panelAltura, panelButton, panelButtonS, panelResult, panel; 
	private JSlider peso, altura;
	private ButtonGroup group;
	private Container c;
	private JTextArea areaDeTexto;
	private String nomeP, dataP, generoP;
	private double pesoP, alturaP;
	private boolean successful;
	private Homem homem;
	private Mulher mulher;
	
	public String calculaIMC(String genero) {
		
		String aux = null;
		if(genero == "Masculino") {
			
			homem = new Homem(nomeP, dataP, pesoP, alturaP);
			areaDeTexto.append(homem.toString() + "IMC: " + homem.calculaIMC(pesoP, alturaP) + " " + homem.resultIMC() + "\n");
			aux = "----------";
		} else if(genero == "Feminino") {
			
			mulher = new Mulher(nomeP, dataP, pesoP, alturaP);
			areaDeTexto.append(mulher.toString() + "IMC: " + mulher.calculaIMC(pesoP, alturaP) + " " + mulher.resultIMC() + "\n");
			aux = "----------";
		}
		return aux;
	}
	
	public void init() {
			
		//O BoxLayout empilha cada cada painel das componentes
		labelNomeApp = new JLabel("Calculadora IMC");
		
		//Nome
		labelNome = new JLabel("Nome: ");
		nome = new JTextField(20);
		panelNome = new JPanel();
		nome.addActionListener(this);
		panelNome.add(labelNome);    
		panelNome.add(nome);
		panelNome.setLayout(new BoxLayout(panelNome, BoxLayout.LINE_AXIS));
		
		//Data de Nascimento
		labelDataNascimento = new JLabel("Data de nascimento: ");
		dataNascimento = new JTextField(20);
		panelData = new JPanel();
		dataNascimento.addActionListener(this);
		panelData.add(labelDataNascimento);    
		panelData.add(dataNascimento);
		panelData.setLayout(new BoxLayout(panelData, BoxLayout.LINE_AXIS));

		//Altura
		labelAltura = new JLabel("Altura: ");
		//Slider bars para ajustar a altura
		altura = new JSlider(JSlider.HORIZONTAL, 0, 250, 0); 

		altura.setMinorTickSpacing(10); 
		altura.setMajorTickSpacing(20); 
		altura.setPaintTicks(true); 
		altura.setPaintLabels(true); 

		altura.setLabelTable(altura.createStandardLabels(50)); 
		altura.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				
				labelAltura.setText("Altura: " + ((JSlider)e.getSource()).getValue() + " cm");				
			}
	    });
		panelAltura = new JPanel();
		panelAltura.add(labelAltura);    
		panelAltura.add(altura);
		panelAltura.setLayout(new BoxLayout(panelAltura, BoxLayout.LINE_AXIS));
		
		//Peso
		labelPeso = new JLabel("Peso:");
		//Slider bars para ajustar o peso
		peso = new JSlider(JSlider.HORIZONTAL, 0, 200, 0); 

		peso.setMinorTickSpacing(10); 
		peso.setMajorTickSpacing(20); 
		peso.setPaintTicks(true); 
		peso.setPaintLabels(true); 

		peso.setLabelTable(peso.createStandardLabels(40)); 
		peso.addChangeListener(new ChangeListener() {
					
			public void stateChanged(ChangeEvent e) {
						
				labelPeso.setText("Peso: " + ((JSlider)e.getSource()).getValue() + " kg");				
			}
		});
		panelPeso = new JPanel();
		panelPeso.add(labelPeso);    
		panelPeso.add(peso);
		panelPeso.setLayout(new BoxLayout(panelPeso, BoxLayout.LINE_AXIS));
		
		//Enter para apresentar os dados e Clear para limpar
		button1 = new JButton("Enter");
		button1.addActionListener(this);
		button2 = new JButton("Clear");
		button2.addActionListener(this);
		panelButton = new JPanel();
		panelButton.add(button1);    
		panelButton.add(button2);
		panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.LINE_AXIS));
		
		//Genero sexual
		group = new ButtonGroup();
		panelButtonS = new JPanel();
		masButton = new JRadioButton("Masculino");
		femButton = new JRadioButton("Feminino");
		group.add(femButton);
		group.add(masButton);
		femButton.addActionListener(this);
		masButton.addActionListener(this);
		panelButtonS.add(femButton);    
		panelButtonS.add(masButton);
		panelButtonS.setLayout(new BoxLayout(panelButtonS, BoxLayout.LINE_AXIS));
				
		//ajusta a cor da fonte dos objetos
		labelNome.setForeground(Color.blue);
		labelDataNascimento.setForeground(Color.blue);
		labelPeso.setForeground(Color.blue);
		labelAltura.setForeground(Color.blue);
		
		//Apresenta os dados e o calculo do IMC     
		panelResult = new JPanel();
		areaDeTexto = new JTextArea();
		areaDeTexto.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(areaDeTexto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(320, 110));
        panelResult.add(scrollPane);
			
		//Adiciona na tela os componentes
        panel = new JPanel();
		c = getContentPane();
		
		panel.add(labelNomeApp);
		panel.add(panelNome);
		panel.add(panelData); 
		panel.add(panelPeso); 
		panel.add(panelAltura); 
		panel.add(panelButtonS); 
		panel.add(panelButton); 
		panel.add(panelResult);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        c.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource() instanceof JRadioButton) {
			
			if(masButton.isSelected()) {
				
				generoP = masButton.getText();
	        }
	        if(femButton.isSelected()) {
	        	 
	        	generoP = femButton.getText();
	        }	         
	    }
		
		if((e.getSource() instanceof JTextField) || (e.getSource() instanceof JSlider) || (e.getSource() instanceof JButton)){
			
			int i;
			successful = true;
			
			//trata o erro do nome
			nomeP = nome.getText();
			try {

				for(i = 0; i < nomeP.length(); ++i) {

					if((nomeP.charAt(i) > 47 && nomeP.charAt(i) < 58) && nomeP.charAt(i) != 46){
										
						break;
					}
				}
				if(i != nomeP.length()) {

					throw new EntradaInvalidaException("--- O nome nao deve ser um numero!!");
				} else if(nomeP.isEmpty()) {
					
					throw new StringIndexOutOfBoundsException("-- Entre com o seu nome");
				}
			} catch(EntradaInvalidaException e1) {

				successful = false;
				areaDeTexto.setForeground(Color.red); //apresenta os dados em vermelho
				areaDeTexto.append(e1.getMessage());
				areaDeTexto.append("\nPressiona Clear e digite novamente! \n");
				nome.setText("");
			} catch(StringIndexOutOfBoundsException e2) {

				successful = false;
				areaDeTexto.setForeground(Color.red); //apresenta os dados em vermelho
				areaDeTexto.append(e2.getMessage());
				areaDeTexto.append("\nPressiona Clear e digite novamente! \n");
				nome.setText("");
			}
			
			//trata o erro da data				
			dataP = dataNascimento.getText();
			try {

				for(i = 0; i < 10; ++i) {

					if((dataP.charAt(i) >= 97 && dataP.charAt(i) <= 122) || (dataP.charAt(i) >= 65 && dataP.charAt(i) <= 90)){
										
						break;
					}
				}
				if((i != dataP.length()) || (dataP.charAt(2) != 47) || (dataP.charAt(5) != 47)){

					throw new EntradaInvalidaException("--- A data deve ser um numero real ou esta com o formato incorreto (dd/mm/aaaa)!!");
				}
			} catch(EntradaInvalidaException e3) {

				successful = false;
				areaDeTexto.setForeground(Color.red); //apresenta os dados em vermelho
				areaDeTexto.append(e3.getMessage());
				areaDeTexto.append("\nPressiona Clear e digite novamente! \n");	
				dataNascimento.setText("");
			} catch(StringIndexOutOfBoundsException e4) {

				successful = false;
				areaDeTexto.setForeground(Color.red); //apresenta os dados em vermelho
				areaDeTexto.append("-- Entre com a sua data de nascimento.");
				areaDeTexto.append("\nPressiona Clear e digite novamente! \n");
				dataNascimento.setText("");
			}
			
			//apenas atribui o valor do peso para uma variavel
			pesoP = peso.getValue();
				
			//trata o erro da altura				
			alturaP = (altura.getValue())/100.0;
			
			//caso nao ocorra nenhum erro, imprime na area de texto o resultado
			if(successful == true) {
				
				if(e.getSource() == button1) { //Enter
		        	
		        	areaDeTexto.setForeground(Color.red); //apresenta os dados em vermelho
		            areaDeTexto.append(calculaIMC(generoP) + " \n"); //
		        } else { //Clear
		        	
		        	nome.setText("");
		        	dataNascimento.setText("");
		        	altura.setValue(0);
		        	peso.setValue(0);
		        	group.clearSelection();
		        	areaDeTexto.setText("");
		        }
			//caso ocorra algum erro e a pessoa pressionar o Clear para refazer os dados
			} if((e.getSource() == button2) && (successful == false)) { //Clear
	        	
	        	areaDeTexto.setText("");
	        }
	    }
	}
}
