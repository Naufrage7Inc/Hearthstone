package capacite;

import carte.Serviteur;
import exception.HearthstoneException;

public class Charge extends Capacite {

	/**
	 * Instancie une classe charge
	 */
	public Charge() {
		super("Charge", "Cette capacité permet à un serviteur de ne pas attendre avant d'attaquer");
	}

	/**
	 * Permet au serviteur d'attaquer s'il dispose de la capacité charge
	 */
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		Serviteur s = (Serviteur) cible;
		s.setPeutAttaquer(true);
	}

	/**
	 * Fonction toString de Charge
	 */
	public String toString() {
		return super.toString() + " -> Charge []";
	}
}
