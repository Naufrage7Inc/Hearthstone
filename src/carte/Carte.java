package carte;

import capacite.Capacite;
import capacite.EffetPermanent;
import exception.HearthstoneException;
import joueur.IJoueur;

public abstract class Carte implements ICarte {
	
	private String nom;
	private int cout;
	private IJoueur proprietaire;
	protected Capacite capacite;
	
	/**
	 * Instancie une nouvelle Carte
	 * 
	 * @param nom le nom de la carte
	 * @param cout le cout de la carte
	 * @param capacite la capacité de la carte
	 * @param proprietaire le proprietaire de la carte
	 */
	public Carte(String nom, int cout, Capacite capacite, IJoueur proprietaire) {
		this.setNom(nom);
		this.setCout(cout);
		this.setProprietaire(proprietaire);
		this.setCapacite(capacite);
	}

	/**
	 * Attribue le nom de la carte
	 * 
	 * @param nom le nom de la carte
	 */
	private void setNom(String nom) {
		if ( nom == null )
			throw new IllegalArgumentException("Le nom de la carte ne peut pas être nul !");
		
		this.nom = nom;
	}
	
	/**
	 * Attribue le cout de la carte
	 * 
	 * @param cout le cout de la carte
	 */
	private void setCout(int cout) {
		if ( cout < 0 )
			throw new IllegalArgumentException("Le cout de la carte ne peut pas être une valeur négative !");
		
		this.cout = cout;
	}
	
	/**
	 * Attribue le propriétaire de la carte
	 * 
	 * @param proprietaire le propriétaire de la carte
	 */
	private void setProprietaire(IJoueur proprietaire) {
		if ( proprietaire == null )
			throw new IllegalArgumentException("Le propriétaire ne peut pas être nul !");
		
		this.proprietaire = proprietaire;
	}
	
	/**
	 * Attribue la capacité au sort
	 * 
	 * @param capacite la capacité
	 */
	private void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}
	
	/**
	 * Retourne la capacité de la carte
	 * 
	 * @return la capacité de la carte
	 */
	public Capacite getCapacite() {
		return this.capacite;
	}
	
	@Override
	public String getNom() {
		return this.nom;
	}
	
	@Override
	public int getCout() {
		return this.cout;
	}

	@Override
	public IJoueur getProprietaire() {
		return this.proprietaire;
	}

	@Override
	public abstract void executerEffetDebutTour(Object cible) throws HearthstoneException;

	@Override
	public abstract void executerEffetFinTour(Object cible) throws HearthstoneException;

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
		for ( ICarte carte : proprietaire.getJeu() ) {
			if ( carte.getCapacite() instanceof EffetPermanent )
				carte.getCapacite().executerAction(this);
		}
	}

	@Override
	public abstract void executerEffetDisparition(Object cible) throws HearthstoneException;

	@Override
	public abstract void executerAction(Object cible) throws HearthstoneException;
	
	@Override
	public abstract boolean disparait();
	
	@Override
	public String toString() {
		return "Carte";
	}

}
