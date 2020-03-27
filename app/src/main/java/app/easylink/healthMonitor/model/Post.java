package app.easylink.healthMonitor.model;

public class Post {

    private String provincestate;
    private String countryregion;
    private String lastupdate;
   // Location LocationObject;
    private float confirmed;
    private float deaths;
    private float recovered;


    private float lat;
    private float lng;

    // Getter Methods

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    // Setter Methods

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    // Getter Methods

    public String getProvincestate() {
        return provincestate;
    }

    public String getCountryregion() {
        return countryregion;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    /*
    public Location getLocation() {
        return LocationObject;
    }

     */

    public float getConfirmed() {
        return confirmed;
    }

    public float getDeaths() {
        return deaths;
    }

    public float getRecovered() {
        return recovered;
    }

    // Setter Methods

    public void setProvincestate( String provincestate ) {
        this.provincestate = provincestate;
    }

    public void setCountryregion( String countryregion ) {
        this.countryregion = countryregion;
    }

    public void setLastupdate( String lastupdate ) {
        this.lastupdate = lastupdate;
    }

    /*
    public void setLocation( Location locationObject ) {


     */

    public void setConfirmed( float confirmed ) {
        this.confirmed = confirmed;
    }

    public void setDeaths( float deaths ) {
        this.deaths = deaths;
    }

    public void setRecovered( float recovered ) {
        this.recovered = recovered;
    }

}
