/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Controller.ControllerFornecedorProduto;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import javax.swing.JTextArea;
import org.apache.poi.hssf.dev.HSSF;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * Centraliza todos os processos de importação do sistema
 * @author Jonathan
 */
public class Importacao {
    
    private HSSFWorkbook hssfworkbook;
    private JTextArea componente;
    ControllerFornecedorProduto Controller;
    public Importacao() {
        
    }
    
    public void setComponenteVisual(JTextArea componente) {
        this.componente = componente;
    }
    /**
     * Importa planilha enviada pelo fornecedor no formato : Codigo, Descricao, Preço
     * @param fileName
     * @throws java.io.IOException
     */
    public String ImportarPrecos(String fileName, String idFornecedor) throws IOException {
        String coluna1 = "Código: ";
        String coluna2 = " Descrição: ";
        String coluna3 = " Preço: ";
        Controller = new ControllerFornecedorProduto();
        StringBuffer sbProblemas = new StringBuffer();
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fileName));
        hssfworkbook = new HSSFWorkbook(fs);
        HSSFSheet planilha  = hssfworkbook.getSheetAt(0);
        boolean fimArquivo = false;
        int i = 1;
        HSSFRow row = planilha.getRow(i);
        while (row != null) {
            HSSFCell celulaCodigo = row.getCell((short) 0);
            HSSFCell celulaDescricao = row.getCell((short) 1);
            HSSFCell celulaPreco = row.getCell((short) 2);
            try {
                Controller.EventoSalvar(idFornecedor, celulaCodigo.getStringCellValue(), new BigDecimal(celulaPreco.getNumericCellValue()));
                this.componente.append(coluna1 + celulaCodigo.getStringCellValue() +
                        coluna2 + celulaDescricao.getStringCellValue() + coluna3 + String.valueOf(celulaPreco.getNumericCellValue()) + "\n\r");
            } catch (Exception e) {
                e.printStackTrace();
                sbProblemas.append(", " + celulaCodigo);
            }
            i++;
            row = planilha.getRow(i);
        }
        return sbProblemas.toString();
    }


}
