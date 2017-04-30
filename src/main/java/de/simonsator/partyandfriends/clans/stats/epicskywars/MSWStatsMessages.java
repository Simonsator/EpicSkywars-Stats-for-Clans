package de.simonsator.partyandfriends.clans.stats.epicskywars;

import de.simonsator.partyandfriends.utilities.Language;
import de.simonsator.partyandfriends.utilities.LanguageConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author simonbrungs
 * @version 1.0.0 30.11.16
 */
public class MSWStatsMessages extends LanguageConfiguration {

	public MSWStatsMessages(Language pLanguage, File pFile) throws IOException {
		super(pLanguage, pFile);
		readFile();
		loadDefaultValues();
		saveFile();
		process(configuration);
	}

	private void loadDefaultValues() {
		set("Name", "SkyWars");
		set("Kills", "&7The clan has &a[KILLS] &7 kills.");
		set("Wins", "&7The clan has won &a[WINS] &7times.");
		set("Played", "&7The clan has played &a[PLAYED]&7 games.");
		set("Deaths", "&7The clan has died &c[DEATHS] &7times.");
	}

	public void reloadConfiguration() throws IOException {
		configuration = (new MSWStatsMessages(LANGUAGE.OWN, FILE)).getCreatedConfiguration();
	}
}
