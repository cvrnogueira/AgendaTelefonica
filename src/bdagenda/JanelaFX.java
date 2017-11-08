package bdagenda;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;

public class JanelaFX extends Application  {

	private TextField consultaNome;
	private TextField nome;
	private TextField telefone;
	private BDAgenda agenda;
	private static TextArea textArea;
	//Window stage = null;
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		setup();
		textArea = new TextArea();
		
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: #1abc9c;");
		GridPane leftPane = new GridPane();
		leftPane.setAlignment(Pos.CENTER);
		leftPane.setHgap(10);
		leftPane.setVgap(10);
		leftPane.setPadding(new Insets(10, 10, 10, 10));
	
		//----botões--//
		Button btnGetFonePeloNome = new Button("Get Fone pelo Nome");
		btnGetFonePeloNome.setPrefWidth(250);
		btnGetFonePeloNome.setStyle("-fx-background-color:#ecf0f1");
		leftPane.add(btnGetFonePeloNome, 1, 9);
		Button btnConsulta = new Button("Lista Todos");
		btnConsulta.setPrefWidth(250);
		btnConsulta.setStyle("-fx-background-color:#ecf0f1");
		leftPane.add(btnConsulta, 0, 9);
		Button btnInserirNovo = new Button("Inserir Novo");
		btnInserirNovo.setPrefWidth(250);
		btnInserirNovo.setStyle("-fx-background-color:#ecf0f1");
		leftPane.add(btnInserirNovo, 2, 9);
		
		//-----Número do caixa do banco---/
//		String[] options = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//		consultaNumCaixa = new ComboBox<String>(FXCollections.observableArrayList(options));
//		leftPane.add(consultaNumCaixa, 0, 8);
//		consultaNumCaixa.setStyle("-fx-background-color:#ecf0f1");
//		consultaNumCaixa.setPromptText("Número do caixa");
//		btnConsultaNumCaixa.setOnAction(e -> {
//			if(consultaNumCaixa.getSelectionModel().getSelectedItem() != null){
//				//consultaNumCaixa();
//			}
//        });
	
		//--nome e tel do usu para cadastrar--//
		nome = new TextField("Nome");
		nome.setPrefWidth(200);
		nome.setStyle("-fx-background-color:#ecf0f1");
		telefone = new TextField("Telefone");
		telefone.setPrefWidth(200);
		telefone.setStyle("-fx-background-color:#ecf0f1");
		leftPane.add(nome, 3, 7);
		leftPane.add(telefone, 3, 8);
		
		//-----Nome do usuário a ser buscado---/
		consultaNome = new TextField("Nome");
		consultaNome.setPrefWidth(200);
		consultaNome.setStyle("-fx-background-color:#ecf0f1");
		leftPane.add(consultaNome, 1, 7);
		
		btnConsulta.setOnAction(e -> {
				try {
					listarTodasPessoas();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		});
		
		btnGetFonePeloNome.setOnAction(e -> {
				if(consultaNome.getText() != null){
					try {
						getFonePeloNome(consultaNome.getText());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
		
		btnInserirNovo.setOnAction(e -> {
			if(nome.getText() != null && telefone.getText() != null){
				try {
					insereUsuario(nome.getText(),telefone.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
			
		
		VBox root = new VBox();
		root.setPadding(new Insets(10));
		root.setSpacing(5);
		root.getChildren().add(new Label("Output:"));
		root.getChildren().add(textArea);

		pane.setLeft(leftPane);
		pane.setBottom(root);
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Agenda Telefônica");
	
		primaryStage.show();
	}
	
	private void setup() throws SQLException {
		agenda = new BDAgenda();
	}
	
	public void listarTodasPessoas() throws SQLException{
		textArea.setText(" ");
		ArrayList<String> pessoas = new ArrayList<String>();
		pessoas = agenda.returnAgenda().listarTodasPessoas();
		
		for(String pessoa: pessoas){
			textArea.appendText(pessoa);
			textArea.appendText("\n");
		}

	}
	
	public void getFonePeloNome(String nome) throws SQLException{
		textArea.setText(" ");
		ArrayList<String> telefones = new ArrayList<String>();
		telefones = agenda.returnAgenda().getFonePeloNome(nome);
		
		for(String telefone: telefones){
			textArea.appendText(telefone);
			textArea.appendText("\n");
		}

	}
	
	public void insereUsuario(String nome, String telefone) throws SQLException{
		textArea.setText(" ");
		agenda.returnAgenda().inserirNovaPessoa(nome, telefone);
	
			textArea.setText("Usuário inserido!");
	}


}