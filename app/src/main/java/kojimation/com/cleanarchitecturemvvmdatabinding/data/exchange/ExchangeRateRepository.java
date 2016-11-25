package kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange;

import rx.Observable;

/**
 * Created by muukojima on 2016/11/22.
 */

public interface ExchangeRateRepository {

    /**
     * 為替レートを取得
     *
     * @param base
     * @param symbols
     * @return
     */
    Observable<ExchangeRateResponse> getExchangeRate(String base, String symbols);
}