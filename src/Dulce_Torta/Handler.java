package Dulce_Torta;

import Dulce_Torta.Actors.Enums.TipoDocumento;

public class Handler {

    private Display display;

    public Handler(Display display) {
        this.display = display;
    }

    public Display getDisplay() {
        return display;
    }

    public TipoDocumento getTipoDocumento(){
       return display.tipoDoc;
    }
}
