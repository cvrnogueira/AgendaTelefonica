package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import bdagenda.agendaDAO;

public class agendaDAOderby implements agendaDAO  {
	private Connection conexao;
	public agendaDAOderby() throws SQLException{
		conexao = DriverManager.getConnection(BDInfo.SERVER, BDInfo.USER, BDInfo.PASSWORD);
	}
    public ArrayList<String> listarTodasPessoas() throws SQLException{
		ArrayList<String> pessoas = new ArrayList<String>();
        String comandoSQL = "SELECT nome, telefone FROM NOMETEL ORDER BY nome";
        PreparedStatement consultaSQL = conexao.prepareStatement(comandoSQL); 
        //mando executar a consulta
        ResultSet registros = consultaSQL.executeQuery(); 

        while(registros.next()){
            String nome = registros.getString("nome");
            String telefone = registros.getString("telefone");
            pessoas.add(nome);
            pessoas.add(telefone);
        }
        //fecha tudo!
        registros.close();
        consultaSQL.close();
        return pessoas;
    }
   
	 public void inserirNovaPessoa(String nomeNovo, String telNovo) throws SQLException{
	        Scanner in = new Scanner(System.in);      
	        Connection conexao = DriverManager.getConnection(BDInfo.SERVER, BDInfo.USER, BDInfo.PASSWORD); 
	        String comandoSQL = "INSERT INTO NOMETEL(nome, telefone) VALUES (?, ?)";
	        PreparedStatement stmt = conexao.prepareStatement(comandoSQL); //se perapar para mandar o comando comandoSQL no banco
	        
	        stmt.setString(1,nomeNovo);
	        stmt.setString(2,telNovo);
	        stmt.execute();
	        
	        stmt.close();
	        conexao.close();
	    }
		public ArrayList<String> getFonePeloNome(String nome) throws SQLException {
			ArrayList<String> telefones = new ArrayList<String>();
			 String comandoSQL = "SELECT telefone FROM NOMETEL WHERE NOMETEL.nome = \'" + nome + "\' ";
		        PreparedStatement consultaSQL = conexao.prepareStatement(comandoSQL); 
		        //mando executar a consulta
		        ResultSet registros = consultaSQL.executeQuery(); 
		        while(registros.next()){
		            String telefone = registros.getString("telefone");
		            telefones.add(telefone);
		        }
		        //fecha tudo!
		        registros.close();
		        consultaSQL.close();
		        return telefones;
			
		}
		public void sair() throws SQLException{
			conexao.close();
		}
   
}
