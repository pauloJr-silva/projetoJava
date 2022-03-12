package Telas;

import Entidade.Usuario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaLogin extends Application {
	
	private Label lblNomeUsuario = new Label("Usuário");
	private TextField txtNomeUsuario = new TextField();
	private Label lblSenhaUsuario = new Label("Senha");
	private PasswordField txtSenhaUsuario = new PasswordField();
	private Button btnAcessar = new Button("Acessar");
	private Button btnCancelar = new Button("Cancelar");
		
	
	public BorderPane criarJanela() {
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		FlowPane painelBotoes = new FlowPane();
		
		painelPrincipal.setCenter(painelCampos);
		painelPrincipal.setBottom(painelBotoes);
		
		painelCampos.add(lblNomeUsuario, 0, 0);
		lblNomeUsuario.centerShapeProperty();
		painelCampos.add(txtNomeUsuario, 1, 0);
		painelCampos.add(lblSenhaUsuario, 0, 1);
		painelCampos.add(txtSenhaUsuario, 1, 1);
		
		painelBotoes.getChildren().addAll(btnAcessar,btnCancelar);	
		
		return painelPrincipal;
	}

	@Override
	public void start(Stage stage) {
		Scene scr = new Scene(criarJanela(),300,100);
		
		btnAcessar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {	
				Usuario u = new Usuario();
				if(txtNomeUsuario.getText().equals(u.getNomeUsuario()) && 
								txtSenhaUsuario.getText().equals(String.valueOf(u.getSenha()))) {
					
					TelaPrincipal tela = new TelaPrincipal();
					tela.start(stage);
			
				}				
			}
		});
		
		btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);		
			}
			
		});
		
		
		stage.centerOnScreen();
		stage.setScene(scr);
		stage.show();
	}
	
	public static void main(String[] args) {
		TelaLogin.launch(args);
	}

}
