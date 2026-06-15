package exercis;

import javax.print.attribute.standard.JobSheets;
import javax.swing.JOptionPane;

public class Ejes {
    public static void main() {
        int dia = Integer.parseInt(
                JOptionPane.showInputDialog(
                        """
                            ----------------- DIAS DE LA SEMANA -----------------
                                                1. Lunes.
                                                2. Martes.
                                                3. Miercoles.
                                                4. Jueves.
                                                5. Viernes
                                                6. Sabado.
                                                7. Domingo.
                        """
                )
        );

        if (dia >= 1 && dia <= 5)
            JOptionPane.showMessageDialog(null, "Semana lavoral");

        else if ( dia >= 6 && dia <= 7)
            JOptionPane.showMessageDialog(null, "A dormir.");
        else
            JOptionPane.showMessageDialog(null, "ERROR: dia incorrecto.");
    }
}
