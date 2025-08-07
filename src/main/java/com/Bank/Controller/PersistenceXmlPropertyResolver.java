package com.Bank.Controller;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.Properties;

	import javax.persistence.spi.PersistenceUnitInfo;
	import javax.persistence.spi.PersistenceUnitTransactionType;

	import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;

	public class PersistenceXmlPropertyResolver extends DefaultPersistenceUnitManager {
		protected void postProcessPersistenceUnitInfo(PersistenceUnitInfo pui) {
	        Properties originalProps = pui.getProperties();
	        Properties resolvedProps = new Properties();

	        for (String key : originalProps.stringPropertyNames()) {
	            String value = originalProps.getProperty(key);

	            // Check if value is like ${ENV_VAR_NAME}
	            if (value != null && value.startsWith("${") && value.endsWith("}")) {
	                String envVar = value.substring(2, value.length() - 1);
	                String resolvedValue = System.getenv(envVar);

	                if (resolvedValue != null) {
	                    resolvedProps.setProperty(key, resolvedValue);
	                } else {
	                    System.err.println("⚠️ Environment variable " + envVar + " is not set!");
	                }
	            } else {
	                resolvedProps.setProperty(key, value);
	            }
	        }

	        // Set resolved props
	        ((org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo) pui).setProperties(resolvedProps);
	    }
	  
	}

	

