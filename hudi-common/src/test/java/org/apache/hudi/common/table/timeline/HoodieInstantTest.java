package org.apache.hudi.common.table.timeline;

import org.apache.hudi.common.util.CollectionUtils;
import org.apache.hudi.common.util.StringUtils;
import org.junit.Test;

import java.util.Comparator;
import java.util.Map;

public class HoodieInstantTest {

  private static final Map<String, String> COMPARABLE_ACTIONS =
          CollectionUtils.createImmutableMap(HoodieTimeline.COMPACTION_ACTION, HoodieTimeline.COMMIT_ACTION);

  public static final Comparator<HoodieInstant> ACTION_COMPARATOR =
          Comparator.comparing(instant -> HoodieInstant.getComparableAction(instant.getAction()));

  public static final Comparator<HoodieInstant> COMPARATOR = Comparator.comparing(HoodieInstant::getTimestamp)
          .thenComparing(ACTION_COMPARATOR).thenComparing(HoodieInstant::getState);

  @Test
  public void test01() {
    String s = StringUtils.join("instantTime", HoodieTimeline.INFLIGHT_COMMIT_EXTENSION);
    System.out.println(s);

  }

  @Test
  public void test02() {
    String s = StringUtils.join(".", "compaction", ".inflight");
    System.out.println(s);
  }

}
