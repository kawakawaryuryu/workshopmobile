package jp.co.biglobe.workshopmobile.domain;

import jp.co.biglobe.workshopmobile.domain.fee.MonthlyFee;
import lombok.Getter;

public enum EntameFreeOption {
    ON(new MonthlyFee(1200)),
    OFF(new MonthlyFee(0));

    @Getter
    private final MonthlyFee value;

    EntameFreeOption(MonthlyFee monthlyFee) {
        this.value = monthlyFee;
    }

    public static EntameFreeOption get(boolean isEntame) {
        return isEntame ? EntameFreeOption.ON : EntameFreeOption.OFF;
    }
}
