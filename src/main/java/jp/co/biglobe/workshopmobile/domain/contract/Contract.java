package jp.co.biglobe.workshopmobile.domain.contract;

import jp.co.biglobe.workshopmobile.domain.EntameFreeOption;
import jp.co.biglobe.workshopmobile.domain.enable.Enabled;
import jp.co.biglobe.workshopmobile.domain.fee.MonthlyFee;
import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Contract {

    private final Plan plan;
    private final EntameFreeOption entameFreeOption;
    private final Enabled enabled;

    public Contract(Plan plan, EntameFreeOption entameFreeOption) {
        this.plan = plan;
        this.entameFreeOption = entameFreeOption;
        if (entameFreeOption == EntameFreeOption.ON && plan == Plan.ONE_GB) {
            this.enabled = Enabled.DISABLED;
        } else {
            this.enabled = Enabled.ENABLED;
        }
    }

    public MonthlyFee getSumFee() {
        return new MonthlyFee(plan.getMonthlyFee().getValue() + entameFreeOption.getValue().getValue());
    }
}
