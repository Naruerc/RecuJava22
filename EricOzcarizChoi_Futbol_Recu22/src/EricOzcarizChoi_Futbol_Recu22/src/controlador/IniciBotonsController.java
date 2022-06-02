package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class IniciBotonsController extends Application {

	private ResourceBundle texts;

	//Injecció dels panells i controls de la UI definida al fitxer fxml
	@FXML private Button btnJugadores;
	@FXML private Button btnEquipos;
	@FXML private Button btnDivisiones;
	@FXML private Button btnSortir; 

	private Connection conexionBD;

	public IniciBotonsController() {
		try{
			//Establir la connexio amb la BD
			String urlBaseDades = "jdbc:postgresql://localhost:5432/EricOzcarizChoi_Recuperacion2022";
			String usuari = "postgres";
			String contrasenya = "28522852Kk/";
			conexionBD = DriverManager.getConnection(urlBaseDades , usuari, contrasenya);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void start(Stage primaryStage) throws IOException {

		//Carrega el fitxer amb la interficie d'usuari inicial (Scene)
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/IniciBotonsView.fxml"));

		//Carregar fitxer de textos multiidioma de la localització actual
		Locale localitzacioDisplay = Locale.getDefault(Category.DISPLAY);
		texts = ResourceBundle.getBundle("vista.Texts", localitzacioDisplay);
		//fins aquí tot igual, només falta assignar el fitxer de recursos al formulari
		loader.setResources(texts);

		Scene fm_inici = new Scene(loader.load());

		//Li assigna la escena a la finestra inicial (primaryStage) i la mostra
		primaryStage.setScene(fm_inici);
		primaryStage.setTitle(texts.getString("title.agenda"));
		primaryStage.show();

	}

	@FXML
	private void onAction(ActionEvent e) throws Exception {
		System.out.println("Todas los personas");
		System.out.println("-------------------");
		if(e.getSource() == btnJugadores){//verifica si el botón es igual al que llamo al evento	
			changeScene("/vista/JugadoresView.fxml", "Jugadores");
		}else if(e.getSource() == btnDivisiones){
			changeScene("/vista/JugadoresView.fxml", "Divisiones");
		}else if(e.getSource() == btnEquipos){
			changeScene("/vista/JugadoresView.fxml", "Equipos");
		}else if(e.getSource() == btnSortir){
			Platform.exit();
		}
	}

	private void changeScene(String path, String title) throws IOException {

		//Carrega el fitxer amb la interficie d'usuari
		FXMLLoader loader = new FXMLLoader(getClass().getResource(path));

		//Carregar fitxer de textos multiidioma de la localització actual
		Locale localitzacioDisplay = Locale.getDefault(Category.DISPLAY);
		texts = ResourceBundle.getBundle("vista.Texts", localitzacioDisplay);
		loader.setResources(texts);


		System.out.println(getClass().getResource(path));
		System.out.println("-------------------");
		Stage stage = new Stage();
		Scene fm_scene = new Scene(loader.load());
		stage.setTitle(title);
		stage.setScene(fm_scene);
		stage.show();


		if(title.equalsIgnoreCase("Jugadores")) {
			JugadoresController jugadoresC = loader.getController();
			jugadoresC.setVentana(stage);
		}

		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
