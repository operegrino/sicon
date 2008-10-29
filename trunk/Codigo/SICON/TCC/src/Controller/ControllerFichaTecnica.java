/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.fichatecnica;
import Classes.fichatecnicaitens;
import Classes.fichatecnicaitensPK;
import Classes.produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class ControllerFichaTecnica extends ControllerAncestral implements InterfaceControllerPadrao{ 
    
    private fichatecnica Ficha;
    
    public ControllerFichaTecnica(){
        super();
        Ficha = new fichatecnica();
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        return false;
    }

    public boolean EventoSalvaFichaEItens(ArrayList<Object> ListaFicha, 
                                          ArrayList ListaNovoItens, 
                                          ArrayList ListaAlterarItens, 
                                          ArrayList ListaExcluirItens) {    
        CarregarClasse(ListaFicha);
        return Ficha.GravaFichaEItens(0, 
                                      CarregarFichaTecnicaItens(ListaNovoItens),
                                      CarregarFichaTecnicaItens(ListaAlterarItens),
                                      CarregarParaExcluir(ListaExcluirItens));
           
    }
    
    public ArrayList<fichatecnicaitens> CarregarFichaTecnicaItens(ArrayList Lista) {
        ArrayList<fichatecnicaitens> ListaRetorno = new ArrayList<fichatecnicaitens>();
        for (Iterator<ArrayList> it = Lista.iterator(); it.hasNext();) {
            ArrayList lis = it.next();
            fichatecnicaitens ft = new fichatecnicaitens();
            ft.setFichatecnicaitensPK(new fichatecnicaitensPK(Integer.parseInt(lis.get(0).toString()), Integer.parseInt(lis.get(1).toString())));
            ft.setPesobruto(new BigDecimal(lis.get(3).toString()));
            ft.setPesoliquido(new BigDecimal(lis.get(4).toString()));
            ft.setFatorcorrecao(Integer.parseInt(lis.get(5).toString()));
            ListaRetorno.add(ft);           
        }
        return ListaRetorno;
    }
    
    public ArrayList<fichatecnicaitens> CarregarParaExcluir(ArrayList Lista){
        ArrayList<fichatecnicaitens> ListaRetorno = new ArrayList<fichatecnicaitens>();
        for (Iterator<ArrayList> it = Lista.iterator(); it.hasNext();) {
            ArrayList id = it.next();            
            fichatecnicaitens ft = new fichatecnicaitens();
            ft.LerClasse(Integer.parseInt(id.get(0).toString()), Integer.parseInt(id.get(1).toString()));
            ListaRetorno.add(ft);
        }        
        return ListaRetorno;
    }
    
    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean EventoAlterarFichaEItens(ArrayList<Object> ListaFicha, 
                                          ArrayList ListaNovoItens, 
                                          ArrayList ListaAlterarItens, 
                                          ArrayList ListaExcluirItens) {    
        CarregarClasse(ListaFicha);
        return Ficha.GravaFichaEItens(1, 
                                      CarregarFichaTecnicaItens(ListaNovoItens),
                                      CarregarFichaTecnicaItens(ListaAlterarItens),
                                      CarregarParaExcluir(ListaExcluirItens));
           
    }    

    @Override
    public boolean EventoExcluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List EventoAdicionar(int idProduto, BigDecimal PesoBruto ,BigDecimal PesoLiquido){
        produto p = new produto();
        p.LerClasse(idProduto);
        Ficha.SomarComposicaoCentesimal(p, PesoBruto, PesoLiquido);
        return DevolverApenasComposicaoFicha();
    }
    
    public List EventoExcluirItem(int idProduto, BigDecimal PesoBruto ,BigDecimal PesoLiquido){
        produto p = new produto();
        p.LerClasse(idProduto);
        Ficha.DiminuirComposicaoCentesimal(p, PesoBruto, PesoLiquido);
        return DevolverApenasComposicaoFicha();        
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Ficha.LerClasse(id);
        fichatecnicaitens fti =  new fichatecnicaitens();
        ArrayList ListaP = new ArrayList();
        ListaP.add("fichatecnica");
        ListaP.add(id);
        return DevolverDadosClasseTodos((Vector)fti.Pesquisar(ListaP));
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Ficha.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList Objeto) {
        Ficha.setNomepreparacao(Objeto.get(0).toString());
        Ficha.setModopreparo(Objeto.get(1).toString());
        Ficha.setRendimento(new BigDecimal((Objeto.get(2).toString())));
        /*Ficha.setEnergia((BigDecimal)Objeto.get(3));
        Ficha.setCarboidrato((BigDecimal)Objeto.get(4));
        Ficha.setProteina((BigDecimal)Objeto.get(5));
        Ficha.setLipideo((BigDecimal)Objeto.get(6));
        Ficha.setCalcio((BigDecimal)Objeto.get(7));
        Ficha.setFerro((BigDecimal)Objeto.get(8));
        Ficha.setVitaminac((BigDecimal)Objeto.get(9));
        Ficha.setPesocru((BigDecimal)Objeto.get(10));        
        Ficha.setPesoliquido((BigDecimal)Objeto.get(11));
        Ficha.setPrecoTotal((BigDecimal)Objeto.get(12));*/
        /*Ficha.setEnergia(new BigDecimal(50.0));
        Ficha.setCarboidrato(new BigDecimal(0.0));
        Ficha.setProteina(new BigDecimal(0.0));
        Ficha.setLipideo(new BigDecimal(0.0));
        Ficha.setCalcio(new BigDecimal(0.0));
        Ficha.setFerro(new BigDecimal(0.0));
        Ficha.setVitaminac(new BigDecimal(0.0));
        Ficha.setPesocru(new BigDecimal(0.0));        
        Ficha.setPesoliquido(new BigDecimal(0.0));
        Ficha.setPrecoTotal(new BigDecimal(0.0));        */
        
    }

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList Lista = new ArrayList();
        return Lista;                
    }
    
