package jp.co.biglobe.workshopmobile.domain.value.fee;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 月額料金
 */
@AllArgsConstructor
public class MonthlyFee {
    @Getter
    private final int value;
}
