package org.fosstrak.llrp.client;

import java.util.Map;

import org.apache.log4j.Logger;
import org.fosstrak.llrp.adaptor.exception.LLRPRuntimeException;

/**
 * helper class to instantiate the repository.
 * @author sawielan
 *
 */
public class RepositoryFactory {
	
	/** user-name in the arguments table. */
	public static final String ARG_USERNAME = "username";
	
	/** password in the arguments table. */
	public static final String ARG_PASSWRD = "password";
	
	/** JDBC string in the arguments table. */
	public static final String ARG_JDBC_STRING = "jdbcString";
	
	/** parameter whether to wipe DB in the arguments table. */
	public static final String ARG_WIPE_DB = "wipeDB";
	
	/** parameter whether to wipe RO_ACCESS_REPORTS DB in the arguments table.*/
	public static final String ARG_WIPE_RO_ACCESS_REPORTS_DB = "wipeROAccessDB";
	
	/** class name in the arguments table. */
	public static final String ARG_DB_CLASSNAME = "dbClassName";
	
	// the log4j logger.
	private static Logger log = Logger.getLogger(RepositoryFactory.class);
	
	/**
	 * create a new repository and read the configuration from a file.
	 * @param fileName the file where to obtain the configuration from.
	 * @return an instance of a {@link Repository}.
	 * @throws InstantiationException when no instantiation was possible.
	 * @throws IllegalAccessException access to class was denied.
	 * @throws ClassNotFoundException when the class is not existing.
	 */
	public static Repository create(String fileName) 
		throws InstantiationException, 
			IllegalAccessException, ClassNotFoundException {
		throw new IllegalAccessException("not implemented yet.");
	}
	
	/**
	 * create a new repository with the configuration parameters provided 
	 * via the parameters hash map.
	 * @param args a hash-map providing the parameters.
	 * @return an instance of a {@link Repository}.
	 * @throws InstantiationException when no instantiation was possible.
	 * @throws IllegalAccessException access to class was denied.
	 * @throws ClassNotFoundException when the class is not existing.
	 */
	public static Repository create(Map<String, String> args) 
	
		throws InstantiationException, 
			IllegalAccessException, ClassNotFoundException {

		if (null == args) throw new InstantiationException(
				"Args map is null!!! - aborting");
		
		Object db = Class.forName(args.get(ARG_DB_CLASSNAME)).newInstance();
		Repository repository = null;
		if (db instanceof Repository) {
			repository = (Repository) db;
			try {
			repository.initialize(args);
			repository.getROAccessRepository().initialize(repository);
			} catch (LLRPRuntimeException llrpe) {
				log.error(String.format("could not initialize: '%s'", 
						llrpe.getMessage()));
				repository = null;
			}
		} else {
			// throw an Exception
			log.error(String.format(
					"Implementing class is not of type Repository: 's'",
					args.get(RepositoryFactory.ARG_DB_CLASSNAME)));
			throw new InstantiationException(String.format(
					"Illegal implementing class: '%s'", 
					args.get(RepositoryFactory.ARG_DB_CLASSNAME)));
		}
		return repository;
	}
}