package Entity;

public class CurrencyEntity {
    private int cId;
    private String name;
    private int ratio;
    private String code;
    private double value;

    public CurrencyEntity() {
    }

    public CurrencyEntity(int cId, String name, int ratio, String code, double value) {
        this.cId = cId;
        this.name = name;
        this.ratio = ratio;
        this.code = code;
        this.value = value;
    }

    public int getcId() {
        return cId;
    }

    public String getName() {
        return name;
    }

    public int getRatio() {
        return ratio;
    }

    public String getCode() {
        return code;
    }

    public double getValue() {
        return value;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyEntity that = (CurrencyEntity) o;

        return cId == that.cId;
    }

    @Override
    public int hashCode() {
        return cId;
    }

    @Override
    public String toString() {
        return "CurrencyEntity{" +
                "cId=" + cId +
                ", name='" + name + '\'' +
                ", ratio=" + ratio +
                ", code='" + code + '\'' +
                ", value=" + value +
                '}';
    }
}
