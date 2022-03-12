package Telas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {
	
	private Label lblTitulo = new Label("Menu Principal");
	private Button btnCadastrarMedico = new Button("Cadastro\n Médico");
	private Button btnCadastrarCliente = new Button("Cadastro\n Cliente");
	private Button btnCadastroAgenda = new Button ("Cadastrar\n Agenda");
	private Button btnConsultarAgenda = new Button("Consultar\n Agenda");
	

	private BorderPane criarJanela() {
		
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		FlowPane painelbotoes = new FlowPane();
		
		painelPrincipal.setCenter(painelCampos);
		painelPrincipal.setCenter(painelbotoes);
		painelPrincipal.setTop(lblTitulo);
		btnCadastrarMedico.setPrefSize(80, 60);
		btnCadastrarCliente.setPrefSize(80, 60);
		btnCadastroAgenda.setPrefSize(80, 60);
		btnConsultarAgenda.setPrefSize(80, 60);
		painelbotoes.getChildren().addAll(btnCadastrarMedico,btnCadastrarCliente,
									btnCadastroAgenda,btnConsultarAgenda);
		
		return painelPrincipal;
	}
	
	@Override
	public void start(Stage stage){
		Scene scn = new Scene(criarJanela(),600,300);
		
		btnCadastrarMedico.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {				
				TelaDoutor telaDoutor = new TelaDoutor();
				telaDoutor.start(stage);
			}	
		});
		
		btnCadastrarCliente.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {				
				TelaPaciente telaPaciente = new TelaPaciente();
				try {
					telaPaciente.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		});
		
		
		stage.setScene(scn);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		TelaPrincipal.launch(args);
	}

}
