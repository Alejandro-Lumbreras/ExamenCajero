package com.mycompany.app;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller<campos> {

    public Button btn100;
    public Button btn200;
    public Button btn500;
    public Button btn1000;
    public TextField txt_MontoRetirar;
    public Button btnContinuar;
    public Button btnBorrar;
    public Button btnVolver;
    public TextField txt_Saldo;
    public Button btnRetirar;
    public PasswordField txt_NIPActual;
    public PasswordField txt_NuevoNIP;
    public PasswordField txt_ConfirmacionNIP;
    public Button btnGuardar;
    public TextField txt_MontoTransferir;
    public TextField txt_NumCuentaT;
    public Button btnContinuarT;
    public Button Consulta;

    static float saldo;
    public Button btnAgua;
    public Button btnPagar;
    public Button btnLuz;
    public Button btnCable;
    public TextField txtPago;
    static int Posicion;
    static int h=0;
    @FXML void initialize(){

        if(h==0){
            NIPS=Cuenta.CargarCuenta();
            h++;
        }
    }

    public void Volver(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
        stage.show();
        stage = (Stage) btnVolver.getScene().getWindow();
        stage.close();
    }

    public void cSaldo(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Consulta.fxml"));
        stage.show();
        stage = (Stage) Consulta.getScene().getWindow();
        stage.close();
    }

    //Retirar

    public void Retirar100(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/RetiroListo.fxml"));
        stage.show();
        stage = (Stage) btn100.getScene().getWindow();
        stage.close();
        int monto=100;
        if(saldo>monto){
            saldo =saldo-monto;
            System.out.println(saldo);
        }else{
            JOptionPane.showMessageDialog(null,"NO TIENES DINERO SUFICIENTE PARA COMPLETAR EL RETIRO SORRY :(");
        }
    }
    public void Retirar200(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/RetiroListo.fxml"));
        stage.show();
        stage = (Stage) btn200.getScene().getWindow();
        stage.close();
        int monto=200;
        if(saldo>monto){
            saldo =saldo-monto;
            System.out.println(saldo);
        }else{
            JOptionPane.showMessageDialog(null,"NO TIENES DINERO SUFICIENTE PARA COMPLETAR EL RETIRO SORRY :(");
        }
    }

    public void Retirar500(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/RetiroListo.fxml"));
        stage.show();
        stage = (Stage) btn500.getScene().getWindow();
        stage.close();
        int monto=500;
        if(saldo>monto){
            saldo =saldo-monto;
            System.out.println(saldo);
        }else{
            JOptionPane.showMessageDialog(null,"NO TIENES DINERO SUFICIENTE PARA COMPLETAR EL RETIRO SORRY :(");
        }
    }

    public void Retirar1000(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/RetiroListo.fxml"));
        stage.show();
        stage = (Stage) btn1000.getScene().getWindow();
        stage.close();
        int monto=1000;
        if(saldo>monto){
            saldo =saldo-monto;
            System.out.println(saldo);
        }else{
            JOptionPane.showMessageDialog(null,"NO TIENES DINERO SUFICIENTE PARA COMPLETAR EL RETIRO SORRY :(");
        }
    }


    public void Continuar(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/RetiroListo.fxml"));
        stage.show();
        stage = (Stage) btnContinuar.getScene().getWindow();
        stage.close();
        float montoRetirar;
        montoRetirar = Float.parseFloat(this.txt_MontoRetirar.getText());
        if(saldo>montoRetirar){
            saldo =saldo-montoRetirar;
            System.out.println(saldo);
        }else {
            JOptionPane.showMessageDialog(null, "NO TIENES DINERO SUFICIENTE PARA COMPLETAR EL RETIRO SORRY :(");
        }
    }

    //Consulta

    public void Retirar(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Retirar.fxml"));
        stage.show();
        stage = (Stage) btnRetirar.getScene().getWindow();
        stage.close();
    }

    public void ConsultarSaldo(ActionEvent actionEvent) throws IOException {
        float sDisponible=saldo;
        System.out.println("yuju"+saldo);
        this.txt_Saldo.setText(String.valueOf(sDisponible));

    }

    //PagoServicios
    public void pagarAgua(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Agua.fxml"));
        stage.show();
        stage = (Stage) btnAgua.getScene().getWindow();
        stage.close();
    }

    public void pagarCable(ActionEvent actionEvent) throws IOException {
     Stage stage = FXMLLoader.load(getClass().getResource("/Cable.fxml"));
        stage.show();
        stage = (Stage) btnCable.getScene().getWindow();
        stage.close();
    }

    public void pagarLuz(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Luz.fxml"));
        stage.show();
        stage = (Stage) btnLuz.getScene().getWindow();
        stage.close();

    }

    public void Pagar(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/PagoListo.fxml"));
        stage.show();
        stage = (Stage) btnPagar.getScene().getWindow();
        stage.close();
        float pago;
        pago = Float.parseFloat(this.txtPago.getText());
        if(saldo>pago){
            saldo =saldo-pago;
            System.out.println(saldo);
        }else {
            JOptionPane.showMessageDialog(null, "NO TIENES DINERO SUFICIENTE PARA COMPLETAR EL RETIRO SORRY :(");
        }
    }

    //NIP
    List<Tarjeta> NIPS=new ArrayList<>();
    public void Guardar(ActionEvent actionEvent) throws IOException {
        Posicion=FController.Posicion;
        if(txt_NIPActual.getText().equals(NIPS.get(Posicion).NIP)){
            System.out.println("Entre");
            if(txt_ConfirmacionNIP.getText().equals(txt_NuevoNIP.getText())){
                System.out.println("Entra");
                JOptionPane.showMessageDialog(null,"EXCELENTE LA CONTRASEÑA SE HA CAMBIADO CORRECTAMENTE");
                NIPS.get(Posicion).NIP=txt_ConfirmacionNIP.getText();
                Cuenta.GuardarNipes(NIPS);
            }
        }


    }


    public void MontoTransferir(ActionEvent actionEvent) {
    }

    public void NumCuentaTransferir(ActionEvent actionEvent) {
    }

    public void ContinuarT(ActionEvent actionEvent) {
    }

    public void MontoRetirar(ActionEvent actionEvent) {
    }



    public void NIPActual(ActionEvent actionEvent) {
    }

    public void NuevoNIP(ActionEvent actionEvent) {
    }

    public void ConfirmarNIP(ActionEvent actionEvent) {
    }

}
