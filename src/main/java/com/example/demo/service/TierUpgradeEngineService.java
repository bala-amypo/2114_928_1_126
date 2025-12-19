import com.example.demo.model.TierHistoryRecord;

import java.util.List;

public interface TierUpgradeEngineService {

    CustomerProfile applyTierUpgrade(Long customerId);

    List<TierHistoryRecord> getHistory(Long customerId);

    TierHistoryRecord getHistoryById(Long id);

    List<TierHistoryRecord> getAllHistory();
}
