package Telas;

import Controler.ControlerUsuario;
import Entidade.Usuario;
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

public class TelaUsuario extends Application {
	
	private Label ldlIdUsuario = new Label("Id");
	private TextField txtIdUsuario = new TextField();
	private Label ldlNomeUsuario = new Label("Nome");
	private TextField txtNomeUsuario = new TextField();
	private Label ldlSenhaUsuario = new Label("Senha");
	private TextField txtSenhaUsuario = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	
	private ControlerUsuario controleUsuario = new ControlerUsuario();
	
	public BorderPane criartela() {
		
		BorderPane painelprincipal = new BorderPane();
		GridPane painelcampos = new GridPane();
		TilePane painelBotoes = new TilePane();
		
		painelprincipal.setCenter(painelcampos);
		painelprincipal.setBottom(painelBotoes);
		
		painelcampos.add(ldlIdUsuario, 0, 0);
		painelcampos.add(txtIdUsuario, 1, 0);
		painelcampos.add(ldlNomeUsuario, 0, 1);
		painelcampos.add(txtNomeUsuario, 1, 1);
		painelcampos.add(ldlSenhaUsuario, 0, 2);
		painelcampos.add(txtSenhaUsuario, 1, 2);
		
		painelBotoes.getChildren().add(btnAdicionar);
		
		return painelprincipal;
	}
	
	public Usuario dofornularioParaUsuario() {
		Usuario u = new Usuario ();
		
		u.setIdUsuario(txtIdUsuario.getText());
		u.setSenha(Long.parseLong(txtSenhaUsuario.getText()));
		
		return u;
	}

	@Override
	public void start(Stage stage){
		Scene scn = new Scene(criartela(),600,300);
		
		btnAdicionar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				Usuario u = dofornularioParaUsuario();
				controleUsuario.adicionarUsuario(u);
			}
			
		});
		
		
		stage.setScene(scn);
		stage.show();
		 
	}
	
	public static void main(String[] args) {
		TelaUsuario.launch(args);
		
		
	}
}
