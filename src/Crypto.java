public class Crypto {

    private String icon;
    private String name;
    private double coast;


    public Crypto() {
        this.icon = "default";
        this.name="default";
        this.coast=0;
    }

    public Crypto(String icon) {
        this.icon = icon;
        this.name="default";
        this.coast=0;
    }

    public Crypto(String icon, String name) {
        this.icon = icon;
        this.name = name;
        this.coast = 0;
    }

    public Crypto(String icon, String name, double coast) {
        this.icon = icon;
        this.name = name;
        this.coast = coast;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }


}
