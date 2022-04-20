package methods;

public enum Status {
    OK("solution has been found sucessfully");
    private String description;

    Status(String s) {this.description = s;}

    public String getDescription() { return this.description; }
}
