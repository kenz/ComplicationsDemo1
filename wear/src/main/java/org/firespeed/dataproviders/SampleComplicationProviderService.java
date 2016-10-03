package org.firespeed.dataproviders;

import android.support.wearable.complications.ComplicationData;
import android.support.wearable.complications.ComplicationManager;
import android.support.wearable.complications.ComplicationProviderService;
import android.support.wearable.complications.ComplicationText;
import android.util.Log;

import static android.support.wearable.complications.ComplicationData.TYPE_SHORT_TEXT;

/**
 * Complication Watch Face DataProviderがデータを提供するためのサービス
 */
public class SampleComplicationProviderService extends ComplicationProviderService {
    /**
     * データを返してほしいときに呼ばれる
     *
     * @param complicationId      画面上に置かれたWatch Face Complicationごとに一意となるID
     * @param type                表示するデータのType
     * @param complicationManager ComplicationManager 結果を渡す
     */
    @Override
    public void onComplicationUpdate(int complicationId, int type, ComplicationManager complicationManager) {
        int value = (int) (Math.random() * 100);
        Log.w("hogehoge", String.valueOf(value));
        if (type == TYPE_SHORT_TEXT) {
            ComplicationData complicationData = new ComplicationData.Builder(ComplicationData.TYPE_SHORT_TEXT)
                    .setShortText(ComplicationText.plainText(String.valueOf(value)))
                    .build();
            complicationManager.updateComplicationData(complicationId, complicationData);
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("hogehoge", "onCreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("hogehoge", "onDestroy()");
    }
}
