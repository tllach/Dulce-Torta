package Dulce_Torta;

import Dulce_Torta.Actors.Enums.TipoDocumento;
import Dulce_Torta.Databases.DataBaseManager;
import Dulce_Torta.GUI.*;
import Dulce_Torta.GUI.GUIP.*;

public class Handler {

    private Display display;

    public Handler(Display display) {
        this.display = display;
    }

    public Display getDisplay() {
        return display;
    }

    public DataBaseManager getBaseManager() { return display.dataBaseManager; }

    public PantallaPrincipalGUI getPrincipalGUI() { return display.pantallaPrincipalGUI;}

    public Manager getManager() { return display.manager;}

    public ClientesGUI getClientesGUI(){ return display.clientesGUI;}

    public OrdenGUI getOrdenGUI(){ return display.ordenGUI;}

    public EmpleadosGUI getEmpleadosGUI(){ return display.empleadosGUI;}

    public TipoDocumento getTipoDocumento(){
       return display.tipoDoc;
    }
}
