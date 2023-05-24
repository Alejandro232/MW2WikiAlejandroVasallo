package mW2Wiki;

public class PartidaPersonalizada {

	private int idPartida;
    private int idArma;
    private int idModo;
    private int idMapa;
    private int idRachaBaja;

    public PartidaPersonalizada(int idPartida, int idArma, int idModo, int idMapa, int idRachaBaja) {
        this.idPartida = idPartida;
        this.idArma = idArma;
        this.idModo = idModo;
        this.idMapa = idMapa;
        this.idRachaBaja = idRachaBaja;
    }

    public PartidaPersonalizada(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdArma() {
        return idArma;
    }

    public void setIdArma(int idArma) {
        this.idArma = idArma;
    }

    public int getIdModo() {
        return idModo;
    }

    public void setIdModo(int idModo) {
        this.idModo = idModo;
    }

    public int getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(int idMapa) {
        this.idMapa = idMapa;
    }

    public int getIdRachaBaja() {
        return idRachaBaja;
    }

    public void setIdRachaBaja(int idRachaBaja) {
        this.idRachaBaja = idRachaBaja;
    }
	
	
	
	
}
