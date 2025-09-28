package fi.metropolia.model;

public class Currency {
    private int id;
    private String name;
    private String code;
    private double rate;

    public Currency(int id, String name, String code, double rate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.rate = rate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public double getRate() { return rate; }
}