public ArrayList DevolverDadosClasseTodos(Vector ListaIngre) {
        ArrayList Lista = new ArrayList();
        Lista.add(Ficha.getIdfichatecnica().toString());
        Lista.add(Ficha.getModopreparo());
        Lista.add(Ficha.getRendimento().toString());
        Lista.add(Ficha.getEnergia().toString());
        Lista.add(Ficha.getCarboidrato().toString());
        Lista.add(Ficha.getProteina().toString());
        Lista.add(Ficha.getLipideo().toString());
        Lista.add(Ficha.getCalcio().toString());
        Lista.add(Ficha.getFerro().toString());
        Lista.add(Ficha.getVitaminac().toString());
        Lista.add(Ficha.getPesocru().toString());
        Lista.add(Ficha.getPesoliquido().toString());
        Lista.add(Ficha.getPrecoTotal().toString());
        ArrayList ListaProd = new ArrayList();
        for (Iterator<Vector> it = ListaIngre.iterator(); it.hasNext();) {
        Vector v = it.next();
        ArrayList Lista2 = new ArrayList();
        Lista2.add(v.get(0).toString());
        Lista2.add(v.get(1).toString());
        Lista2.add(v.get(2).toString());
        Lista2.add(v.get(3).toString());
        Lista2.add(v.get(4).toString());
        Lista2.add(v.get(5).toString());
        Lista2.add(v.get(6).toString());
        Lista2.add(v.get(7).toString());
        ListaProd.add(Lista2);        
    }
        Lista.add(ListaProd);
        Lista.add(Ficha.getNomepreparacao().toString());
        return Lista;
    }    

    public List DevolverApenasComposicaoFicha(){
        ArrayList Lista = new ArrayList();
        Lista.add(Ficha.getEnergia().toString());
        Lista.add(Ficha.getCarboidrato().toString());
        Lista.add(Ficha.getProteina().toString());
        Lista.add(Ficha.getLipideo().toString());
        Lista.add(Ficha.getCalcio().toString());
        Lista.add(Ficha.getFerro().toString());
        Lista.add(Ficha.getVitaminac().toString());
        Lista.add(Ficha.getPesocru().toString());
        Lista.add(Ficha.getPesoliquido().toString());
        Lista.add(Ficha.getPrecoTotal().toString());    
        return Lista;
    }
    

}
