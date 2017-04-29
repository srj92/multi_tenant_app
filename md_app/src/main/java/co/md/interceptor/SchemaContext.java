package co.md.interceptor;

public class SchemaContext {

	final public static String DEFAULT_SCHEMA = "default_schema";

	private static ThreadLocal<String> currentSchema = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return DEFAULT_SCHEMA;
		}
	};

	public static void setCurrentSchema(String schema) {
		currentSchema.set(schema);
	}

	public static String getCurrentSchema() {
		return currentSchema.get();
	}

	public static void clear() {
		currentSchema.remove();
	}
}
