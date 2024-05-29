package Tarea2;

import javax.swing.JOptionPane;

public class Verificador {

    public String rut;
    public int rutConvertido;

    public boolean getCheckEmpty(String a) {

        if (a.equals("")) {
            return true;
        } else {
            String rutIngresado = getLimpiarRut(a);
            this.rut = rutIngresado;

            return false;
        }

    }

    public String calcularDigitoVerificador(String inputRut) {

        int[] serie = {2, 3, 4, 5, 6, 7};
        int[] rut = new int[inputRut.length()];
        int acumulador =0;

        for (int i = 0; i < inputRut.length(); i++) {

            rut[i] = Character.getNumericValue(inputRut.charAt(i));

        }

        if(rut.length>serie.length){

        }
        for (int j = 0; j< inputRut.length(); j++) {
            acumulador += serie[j % 6] * rut[j % rut.length];
        }
        
        int division = acumulador/11;
        int resultadoSinDecimales = (int) Math.floor(division);
        int resultadoDivido = resultadoSinDecimales * 11;
        
         int resta = acumulador - resultadoDivido;
         int resultadoFinal = 11 - resta;
         String resultadoString = String.valueOf(resultadoFinal);
         String result = resultadoString;
         if(resultadoString.equals("10")){
             result = "k";
         }else if(resultadoString.equals("11")){
             result = "0";
         }
            
        return result;
    }

    public String getLimpiarRut(String rut) {
        String rutLimpio = rut.replace(".", "").replace("-", "");

        if (rutLimpio.length() == 9) {
            rutLimpio = rutLimpio.substring(0, 8);

        } else if (rutLimpio.length() < 7) {
            JOptionPane.showMessageDialog(null, "El rut no tiene el largo suficiente", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        } else if (rutLimpio.length() > 9) {
            JOptionPane.showMessageDialog(null, "El rut no corresponde a un rut Chileno", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }
        return rutLimpio;

    }

    public boolean getCheckIsNumber() {
        try {
            setConvertir();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public String getReverseNumber(String rut) {
        String rutReves = new StringBuilder(rut).reverse().toString();
        return rutReves;
    }

    public void setConvertir() {
        this.rutConvertido = Integer.parseInt(rut);
    }

    public String getRevertString(String rut) {

        return "a";
    }

}
