package jp.co.biglobe.workshopmobile.api.monthlyfee;

import jp.co.biglobe.workshopmobile.domain.EntameFreeOption;
import jp.co.biglobe.workshopmobile.domain.fee.MonthlyFee;
import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Request {
    // プラン
    private PlanForm plan;

    // 動画・音楽楽しみ放題　エンタメフリー・オプション
    private boolean entame_free;

    enum PlanForm {
        g1 {
            @Override
            Plan getPlan() {
                return Plan.ONE_GB;
            }
        }, // 1ギガ(スタート)
        g3 {
            @Override
            Plan getPlan() {
                return Plan.THREE_GB;
            }
        }, // 3ギガ
        g30 {
            @Override
            Plan getPlan() {
                return Plan.THIRTY_GB;
            }
        }; // 30ギガ

        abstract Plan getPlan();
    }

    public EntameFreeOption getEntame() {
        return EntameFreeOption.get(isEntame_free());
    }
}
