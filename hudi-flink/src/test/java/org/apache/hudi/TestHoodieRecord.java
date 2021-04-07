package org.apache.hudi;

import org.apache.hudi.common.util.CollectionUtils;
import org.apache.hudi.common.util.collection.Pair;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestHoodieRecord {
  public static final String COMMIT_TIME_METADATA_FIELD = "_hoodie_commit_time";
  public static final String COMMIT_SEQNO_METADATA_FIELD = "_hoodie_commit_seqno";
  public static final String RECORD_KEY_METADATA_FIELD = "_hoodie_record_key";
  public static final String PARTITION_PATH_METADATA_FIELD = "_hoodie_partition_path";
  public static final String FILENAME_METADATA_FIELD = "_hoodie_file_name";

  public static final List<String> HOODIE_META_COLUMNS =
          CollectionUtils.createImmutableList(COMMIT_TIME_METADATA_FIELD, COMMIT_SEQNO_METADATA_FIELD,
                  RECORD_KEY_METADATA_FIELD, PARTITION_PATH_METADATA_FIELD, FILENAME_METADATA_FIELD);

  public static final Map<String, Integer> HOODIE_META_COLUMNS_NAME_TO_POS =
          IntStream.range(0, HOODIE_META_COLUMNS.size()).mapToObj(idx -> Pair.of(HOODIE_META_COLUMNS.get(idx), idx))
                  .collect(Collectors.toMap(Pair::getKey, Pair::getValue));

  @Test
  public void test01() {
    System.out.println(HOODIE_META_COLUMNS_NAME_TO_POS);
  }
}
