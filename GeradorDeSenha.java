//essa classe vai servir como backend e gerar as senhas 

import java.util.Random;

public class GeradorDeSenha {
    //essas strings vão guardar as letras/numero/simbolos que vamos pegar aleatoriamente para gerar a senha
    public static final String CAIXA_ALTA_CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
    public static final String CAIXA_BAIXA_CARACTERES = "abcdefghijklmnopqrstuvxwyz";
    public static final String NUMEROS = "0123456789";
    public static final String SIMBOLOS_ESPECIAIS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    //a classe random deixa a gente gerar um numero aleatorio que usarei para a escolha aleatoria dos caracteres
    private final Random random;

    //construtor
    public GeradorDeSenha(){random = new Random();}

    public String geraSenha(int comprimento, boolean includeCaixaAlta, boolean includeCaixaBaixa, boolean includeNumeros,
                            boolean includeSimbolosEspeciais){
        StringBuilder contrutorSenha = new StringBuilder();

        String caracteresValidos = "";
        if(includeCaixaAlta) caracteresValidos += CAIXA_ALTA_CARACTERES;
        if(includeCaixaBaixa) caracteresValidos += CAIXA_BAIXA_CARACTERES;
        if(includeNumeros) caracteresValidos += NUMEROS;
        if(includeSimbolosEspeciais) caracteresValidos += SIMBOLOS_ESPECIAIS;

        //cria a senha
        for (int i = 0; i < comprimento; i++){
            //cria um index random
            int randomIndex = random.nextInt(caracteresValidos.length());

            //pega o caracter baseado no random index
            char randomChar = caracteresValidos.charAt(randomIndex);

            //guarda o char no contrutor da senha
            contrutorSenha.append(randomChar);

            //isso sera feito até que o comprimento que o usuario pediu seja alcançado
        }
        return contrutorSenha.toString();

    }
}
