package Telas;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import Controler.ControlerDoutor;
import Entidade.Doutor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TelaDoutor extends Application {

	private Label lblId = new Label("Id");
	private TextField txtId =new TextField();
	private Label lblNome = new Label("Nome");
	private TextField txtNome =new TextField();
	private Label lblCpf = new Label("CPF");
	private TextField txtCpf =new TextField();
	private Label lblTelefone = new Label("Telefone");
	private TextField txtTelefone =new TextField();
	private Label lblDtnasc = new Label("Data Nasc");
	private TextField txtDtnasc =new TextField();
	private Label lblSexo = new Label("Sexo");
	private TextField txtSexo =new TextField();
	private Label lblEndereco = new Label("Endereço");
	private TextField txtEndereco =new TextField();
	private Label lblEspecialidade = new Label("Especialidade");
	private TextField txtEspecialidade =new TextField();
	private Label lblNumeroCro = new Label("Nº CRO");
	private TextField txtNumeroCro =new TextField();
	private Button btnAdcionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("PesquisarNome");

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	private ControlerDoutor controlerDoutor = new ControlerDoutor();
	
	
	public BorderPane criarjanela(){
		
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		TilePane painelBotoes = new TilePane();		
		painelPrincipal.setCenter(painelCampos);
		painelPrincipal.setBottom(painelBotoes);
		
		painelCampos.add(lblId, 0, 0);
		painelCampos.add(txtId, 1, 0);
		painelCampos.add(lblNome, 0, 1);
		painelCampos.add(txtNome, 1, 1);
		painelCampos.add(lblSexo, 0, 2);
		painelCampos.add(txtSexo, 1, 2);
		painelCampos.add(lblCpf, 0, 3);
		painelCampos.add(txtCpf, 1, 3);
		painelCampos.add(lblDtnasc, 2, 3);
		painelCampos.add(txtDtnasc, 3, 3);
		painelCampos.add(lblTelefone, 0, 4);
		painelCampos.add(txtTelefone, 1, 4);
		painelCampos.add(lblEndereco, 0, 5);
		painelCampos.add(txtEndereco, 1, 5);
		painelCampos.add(lblEspecialidade, 0, 6);
		painelCampos.add(txtEspecialidade, 1, 6);
		painelCampos.add(lblNumeroCro, 2, 6);
		painelCampos.add(txtNumeroCro, 3, 6);
		painelBotoes.getChildren().addAll(btnAdcionar,btnPesquisar);
	
		return painelPrincipal;
	}
	
	public Doutor doFormularioParaDoutor() {
		Doutor d = new Doutor();
		d.setId(Long.parseLong(txtId.getText()));
		d.setNome(txtNome.getText());
		d.setSexo(txtSexo.getText());
		d.setCpf(txtCpf.getText());
		d.setTelefone(txtTelefone.getText());
		d.setEndereco(txtEndereco.getText());
		d.setEspecialidade(txtEspecialidade.getText());
		d.setNumeroCro(Long.parseLong(txtNumeroCro.getText()));
		try {
			d.setDataNasc(sdf.parse(txtDtnasc.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;		
	}
	
	public void doDoutorParaFormulario(Doutor d) {
		txtId.setText(String.valueOf(d.getId()));
		txtNome.setText(d.getNome());
		txtCpf.setText(d.getCpf());
		txtSexo.setText(d.getSexo());
		txtNumeroCro.setText(String.valueOf(d.getNumeroCro()));
		txtEndereco.setText(d.getEndereco());
		txtTelefone.setText(d.getTelefone());
		txtEspecialidade.setText(d.getEspecialidade());
		txtDtnasc.setText(sdf.format(d.getDataNasc()));
	}
	
	
	@Override
	public void start(Stage stage){
		
		btnAdcionar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Doutor d = doFormularioParaDoutor();
				controlerDoutor.adicionarDoutor(d);		
				
			}
			
		});
		
		btnPesquisar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				String nome = txtNome.getText();
				Doutor d = controlerDoutor.pesquisarDoutorNome(nome);
				if(d!= null) {
					doDoutorParaFormulario(d);
				}
				
			}
			
		});
		
				
		Scene scn = new Scene(criarjanela(),600,300);
		stage.setScene(scn);
		stage.show();		
		
	}
	
	public static void main(String[] args) {
		TelaDoutor.launch(args);
	
	}
	
	

}
