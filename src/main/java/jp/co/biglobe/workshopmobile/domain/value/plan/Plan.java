package jp.co.biglobe.workshopmobile.domain.value.plan;

import jp.co.biglobe.workshopmobile.domain.value.fee.MonthlyFee;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * プラン
 */
@AllArgsConstructor
public enum Plan {
    ONE_GB(new MonthlyFee(1000)),
    THREE_GB(new MonthlyFee(2000)),
    THIRTY_GB(new MonthlyFee(6000))
    ;

    @Getter
    private final MonthlyFee monthlyFee;
}
