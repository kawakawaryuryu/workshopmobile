package jp.co.biglobe.workshopmobile.api.monthlyfee;

import jp.co.biglobe.workshopmobile.domain.EntameFreeOption;
import jp.co.biglobe.workshopmobile.domain.contract.Contract;
import jp.co.biglobe.workshopmobile.domain.enable.Enabled;
import jp.co.biglobe.workshopmobile.domain.plan.Plan;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class MonthlyFeeApi {

    @RequestMapping(value = "/monthly-fee", method = RequestMethod.GET)
    public Map invoke(
            Request request
    ) {
        Plan plan = request.getPlan().getPlan();
        EntameFreeOption entame = request.getEntame();
        Contract contract = new Contract(plan, entame);
        if (contract.getEnabled() == Enabled.DISABLED) {
            throw new RuntimeException();
        }
        Map<String, Object> res = new HashMap<>();
        res.put("monthly_fee", contract.getSumFee());
        return res;
    }
}
