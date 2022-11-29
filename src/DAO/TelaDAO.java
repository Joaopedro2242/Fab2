
package DAO;

import DTO.TelaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class TelaDAO {
    
    Connection conn;
    PreparedStatement pstm;
    public void cadastrarProduto(TelaDTO objteladto){
        String sql = "insert into produto (nome_produto, descri_produto, preco_produto) "
                + "values (?,?,?)";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objteladto.getNome_produto());
            pstm.setString(2, objteladto.getDescri_produto());
            pstm.setString(3, objteladto.getPreco_produto());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "TelaDAO" + e);
        }
    }
    
}
