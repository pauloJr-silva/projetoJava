package Telas;

import java.util.Date;
import Entidade.Agenda;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TelaAgneda extends Application {

	private Label lblNomeMedico = new Label("Nome Médico"); 
	private TextField txtNomeMedico = new TextField();
	private Label lblNumeroCro = new Label ("Nº CRO");
	private TextField txtNumeroCro = new TextField();
	private Label lblNomePaciente = new Label("Nome Paciente"); 
	private TextField txtNomePaciente = new TextField();
	private Label lblDataNascPaciente = new Label("Data Nasc"); 
	private TextField txtDataNascpaciente = new TextField();
	private Label lblDataConsulta = new Label("Data da Consulta"); 
	private TextField txtDataConsulta = new TextField();
	private Button btnAdicionar = new Button ("Adicionar");
	private Button btnCancelar = new Button ("Cancelar");
	private Button btnPesquisarDoutor = new Button("...");
	private Button btnPesquisarPaciente = new Button("...");
	
	private TableView<Agenda> tabelaAgenda(){
		
		TableView<Agenda> tabelaAgenda = new TableView<Agenda>();
		TableColumn<Agenda, Long> id = new TableColumn<>("Id");
		TableColumn<Agenda, String> nomeDoutor = new TableColumn<>("Nome Doutor");
		TableColumn<Agenda, Long> numeroCro = new TableColumn<>("N° CRO");
		TableColumn< Agenda,String> nomePaciente = new TableColumn<>("Nome Paciente");
		TableColumn< Agenda,Date> datNasc = new TableColumn<>("Dt. Nasc. Paciente");
		TableColumn<Agenda, Date> datConsulta = new TableColumn<>("Data Consulta");
		TableColumn<Agenda, Date> horaConsulta = new TableColumn<>("Hora Consulta");
		tabelaAgenda.getColumns().addAll(id,nomeDoutor,numeroCro,nomePaciente,datNasc,datNasc,horaConsulta);
		
		return tabelaAgenda;
	}
	
	
	
	public BorderPane criarJanela() {
		
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelcampos = new GridPane();
		TilePane painelBotoes = new TilePane();
		FlowPane painelTabela = new FlowPane();		
		painelPrincipal.setTop(painelcampos);
		painelPrincipal.setCenter(painelBotoes);
		painelPrincipal.setBottom(painelTabela);
		painelTabela.getChildren().add(tabelaAgenda());
		painelcampos.add(lblNomeMedico, 0, 0);
		painelcampos.add(txtNomeMedico, 1, 0);
		painelcampos.add(btnPesquisarDoutor, 2, 0);
		painelcampos.add(lblNumeroCro, 3, 0);
		painelcampos.add(txtNumeroCro, 4, 0);
		painelcampos.add(lblNomePaciente, 0, 1);
		painelcampos.add(txtNomePaciente, 1, 1);
		painelcampos.add(btnPesquisarPaciente, 2, 1);
		painelcampos.add(lblDataNascPaciente, 3, 1);
		painelcampos.add(txtDataNascpaciente, 4, 1);
		painelcampos.add(lblDataConsulta, 0, 2);
		painelcampos.add(txtDataConsulta, 1, 2);
		painelBotoes.getChildren().addAll(btnAdicionar,btnCancelar);
		return painelPrincipal;
	}
	
	
	
	
	@Override
	public void start(Stage stage){
		
		Scene scn = new Scene(criarJanela(),600,300);
		
		stage.setScene(scn);
		stage.show();
	}
	
	public static void main(String[] args) {
		TelaAgneda.launch(args);
	}

}
