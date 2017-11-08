package bdagenda;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import dados.agendaDAOderby;
public class BDAgenda {

	private agendaDAOderby agenda;
    	public BDAgenda() throws SQLException{
    		agenda = new agendaDAOderby();
    	}
        Scanner in = new Scanner(System.in);
        String nomeBusca;
        String lixo;
    	ArrayList<String> array = new ArrayList<String>();
    	
    	public agendaDAOderby returnAgenda(){
    		return agenda;
    	}
//        int opcao =1;
//        do{
//            mostrarMenu();
//            opcao = in.nextInt();
//            lixo = in.nextLine();
//            
//            switch(opcao){
//                case 01:{
//                	array = agenda.listarTodasPessoas(); 
//                	for(String pessoa: array){
//                		System.out.println(pessoa);
//                	}
//                	break;
//                }
//                case 02: {
//                	System.out.println("Dados da pessoa");
//         	        System.out.println("Nome: ");
//         	        String nomeNovo = in.nextLine();
//         	        System.out.println("Telefone: ");
//         	        String telNovo = in.nextLine();
//         	        System.out.println("Inserindo nova pessoa...");
//                 	agenda.inserirNovaPessoa(nomeNovo, telNovo); 
//        	        System.out.println("Pessoa Inserida na agenda!");
//                 	break;
//                }
//                case 03: {
//                		System.out.println("Digite o nome");
//                		nomeBusca=  in.nextLine();
//                		array = agenda.getFonePeloNome(nomeBusca);
//                    	for(String telefone: array){
//                    		System.out.println(telefone);
//                    	}
//                    	break;                	
//                    }
//                
//                default: throw new AssertionError();
//            }
//        }while(opcao!=0);
//        agenda.listarTodasPessoas();
//      }
        
    public static void mostrarMenu(){
        System.out.println("=============================");
        System.out.println("|     Agenda telefonica      |");
        System.out.println("=============================");
        System.out.println("\t 1. Listar Todos");
        System.out.println("\t 2. Incluir");
        System.out.println("\t 3. Buscar por nome");
    } 
    
}

