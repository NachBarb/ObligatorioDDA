package modelo;

public class ModeloMonitoreo {
    private String numSector = "";
    
    public String getNumSector() {
        return numSector;
    }

    public void setNumSector(String numSector) {
        this.numSector = numSector;
    }
    
    public void updateNumSector(String caracter) {
       setNumSector(numSector.concat(caracter));
    }   
}
