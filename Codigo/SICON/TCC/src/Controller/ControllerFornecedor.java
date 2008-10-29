/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.Funcoes;
import Classes.banco;
import Classes.dadosbancarios;
import Classes.fornecedor;
import Classes.perfil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ControllerFornecedor extends ControllerAncestral implements InterfaceControllerPadrao{
    
    private fornecedor Fornecedor;
    
    public ControllerFornecedor(){
        Fornecedor = new fornecedor();
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Fornecedor.LimparClasse();
        CarregarClasse(Objeto);
        return Fornecedor.Gravar(0);    
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Fornecedor.Gravar(1);  
    }

    @Override
    public boolean EventoExcluir() {
        return Fornecedor.Excluir();
    }
    
    public boolean AoSairCampoCnpj(String Cnpj){
        return Funcoes.ValidaCnpj(Cnpj);
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Fornecedor.LerClasse(id);
        return DevolverDadosClasse();   
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Fornecedor.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        Fornecedor.setCodigo(Objeto.get(0).toString());
        Fornecedor.setRazaosocial(Objeto.get(1).toString());
        Fornecedor.setCnpj(Objeto.get(2).toString());
        Fornecedor.setInscricaoestadual(Objeto.get(3).toString());
        Fornecedor.setCcm(Objeto.get(4).toString());
        Fornecedor.setCgc(Objeto.get(5).toString());
        Fornecedor.setRua(Objeto.get(6).toString());
        Fornecedor.setNumero(Objeto.get(7).toString());
        Fornecedor.setBairro(Objeto.get(8).toString());
        Fornecedor.setCidade(Objeto.get(9).toString());
        Fornecedor.setCep(Objeto.get(10).toString());
        Fornecedor.setSite(Objeto.get(11).toString());
        Fornecedor.setTempoentrega(Integer.parseInt(Objeto.get(12).toString()));
        dadosbancarios Bancario = new dadosbancarios();
        banco Banco = new banco();
        if (!(((ArrayList)Objeto.get(13)).get(0).toString().equals(""))) {
            Banco.LerClasse(Integer.parseInt(((ArrayList)Objeto.get(13)).get(0).toString()));
            Bancario.setBanco(Banco);
            Bancario.setAgencia(((ArrayList)Objeto.get(13)).get(1).toString());
            Bancario.setContacorrente(((ArrayList)Objeto.get(13)).get(2).toString());
            Bancario.setContacorrentedigito(((ArrayList)Objeto.get(13)).get(3).toString());        
        }
        Fornecedor.setdadosbancarios(Bancario);
    }
    
    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | codigo 
     *    1      | razaosocial
     *    2      | cnpj
     *    3      | inscriçãoestadual
     *    4      | ccm
     *    5      | cgc
     *    6      | rua
     *    7      | numero
     *    8      | bairro
     *    9      | cidade
     *   10      | cep
     *   11      | site
     *   12      | tempoentrega
     *   13      | dadosbancarios(ArrayList) --- 0 = banco(id) | 
     *                                           1 = Agencia| 2 = contacorrente | 3 =  COntaCorrenteDigito
     **************************************************************************/    

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList ArrayTela = new ArrayList();
        ArrayTela.add(Fornecedor.getCodigo());
        ArrayTela.add(Fornecedor.getRazaosocial());
        ArrayTela.add(Fornecedor.getCnpj());
        ArrayTela.add(Fornecedor.getInscricaoestadual());
        ArrayTela.add(Fornecedor.getCcm());
        ArrayTela.add(Fornecedor.getCgc());
        ArrayTela.add(Fornecedor.getRua());
        ArrayTela.add(Fornecedor.getNumero());
        ArrayTela.add(Fornecedor.getBairro());
        ArrayTela.add(Fornecedor.getCidade());
        ArrayTela.add(Fornecedor.getCep());
        ArrayTela.add(Fornecedor.getSite());
        ArrayTela.add(Fornecedor.getTempoentrega());
        ArrayList ListaDadosBancarios = new ArrayList();
        if (Fornecedor.getdadosbancarios() == null) {
            ListaDadosBancarios.add("");
            ListaDadosBancarios.add("");
            ListaDadosBancarios.add("");
            ListaDadosBancarios.add("");             
        } else {
            ListaDadosBancarios.add(Fornecedor.getdadosbancarios().getBanco().getIdbanco());
            ListaDadosBancarios.add(Fornecedor.getdadosbancarios().getAgencia());
            ListaDadosBancarios.add(Fornecedor.getdadosbancarios().getContacorrente());
            ListaDadosBancarios.add(Fornecedor.getdadosbancarios().getContacorrentedigito()); 
        }
        ArrayTela.add(ListaDadosBancarios);
        ArrayTela.add(Fornecedor.getIdfornecedor());        
        return ArrayTela;
    }

}
