public class Event {

	private String secteur;
	private String theme;
	private String dateE;
	private String lieu;
	private int organisateur;
	private String type;
	private String desc;
	private String titre;

	public Event() {
		// TODO - implement Event.Event
		throw new UnsupportedOperationException();
	}

    public String getSecteur() {
        return secteur;
    }

    public String getTheme() {
        return theme;
    }

    public String getDateE() {
        return dateE;
    }

    public String getLieu() {
        return lieu;
    }

    public int getOrganisateur() {
        return organisateur;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitre() {
        return titre;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setDateE(String dateE) {
        this.dateE = dateE;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setOrganisateur(int organisateur) {
        this.organisateur = organisateur;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
        

}