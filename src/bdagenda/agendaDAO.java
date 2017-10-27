package bdagenda;

import java.sql.SQLException;
import java.util.ArrayList;

public interface agendaDAO {
	public ArrayList<String> listarTodasPessoas() throws SQLException;
	public void inserirNovaPessoa(String nome, String telefone) throws SQLException;
	public ArrayList<String> getFonePeloNome(String nome) throws SQLException;
}
