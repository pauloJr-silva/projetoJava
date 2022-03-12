package Telas;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import Controler.ControlerPaciente;
import Entidade.Paciente;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaPaciente extends Application {

	private Label lblIdPaciente = new Label("Id");
	private TextField txtIdPaciente = new TextField();
	private Label lblNomePaciente = new Label("Nome");
	private TextField txtNomePaciente = new TextField();
	private Label lblSexoPaciente = new Label("Sexo");
	private TextField txtSexoPaciente = new TextField();
	private Label lblRgPaciente = new Label("Rg");
	private TextField txtRgPaciente = new TextField();
	private Label lblCpfPaciente = new Label("Cpf");
	private TextField txtCpfPaciente = new TextField();
	private Label lblDataNascPaciente = new Label("Data Nascimento");
	private TextField txtDataNascPaciente = new TextField();
	private Label lblEnderecoPaciente = new Label("Endereço");
	private TextField txtEnderecoPaciente = new TextField();
	private Label lblTelefonePaciente = new Label("Telefone");
	private TextField txtTelefonePaciente = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private ControlerPaciente controlerPaciente = new ControlerPaciente();
	
	
	private BorderPane criarJanela() {
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		FlowPane painelBotoes = new FlowPane();
		
		painelPrincipal.setCenter(painelCampos);
		painelPrincipal.setBottom(painelBotoes);
		
		painelCampos.add(lblIdPaciente, 0, 0);
		painelCampos.add(txtIdPaciente, 1, 0);
		painelCampos.add(lblNomePaciente, 0, 1);
		painelCampos.add(txtNomePaciente, 1, 1);
		painelCampos.add(lblSexoPaciente, 0, 2);
		painelCampos.add(txtSexoPaciente, 1, 2);
		painelCampos.add(lblRgPaciente, 0, 3);
		painelCampos.add(txtRgPaciente, 1, 3);
		painelCampos.add(lblCpfPaciente, 2, 3);
		painelCampos.add(txtCpfPaciente, 3, 3);
		painelCampos.add(lblDataNascPaciente, 0, 4);
		painelCampos.add(txtDataNascPaciente, 1, 4);
		painelCampos.add(lblEnderecoPaciente, 0, 5);
		painelCampos.add(txtEnderecoPaciente, 1, 5);
		painelCampos.add(lblTelefonePaciente, 0, 6);
		painelCampos.add(txtTelefonePaciente, 1, 6);
		
		painelBotoes.getChildren().addAll(btnAdicionar,btnPesquisar);
		
		return painelPrincipal;
	}
	
	
	public Paciente doFormularioParaPaciente() {
		Paciente p = new Paciente();
		
		p.setId(Long.parseLong(txtIdPaciente.getText()));
		p.setNome(txtNomePaciente.getText());
		p.setRg(txtRgPaciente.getText());
		p.setCpf(txtCpfPaciente.getText());
		p.setSexo(txtSexoPaciente.getText());
			try {
				p.setDataNasc(sdf.parse(txtDataNascPaciente.getText()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		p.setEndereco(txtEnderecoPaciente.getText());
		p.setTelefone(txtTelefonePaciente.getText());	
		return p;
	}
	
	public void doPacienteParaFormulario(Paciente p) {
		txtIdPaciente.setText(String.valueOf(p.getId()));
		txtNomePaciente.setText(p.getNome());
		txtRgPaciente.setText(p.getRg());
		txtCpfPaciente.setText(p.getCpf());
		txtSexoPaciente.setText(p.getSexo());
		txtTelefonePaciente.setText(p.getTelefone());
		txtEnderecoPaciente.setText(p.getEndereco());
		txtDataNascPaciente.setText(sdf.format(p.getDataNasc()));
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Scene scr =new Scene(criarJanela(),600,300);
		
		btnAdicionar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Paciente p = doFormularioParaPaciente();
				controlerPaciente.adicionarPaciente(p);
			}
			
		});
		
		btnPesquisar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				String nome = txtNomePaciente.getText();
				Paciente p = controlerPaciente.pesquisarPacienteNome(nome);
				if (p!=null) {
					doPacienteParaFormulario(p);
				}		
				
			}
			
		});
		
		
		
		stage.setScene(scr);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		TelaPaciente.launch(args);
	}

}
