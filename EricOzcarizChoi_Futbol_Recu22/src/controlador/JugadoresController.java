package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.Locale;
import java.util.Locale.Category;

import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Jugadores;
import model.JugadoresDao;
import model.Posicion;

public class JugadoresController {

	//Objecte per gestionar la persistència de les dades
		private JugadoresDao jugDao;
		
		private ObservableList<Jugadores> jugadoresData;
		//Elements gràfics de la UI
		
		private Stage ventana;
		@FXML private TextField idTextField;
		@FXML private TextField nombreTextField;
		@FXML private TextField dorsalTextField;
		@FXML private TextField posicionTextField;
		@FXML private TextField golesMarcadosTextField;
		@FXML private TextField nacionalidadTextField;

		private ValidationSupport vs;

		/**
		 * Inicialitza la classe. JAVA l'executa automàticament després de carregar el fitxer fxml
		 */
		@FXML private void initialize() {
			//Obrir el fitxer de persones
			jugDao = new JugadoresDao();

			//Validació dades
			//https://github.com/controlsfx/controlsfx/issues/1148
			//produeix error si no posem a les VM arguments això: --add-opens=javafx.graphics/javafx.scene=ALL-UNNAMED
			vs = new ValidationSupport();
			vs.registerValidator(idTextField, true, Validator.createEmptyValidator("ID obligatorio"));
			vs.registerValidator(nombreTextField, true, Validator.createEmptyValidator("Nombre obligatorio"));
			vs.registerValidator(posicionTextField, true, Validator.createEmptyValidator("Posicion obligatoria"));
			vs.registerValidator(dorsalTextField, true, Validator.createEmptyValidator("Dorsal obligatorio"));
			vs.registerValidator(golesMarcadosTextField, true, Validator.createEmptyValidator("Goles obligatorio"));
			vs.registerValidator(nacionalidadTextField, true, Validator.createEmptyValidator("Nacionalidad obligatorio"));
		      
		}

		public Stage getVentana() {
			return ventana;
		}

		public void setVentana(Stage ventana) {
			this.ventana = ventana;
		}
		
		public void setConexionBD(Connection conexionBD) {	
			//Crear objecte DAO de pokemons
			jugDao = new JugadoresDao();
			
			// Aprofitar per carregar la taula de pokemons (no ho podem fer al initialize() perque encara no tenim l'objecte conexionBD)
			// https://code.makery.ch/es/library/javafx-tutorial/part2/
//			jugadoresData = FXCollections.observableList(jugDao.getPokemonsList());
//			pokemonsTable.setItems(pokemonsData);
		}

//		@FXML private void onKeyPressedId(KeyEvent e) throws IOException {
//
//			if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.TAB){
//				//Comprovar si existeix la persona indicada en el control idTextField
//				Persona persona = persones.find(Integer.parseInt(idTextField.getText()));
//				if(persona != null){ 
//					//posar els valors per modificarlos
//					nomTextField.setText(persona.getNom());
//					cognomsTextField.setText(persona.getApellidos());
//					emailTextField.setText(persona.getEmail());
//					telefonTextField.setText(persona.getTelefon());
//				}else{ 
//					//nou registre
//					nomTextField.setText("");
//					cognomsTextField.setText("");
//					emailTextField.setText("");
//					telefonTextField.setText("");
//				}
//			}
//		}
		

		 
		@FXML private void onActionGuardar(ActionEvent e) throws IOException {
			//verificar si les dades són vàlides				
			if(isDatosValidos()){
				Jugadores jugador = new Jugadores(Integer.parseInt(idTextField.getText()),
						nombreTextField.getText(), Integer.parseInt(dorsalTextField.getText()),
						Posicion.valueOf(posicionTextField.getText()),Integer.parseInt(golesMarcadosTextField.getText()),
						nacionalidadTextField.getText());
				System.out.println(jugador);
				jugDao.guardar(jugador);
				limpiarFormulario();
				jugDao.mostrarTodos();
			}
		}

		@FXML private void onActionEliminar(ActionEvent e) throws IOException {

//			if(isDatosValidos()){
				if(jugDao.eliminar(Integer.parseInt(idTextField.getText()))){
					limpiarFormulario();
					jugDao.mostrarTodos();
				}else {
					limpiarFormulario();
					System.out.println("Jugador no encontrado, no se puede borrar");					
				}
//			}
		}
		
		@FXML private void onActionEncontrar(ActionEvent e) throws IOException {

//			if(isDatosValidos()){
				Jugadores jugEncontrado=jugDao.encontrar(Integer.parseInt(idTextField.getText()));
					limpiarFormulario();
					if(jugEncontrado!=null) {
					System.out.println("Jugador encontrado:");
					System.out.println(jugEncontrado);
					}
					else {						
						System.out.println("Jugador NO encontrado");						
					}
				
//			}
		}

		@FXML private void onActionSortir(ActionEvent e) throws IOException {

//			sortir();

			ventana.close();
		}

//		public void sortir(){
//			persones.saveAll();
//			persones.showAll();
//		}

		private boolean isDatosValidos() {

			//Comprovar si totes les dades són vàlides
			if (vs.isInvalid()) {
				String errors = vs.getValidationResult().getMessages().toString();
				// Mostrar finestra amb els errors
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.initOwner(ventana);
				alert.setTitle("Camps incorrectes");
				alert.setHeaderText("Corregeix els camps incorrectes");
				alert.setContentText(errors);
				alert.showAndWait();
			
				return false;
			}

			return true;

		}
		


		private void limpiarFormulario(){
			idTextField.setText("");
			nombreTextField.setText("");
			dorsalTextField.setText("");
			posicionTextField.setText("");
			golesMarcadosTextField.setText("");
			nacionalidadTextField.setText("");
		}
}
