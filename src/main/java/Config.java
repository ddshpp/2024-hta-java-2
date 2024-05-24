public enum Config {

    DRIVER("com.mysql.cj.jdbc.Driver"),
    URL("jdbc:mysql://localhost/hta"),
    USER("root"),
    PASSWORD("!ajdajddl123");

    private final String value;

    Config(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
