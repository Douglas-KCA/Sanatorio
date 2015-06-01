/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import Interfaz.Inicio;

/**
 *
 * @author Douglas
 */
public class Hospital {
       private static String codigo_paciente;
       private static String codigo_persona;
       private static String codigo_cita;
       private static String codigo_paciente_cita;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Inicio ver = new Inicio();
        ver.setVisible(true);
    }

    /**
     * @return the codigo_paciente
     */
    public static String getCodigo_paciente() {
        return codigo_paciente;
    }

    /**
     * @param aCodigo_paciente the codigo_paciente to set
     */
    public static void setCodigo_paciente(String aCodigo_paciente) {
        codigo_paciente = aCodigo_paciente;
    }

    /**
     * @return the codigo_persona
     */
    public static String getCodigo_persona() {
        return codigo_persona;
    }

    /**
     * @param aCodigo_persona the codigo_persona to set
     */
    public static void setCodigo_persona(String aCodigo_persona) {
        codigo_persona = aCodigo_persona;
    }

    /**
     * @return the codigo_cita
     */
    public static String getCodigo_cita() {
        return codigo_cita;
    }

    /**
     * @param aCodigo_cita the codigo_cita to set
     */
    public static void setCodigo_cita(String aCodigo_cita) {
        codigo_cita = aCodigo_cita;
    }

    /**
     * @return the codigo_paciente_cita
     */
    public static String getCodigo_paciente_cita() {
        return codigo_paciente_cita;
    }

    /**
     * @param aCodigo_paciente_cita the codigo_paciente_cita to set
     */
    public static void setCodigo_paciente_cita(String aCodigo_paciente_cita) {
        codigo_paciente_cita = aCodigo_paciente_cita;
    }
    
}
