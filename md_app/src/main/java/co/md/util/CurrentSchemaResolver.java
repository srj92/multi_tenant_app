package co.md.util;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import co.md.interceptor.SchemaContext;

@Component
public class CurrentSchemaResolver implements CurrentTenantIdentifierResolver  {
									 
	@Override
	public String resolveCurrentTenantIdentifier() {
		return SchemaContext.getCurrentSchema();
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}
