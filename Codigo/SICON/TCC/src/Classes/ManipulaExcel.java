/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 *
 * @author Jonathan
 */
public class ManipulaExcel {
    
    private static String CaminhoDoArquivo;

    public static String getCaminhoArquivo() {
        return CaminhoDoArquivo;
    }

    public static void setCaminhoArquivo(String aCaminhoArquivo) {
        CaminhoDoArquivo = aCaminhoArquivo;
    }
    
    public ManipulaExcel(){}

    /**
     * Gera um arquivo do excel(xls) para ser enviado ao coordenador
     * retorna o Caminho/nome do arquivo gerado;
     */
    public String GerarArquivoFornecedor(Vector ListaPedido) throws Exception{
         String NomeArquivo;
         NomeArquivo = "LP" + "-" + ((Vector)ListaPedido.get(0)).get(5).toString();
         String CaminhoArquivo = "c:/" + NomeArquivo + ".xls";
         FileOutputStream stream = new FileOutputStream(CaminhoArquivo);        
         HSSFWorkbook objExcel = new HSSFWorkbook();
         HSSFSheet objPlanilha = objExcel.createSheet("Lista de Pedido");
         HSSFRow objLinhaCabecalho = objPlanilha.createRow(0); 
         HSSFCell celula = objLinhaCabecalho.createCell((short)0);
         HSSFCellStyle estilo = objExcel.createCellStyle();
         estilo.setFillBackgroundColor(HSSFColor.GREY_40_PERCENT.index);
         celula.setCellValue("Código Produto");
         //estilo.setFillForegroundColor(new HSSFColor.BLUE().getIndex());      
         //objLinhaCabecalho.createCell((short)0).setCellValue("Código Produto");         
         //objLinhaCabecalho.getCell((short)0).setCellStyle(estilo);            
         objLinhaCabecalho.createCell((short)1).setCellValue("Descrição");
         //objLinhaCabecalho.getCell((short)1).setCellStyle(estilo);
         objLinhaCabecalho.createCell((short)2).setCellValue("Qtde");
         //objLinhaCabecalho.getCell((short)2).setCellStyle(estilo);
         objLinhaCabecalho.createCell((short)3).setCellValue("Unidade de Medida");
         //objLinhaCabecalho.getCell((short)3).setCellStyle(estilo);
         objLinhaCabecalho.createCell((short)4).setCellValue("Data de Entrega");            
         //objLinhaCabecalho.getCell((short)4).setCellStyle(estilo);
         int contLinha = 1;
         for (Iterator<Vector> it = ListaPedido.iterator(); it.hasNext();) {
            Vector item = it.next();
            HSSFRow objLinha = objPlanilha.createRow(contLinha);
            objLinha.createCell((short)0).setCellValue(item.get(0).toString());
            objLinha.createCell((short)1).setCellValue(item.get(1).toString());
            objLinha.createCell((short)2).setCellValue(new Double(item.get(2).toString()));
            objLinha.createCell((short)3).setCellValue(item.get(3).toString());
            objLinha.createCell((short)4).setCellValue(item.get(4).toString());            
            contLinha++;
        }         
         celula.setCellStyle(estilo);
         CaminhoDoArquivo = CaminhoArquivo;
         objExcel.write(stream);
         return CaminhoArquivo;
    }
}
