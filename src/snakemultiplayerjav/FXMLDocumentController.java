package snakemultiplayerjav;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {

    
    static String nomeUtente;
    
    @FXML
    private Label registratiErrore;
    @FXML
    private TextField emailTxt;
    @FXML
    private Button button;
    @FXML
    private TextField utenteTxt;
    @FXML
    private TextField passTxt;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField confTxt;
    @FXML
    private TextField logUtenteTxt;
    @FXML
    private TextField logPasswordTxt;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    
    @FXML
    private void Registrati(ActionEvent event) throws MalformedURLException, IOException {
        
        String utente = utenteTxt.getText();      
        String password= passTxt.getText();  
        String passwordConf=confTxt.getText(); 
        String email= emailTxt.getText();
        
        //controllo sul esistenza dell'utente
        if(PHP.phpString("controlloUtente",utente)==false){
                   
                //la password viene passata al metodo controllaPsw della classe controlli 
                boolean c = Controlli.controllaPsw(password);
                //se la password è corretta si prosegue
                if(c==true){                   
                    
                    //se le due password sono uguali si continua 
                    if(password.equals(passwordConf)==true){                       
                         
                        //la mail viene passata al metodo controllaEmail della classe controlli 
                        boolean b = Controlli.controllaEmail(email);
                        
                        //se l' email è accettabile si prosegue
                        if(b==true){                                
                            
                            if(PHP.phpString("controlloMail",email)==false){
                                
                                registratiErrore.setText("Controllo esistenza mail in corso...");  
                                
                                boolean esistenzaMail = Mail.mail(email,utente);  
                                if(esistenzaMail==true){
                                
                                    boolean confReg = PHP.phpString("Register",utente,password,email);
                                    if(confReg==true){
                                        
                                        selModalità();

                                    }else
                                        registratiErrore.setText("Registrazione fallita.");                                     
                                }else
                                    registratiErrore.setText("Indirizzo email non valido ");
                            }else
                                registratiErrore.setText("Le mail è già utilizzata.");
                        }else
                            registratiErrore.setText("Le mail non è corretta.");                                               
                    }else
                        registratiErrore.setText("Le password devono combaciare.");                    
                }else 
                    registratiErrore.setText("La password deve contenere una maiuscola e essere lunga almeno 8 caratteri.");                    
        }else             
            registratiErrore.setText("Utente già registrato.");   
    }
    
    @FXML
    private void finestraRegistrazione(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Registrati.fxml"));
        AnchorPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void prova(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        AnchorPane.getChildren().setAll(pane);
    }
    
    
    @FXML
    private void accediHndl(ActionEvent event) throws IOException {
       
        String utente = logUtenteTxt.getText();
        nomeUtente = utente;
        String password= logPasswordTxt.getText();
        boolean confLog = PHP.phpString("Login",utente,password);
        if(confLog==true){
            
            selModalità();
        }
        if(confLog==false){
            
            //loginErrore.setText("Utente non registrato");
        }
    }    
        
    @FXML
    private void guestLog(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("SelezioneGuest.fxml"));
        AnchorPane.getChildren().setAll(pane);  
        
    }     
    
    @FXML
    private void btnOMP(ActionEvent event) throws IOException {
       
       snakeMain.snakeSes("snakeSP");
    }
    
    @FXML
    private void btnSP(ActionEvent event) throws IOException {
       
       snakeMain.snakeSes("snakeSP");
    }
    
    @FXML
    private void btnMP(ActionEvent event) throws IOException {
       
       snakeMain.snakeSes("snakeMP");
    }
    
    @FXML
    private void selModalità() throws IOException{
    
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Selezione.fxml"));
            AnchorPane.getChildren().setAll(pane);  
    }
    
    public static String getNome(){
        return nomeUtente;
    }
    
    
    
}
