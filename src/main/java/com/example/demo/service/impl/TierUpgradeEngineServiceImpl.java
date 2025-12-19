@Override
public List<TierHistoryRecord> getHistory(Long customerId) {
    return historyRepo.findByCustomerId(customerId);
}

@Override
public TierHistoryRecord getHistoryById(Long id) {
    return historyRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("History record not found"));
}

@Override
public List<TierHistoryRecord> getAllHistory() {
    return historyRepo.findAll();
}
