package Dulce_Torta;

import Dulce_Torta.Actors.Enums.TipoDocumento;
import Dulce_Torta.Databases.DataBaseManager;
import Dulce_Torta.GUI.*;
import Dulce_Torta.GUI.GUIP.*;
import Dulce_Torta.GUI.GUIP.Contabilidad.ContabilidadGUI;
import Dulce_Torta.GUI.RestablecerContraseña.RestablecerCntaGUI;

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

    public InicioSesionGUI getInicioSesionGUI(){ return display.inicioSesionGUI;}

    public RestablecerCntaGUI getRestablecerCntaGUI(){ return display.restablecerCntaGUI;}

    public ContabilidadGUI getContabilidadGUI(){ return display.contabilidadGUI;}

    public TipoDocumento getTipoDocumento(){
       return display.tipoDoc;
    }
}
