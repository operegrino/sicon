/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Telas.Componentes.Progressao;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class Funcoes {
    
    private Progressao prog;     
    
    public Funcoes() {
        
    }
    /*
     * Centralizar o frame em questão na tela;
     */
    public static Point CentralizarFrame(Dimension Dim){       
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int iLargura       = ((tela.width / 2));
        int iLarguraForm   = (Dim.getSize().width/2);
        int x              = iLargura - iLarguraForm;
        int iAltura  = ((tela.height / 2) - (Dim.getSize().height/2)) - 40; 
         Point ptRetorno;
         return ptRetorno = new Point(x, iAltura);             
    }
    
    public static String CharToString(char[] charconverter){
        String sRetorno = "";
        int cont = 0;
        while (charconverter.length > cont)  {
            sRetorno = sRetorno + charconverter[cont];
            cont++;
        }
        return sRetorno;
    }
    
    private int verificaTipo(int idUnidadeMedida) {
        unidademedida unidade = new unidademedida();
        unidade.LerClasse(idUnidadeMedida);
        if (unidade.getMiligrama()) {
            return 1;
        } else if (unidade.getgrama()) {
            return 2;
        } else if (unidade.getQuilograma()) {
            return 3;
        } else {
            return 0;
        }
        
    }
    /**
     * Converte o numero passado para a 
     * classifição(1-miligrama, 2-grama, 3-quilo) necessaria
     * @param Peso
     * @param Classificacao
     * @return
     */
    public BigDecimal converterPesoEmKilo(BigDecimal peso, int idUnidadeMedida, int classificacao){
        BigDecimal resultado = new BigDecimal(0);
        int medida = verificaTipo(idUnidadeMedida);
        if (medida == classificacao) {
            resultado = peso;
        } else if (medida == 1) {
            if (classificacao == 2) {
                resultado = peso.divide(new BigDecimal(1000));
            } else if (classificacao == 3) {
                resultado = peso.divide(new BigDecimal(1000000));
            }
        } else if (medida == 2) {
            if (classificacao == 1) {
                resultado = peso.multiply(new BigDecimal(1000));
            } else if (classificacao == 3) {
                resultado = peso.divide(new BigDecimal(1000));
            }
        } else if (medida == 3) {
            if (classificacao == 1) {
                resultado = peso.multiply(new BigDecimal(1000000));
            } else if (classificacao == 2) {
                resultado = peso.multiply(new BigDecimal(1000));
            }
        }
        return resultado;
    }   
    
    /**
     * 
     * @param listaNaQualProcurar
     * @param ProcurarPeloOQue
     * @param NaPosicaoProcurarPeloOQue
     * @param NaPosicaoRetorna
     * @return  Object que representa o valor necessário
     */
    public static Object retornaValorObject(ArrayList listaNaQualProcurar, Object ProcurarPeloOQue, int NaPosicaoProcurarPeloOQue, int NaPosicaoRetorna) {
        for (Iterator<ArrayList> it = listaNaQualProcurar.iterator(); it.hasNext();) {
            ArrayList lista = it.next();
            if (lista.get(NaPosicaoProcurarPeloOQue).equals(ProcurarPeloOQue)) {
                return lista.get(NaPosicaoRetorna);
            }
        }
        return null;
    }
    
    /**
     * verifica se o parametro id, está contido no array de array 
     * na posição posicaoVerificar
     * @param id
     * @param vetor
     * @param posicaoVerificar
     * @return
     */
    public static boolean isAdicionada(Object id, ArrayList lista, int posicaoVerificar) {
        for (Iterator<ArrayList> it = lista.iterator(); it.hasNext();) {
            ArrayList ls = it.next();
            if ((Integer)ls.get(posicaoVerificar) == id) {
                return true;
            }            
        } return false;
    }
    
    public static boolean ValidaCnpj(String str_cnpj) {
      int soma = 0, aux, dig;
      String cnpj_calc = str_cnpj.substring(0,12);

      if ( str_cnpj.length() != 14 )
        return false;

      char[] chr_cnpj = str_cnpj.toCharArray();

      /* Primeira parte */
      for( int i = 0; i < 4; i++ )
        if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
          soma += (chr_cnpj[i] - 48) * (6 - (i + 1)) ;
      for( int i = 0; i < 8; i++ )
        if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )
          soma += (chr_cnpj[i+4] - 48) * (10 - (i + 1)) ;
      dig = 11 - (soma % 11);

      cnpj_calc += ( dig == 10 || dig == 11 ) ?
                     "0" : Integer.toString(dig);

      /* Segunda parte */
      soma = 0;
      for ( int i = 0; i < 5; i++ )
        if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
          soma += (chr_cnpj[i] - 48) * (7 - (i + 1)) ;
      for ( int i = 0; i < 8; i++ )
        if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )
          soma += (chr_cnpj[i+5] - 48) * (10 - (i + 1)) ;
      dig = 11 - (soma % 11);
      cnpj_calc += ( dig == 10 || dig == 11 ) ?
                     "0" : Integer.toString(dig);

      return str_cnpj.equals(cnpj_calc);         
    }
    
    /* Procura em um arraylist(Lista - arraylist esse qeu possui arrays dentro dele) passado como parametro na posicao(Posicao) passada como parametro
     * o valor (Procurado) se achou retorna a posicao dentro do vetor;     * 
     */
    public static int RetornaPosicaoArray(ArrayList Lista, int Posicao, Object Procurado) {
        int Cont = 0;        
        int Retorno = -1;
        while (Lista.size() > Cont) {
            if (((ArrayList)Lista.get(Cont)).get(Posicao) == Procurado) {
                Retorno = Cont;
            }                
            Cont++;
        }
        return Retorno;
    }
    
    public static int RetornaPosicaoVectordeObjectLista(Vector Lista, int Posicao, Object Procurado) { 
        int Cont = 0;
        int Retorno = -1;
        while (Lista.size() > Cont) {
            if (((Object[])Lista.get(Cont))[Posicao].equals(Procurado)) {
                Retorno = Cont;
            }                
            Cont++;
        }
        return Retorno;        
    }
    
    public static String FormataDataPadrao(Date data){
         String dt = "";                  
         SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
         dt = sf.format(data);
         return dt;
    }
    
    public static Date FormataDataPadrao(String data){
        Date dt = new Date(); 
        Integer dia = Integer.parseInt(data.substring(0, 2));
        Integer mes = Integer.parseInt(data.substring(3, 5));
        Integer ano = Integer.parseInt(data.substring(6, 10));
        GregorianCalendar cal = new GregorianCalendar(ano, mes - 1, dia);
        dt = cal.getTime();
        return dt;
    }    
    /**
     * Método não estatico utilizado para mostrar a barra de progressão;
     */
    public void ExibirProgressao(){      
       /* prog = new Progressao();
        SwingWorker worker = new SwingWorker(){  
            @Override  
            protected Object doInBackground() throws Exception {  
                prog.setVisible(true);
            }  
            @Override  
            protected void done() {  
                 prog.setVisible(false);  
            }  
       };*/  
        
    }
    
    public void PararProgressao(){
        prog = null;
    }
    
    /*public static int RetornaTipoLista(Object Lista) {
        if (Lista instanceof Vector) {
            return 0;
        } else if (Lista instanceof ArrayList) {
            return 1;
        } else if (Lista instanceof Object[]) {
            return 2;
        } else return 3;
    }
    
    private static int ProcuraNoVector(Vector Lista, int Posicao, Object Procurado) {
        int Cont = 0;        
        int Retorno = 0;
        while (Lista.size() > Cont) {
            if (((Vector)Lista.get(Cont)).get(Posicao) == Procurado) {
                Retorno = Cont;
            }                
            Cont++;
        }
        return Retorno;        
    }
    
    private static int ProcuraNoObjectVector(Vector Lista, int Posicao, Object Procurado) {
        int Cont = 0;        
        int Retorno = 0;
        while (Lista.size() > Cont) {
            if (((Object[])Lista[Cont])[Posicao] == Procurado) {
                Retorno = Cont;
            }                
            Cont++;
        }
        return Retorno;        
    }  
    
    private static int ProcuraNoArrayLista(ArrayList Lista, int Posicao, Object Procurado) {
        int Cont = 0;        
        int Retorno = 0;
        while (Lista.size() > Cont) {
            if (((ArrayList)Lista.get(Cont)).get(Posicao) == Procurado) {
                Retorno = Cont;
            }                
            Cont++;
        }
        return Retorno;        
    }        
    
    public static int RetornaPosicaoLista(Object Lista, int Posicao, Object Procurado) {
        if (RetornaTipoLista(Lista) == 0) {
            if (RetornaTipoLista(((Vector)Lista).get(0)) == 0) {
                return ProcuraNoVector((Vector)Lista, Posicao, Procurado); 
            } else if (RetornaTipoLista(((Vector)Lista).get(0)) == 1) {
                return ProcuraNoArrayLista((ArrayList)Lista, Posicao, Procurado); 
            } else if (RetornaTipoLista(((Vector)Lista).get(0)) == 2) {
                return ProcuraNoObjectVector((Object[])Lista, Posicao, Procurado); 
            } return 0;
        } else if (RetornaTipoLista(Lista) == 1) {
            if (RetornaTipoLista(((ArrayList)Lista).get(0)) == 0) {
                return ProcuraNoVector((Vector)Lista, Posicao, Procurado); 
            } else if (RetornaTipoLista(((ArrayList)Lista).get(0)) == 1) {
                return ProcuraNoArrayLista((ArrayList)Lista, Posicao, Procurado); 
            } else if (RetornaTipoLista(((ArrayList)Lista).get(0)) == 2) {
                return ProcuraNoObjectVector((Object[])Lista, Posicao, Procurado); 
            } return 0;         
        } else if (RetornaTipoLista(Lista) == 2) {
            if (RetornaTipoLista(((Object[])Lista)[0]) == 0) {
                return ProcuraNoVector((Vector)Lista, Posicao, Procurado); 
            } else if (RetornaTipoLista(((Object[])Lista)[0]) == 1) {
                return ProcuraNoArrayLista((ArrayList)Lista, Posicao, Procurado); 
            } else if (RetornaTipoLista(((Object[])Lista)[0]) == 2) {
                return ProcuraNoObjectVector((Object[])Lista, Posicao, Procurado); 
            } return 0;      
        } else return 0;

    }    */

  

}  


