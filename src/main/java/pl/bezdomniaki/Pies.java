package pl.bezdomniaki;

import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

public class Pies {
	private int id;
	private String imie;
	private Date dataPrzyjecia;
	private int idSchroniska;
	private String nrChipa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public Date getDataPrzyjecia() {
		return dataPrzyjecia;
	}
	public void setDataPrzyjecia(Date fdf) {
		this.dataPrzyjecia = fdf;
	}
	public int getIdSchroniska() {
		return idSchroniska;
	}
	public void setIdSchroniska(int idSchroniska) {
		this.idSchroniska = idSchroniska;
	}
	public String getNrChipa() {
		return nrChipa;
	}
	public void setNrChipa(String nrChripa) {
		this.nrChipa = nrChripa;
	}
	
	@Override
	public String toString() {
		return "Pies [id=" + id + ", imie=" + imie + ", dataPrzyjecia=" + dataPrzyjecia + ", idSchroniska="
				+ idSchroniska + ", nrChipa=" + nrChipa + "]";
	}
	
	
}
