package L_13.ex03;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GiftsList {
    private List<Map.Entry<String, Gift>> giftsList;

    public GiftsList() {
        this.giftsList = new LinkedList<>();
    }

    public void addGift(final String workerName, final Gift gift) {
        giftsList.add(new AbstractMap.SimpleImmutableEntry<>(workerName, gift));
    }

    public Map.Entry<String, Gift> get(final int idx) {
        return idx >= giftsList.size() ? null : giftsList.get(idx);
    }
}
