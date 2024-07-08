import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;                                            
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

//vai renderizar os componentes da GUI
public class GeradorDeSenhaGUI extends JFrame{
    private GeradorDeSenha geradorDeSenha;
    public GeradorDeSenhaGUI(){
        super("Gerador de Senhas");

        //colocando o tamanho da GUI
        setSize(540, 570);

        //para não deixar redimensionar 
        setResizable(false);

        //setar o layout como null para ter controle sobre as posições e tamanhos dos componentes no app
        setLayout(null);

        //Termina o programa quando fechamos a GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //centraliza a GUI
        setLocationRelativeTo(null);

        geradorDeSenha = new GeradorDeSenha();

        //renderizar os componentes da GUI
        addcomponentes();


    }
    private void addcomponentes(){
        //criar titulo
        JLabel tituloLabel = new JLabel("Gerador de Senhas");
        
        //configurando as letras
        tituloLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        //centralizar o texto na tela
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //setar os valores das coordenadas x,y, tamanho e largura
        tituloLabel.setBounds(0, 10, 540, 39);

        //adicionar na GUI
        add(tituloLabel);

        //criar a area de texto para o resultado
        JTextArea senhaResultado = new JTextArea();

        //previnir que não seja possivel editar a area de texto
        senhaResultado.setEditable(false);
        senhaResultado.setFont(new Font("Dialog", Font.BOLD, 32));

        //criando a posibilidade de scroll caso a senha fique muito grande
        JScrollPane senhaResultadoPane = new JScrollPane(senhaResultado);
        senhaResultadoPane.setBounds(25, 97, 479, 70);

        //criar um borda ao redor da area de texto
        senhaResultadoPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(senhaResultadoPane);

        //criando o rotulo para o comprimento da senha
        JLabel senhaComprimento = new JLabel("Comprimento: ");
        senhaComprimento.setFont(new Font("Dialog", Font.PLAIN, 32));
        senhaComprimento.setBounds(25, 215, 272, 39);
        add(senhaComprimento);

        //criando o input para o comprimento da senha
        JTextArea senhaComprimentoInputArea = new JTextArea();
        senhaComprimentoInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        senhaComprimentoInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        senhaComprimentoInputArea.setBounds(310, 215, 192, 39);
        add(senhaComprimentoInputArea);

        //criando botões alternaveis
        //CAIXA ALTA
        JToggleButton botaoCaixaAlta = new JToggleButton("Caixa alta");
        botaoCaixaAlta.setFont(new Font("Dialog", Font.PLAIN, 26));
        botaoCaixaAlta.setBounds(25, 302, 225, 56);
        add(botaoCaixaAlta);

        //caixa baixa
        JToggleButton botaoCaixaBaixa = new JToggleButton("Caixa baixa");
        botaoCaixaBaixa.setFont(new Font("Dialog", Font.PLAIN, 26));
        botaoCaixaBaixa.setBounds(282, 302, 225, 56);
        add(botaoCaixaBaixa);

        //numeros
        JToggleButton botaoNumeros = new JToggleButton("Numeros");
        botaoNumeros.setFont(new Font("Dialog", Font.PLAIN, 26));
        botaoNumeros.setBounds(25, 372, 225, 56);
        add(botaoNumeros);

        //simbolos
        JToggleButton botaoSimbolos = new JToggleButton("Simbolos");
        botaoSimbolos.setFont(new Font("Dialog", Font.PLAIN, 26));
        botaoSimbolos.setBounds(282, 373, 225, 56);
        add(botaoSimbolos);

        // Botão "Gerar"
        JButton botaoGerar = new JButton("Gerar");
        botaoGerar.setFont(new Font("Dialog", Font.PLAIN, 32));
        botaoGerar.setBounds(155, 477, 222, 41);
        botaoGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(senhaComprimentoInputArea.getText().length() <=0)return;
                boolean qualquerBotaoSelecionado = botaoCaixaBaixa.isSelected()||
                    botaoCaixaAlta.isSelected()||
                    botaoNumeros.isSelected()||
                    botaoSimbolos.isSelected();

                    int senhaComprimento = Integer.parseInt(senhaComprimentoInputArea.getText());
                    if(qualquerBotaoSelecionado){
                        String senhaGerada = geradorDeSenha.geraSenha(senhaComprimento,
                                botaoCaixaAlta.isSelected(),
                                botaoCaixaBaixa.isSelected(),
                                botaoNumeros.isSelected(),
                                botaoSimbolos.isSelected());
                                //mostra a senha para o usuario
                        senhaResultado.setText(senhaGerada);
                    }
            }

        }); 
        add(botaoGerar);
    }
}