package weather;

/**
 * Created by admin on 8/27/2016.
 */
public class Weather {
    private String cityName, countryName;
    private int rain,temp,wind,humidity,pressure ;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public Weather(String cityName, String countryName, int humidity, int pressure, int rain, int temp, int wind) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.humidity = humidity;
        this.pressure = pressure;
        this.rain = rain;
        this.temp = temp;
        this.wind = wind;
    }
}
