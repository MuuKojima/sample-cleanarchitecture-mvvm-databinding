package kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange;

/**
 * Created by muukojima on 2016/11/22.
 */

public class ExchangeRateResponse {
    private String base;
    private String date;
    private CountryCode rates;

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public CountryCode getRates() {
        return rates;
    }
}