package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:environmentConfig/${env}.properties" })
public interface Environment extends Config {
	@Key("App.Url")
	String appUrl();

	@Key("App.User")
	String appUsername();

	@Key("App.Pass")
	String appPassword();

	@Key("DB.Host")
	String DBHostname();

	@Key("DB.User")
	String DBUsername();

	@Key("DB.Pass")
	String DBPassword();
}
