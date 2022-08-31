import java.util.Scanner;
public class foca {
    static boolean resposta = false;
    static String [][] forcaForma;
    static String comparacao="";
    static String teste ="";
    public static  int veriguar(char users , int colunaV, String userletra, int erros) {
        boolean verigua= true;
        char[] arr = new char[userletra.length()];
        for (int iArray = 0; iArray < userletra.length(); iArray++) {
            arr[iArray] = userletra.charAt(iArray);
        }
        for (int i = 0; i< userletra.length(); i++){
            if(users==arr[i]){
                forcaForma[5][i+4] = Character.toString(users);
                verigua= false;
                comparacao = forcaForma[5][i+4] = Character.toString(users);
                teste+=comparacao;
                if (userletra.length()==teste.length()){
                    int idx = 0;
                    char[] arrpalavra = new char[teste.length()];
                    for (int iArray = 0; iArray < teste.length(); iArray++) {
                        arrpalavra[iArray] = teste.charAt(iArray);
                    }
                    for (int ive = 0; ive< userletra.length(); ive++){
                        if(arr[i]==arrpalavra[i]){
                                idx+=1;
                                if(idx==userletra.length()){
                                    resposta=true;
                                }
                        }
                    }
                    resposta=true;
                }
            }
        }
        if(verigua){
            erros+=1;
        }
        return erros;
    }
    public static  void tamanhoForca(int linha , int coluna, String palavraUser, int erros){
            forcaForma= new String[linha][coluna];
            while (erros<=6 && resposta == false ){
                for(int i = 0; i< linha; i++){
                    for( int iF = 0; iF<coluna; iF++){
                        if (iF < 4) {
                            if(i==0){
                                forcaForma[0][iF]=" —";
                            }
                            if(i>0){
                                if(i==1){
                                    if(iF==0){
                                        forcaForma[1][iF]="|     ";
                                    }else if(iF==3){
                                        forcaForma[1][iF]="|";

                                    }else{
                                        if(forcaForma[1][iF]== null){
                                            forcaForma[1][iF]=" ";
                                        }
                                    }
                                }else{
                                    forcaForma[i][0]="|";
                                    if(iF>0){
                                        if(forcaForma[i][iF] == null){
                                            forcaForma[i][iF]=" ";
                                        }
                                    }
                                }
                                if(i==5){
                                    forcaForma[i][iF]=" ";
                                    forcaForma[5][0]="|   ";
                                }
                            }
                        }else{
                            if(iF>0){
                                if(forcaForma[i][iF] == null){
                                    forcaForma[i][iF]=" ";
                                }
                            }
                            if(i==5){
                                forcaForma[5][0]="|   ";
                                if(iF>3){
                                    if(forcaForma[i][iF] == null ||forcaForma[i][iF] == " "){
                                        forcaForma[i][iF]=" _ ";
                                    }
                                }
                            }
                        }
                        System.out.print(forcaForma[i][iF]);
                    }
                    System.out.println();
        }
            Scanner sc = new Scanner(System.in);
                System.out.println("Voce errou: "+erros);
            System.out.println("Qual é a letra que irá testa: ");
            char letra = sc.next().charAt(0);
            erros = veriguar(letra, coluna, palavraUser, erros);
            if(erros>0){
                if(erros== 1) {
                    forcaForma[2][3] = "    ㋡";
                }
                if(erros== 2) {
                    forcaForma[3][3] = "     |";
                }
                if(erros== 3) {
                    forcaForma[3][3] = "     |";
                    forcaForma[3][4] = "¯¯_*";
                }
                if(erros== 4) {
                    forcaForma[3][3] = "|";
                    forcaForma[3][2] = "   *-_";
                }
                if(erros== 5) {
                    forcaForma[4][3] = "     |";
                }
                if(erros== 6) {
                    forcaForma[4][3] = "|";
                    forcaForma[4][2] = "     /";
                }
            }

        }
            if(erros >= 6){
                System.out.println("Acabou suas chances");
            }
            if(resposta){
                System.out.println("Você venceu parabens");
            }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual é a palavra que irá ser selecionada: ");
        String palavra = sc.nextLine();
        int User = palavra.length();
        int erros=0;
        tamanhoForca(6,User+4, palavra, erros);
    }
}
