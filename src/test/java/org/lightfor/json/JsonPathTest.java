package org.lightfor.json;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

/**
 * json path test
 * Created by Light on 2017/7/3.
 */
public class JsonPathTest {

    @Test
    public void test1(){
        String json = "{\n" +
                "    \"took\": 21,\n" +
                "    \"timed_out\": false,\n" +
                "    \"_shards\": {\n" +
                "        \"total\": 5,\n" +
                "        \"successful\": 5,\n" +
                "        \"failed\": 0\n" +
                "    },\n" +
                "    \"hits\": {\n" +
                "        \"total\": 100,\n" +
                "        \"max_score\": 0.0,\n" +
                "        \"hits\": []\n" +
                "    },\n" +
                "    \"aggregations\": {\n" +
                "        \"ip\": {\n" +
                "            \"doc_count_error_upper_bound\": 0,\n" +
                "            \"sum_other_doc_count\": 0,\n" +
                "            \"buckets\": [{\n" +
                "                \"key\": \"10.10.0.0\",\n" +
                "                \"doc_count\": 50,\n" +
                "                \"metric\": {\n" +
                "                    \"doc_count_error_upper_bound\": 0,\n" +
                "                    \"sum_other_doc_count\": 0,\n" +
                "                    \"buckets\": [{\n" +
                "                        \"key\": \"test0\",\n" +
                "                        \"doc_count\": 17,\n" +
                "                        \"tagsStr\": {\n" +
                "                            \"doc_count_error_upper_bound\": 0,\n" +
                "                            \"sum_other_doc_count\": 0,\n" +
                "                            \"buckets\": [{\n" +
                "                                \"key\": \"mod=0,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=1,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=2,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=3,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=4,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }]\n" +
                "                        }\n" +
                "                    }, {\n" +
                "                        \"key\": \"test2\",\n" +
                "                        \"doc_count\": 17,\n" +
                "                        \"tagsStr\": {\n" +
                "                            \"doc_count_error_upper_bound\": 0,\n" +
                "                            \"sum_other_doc_count\": 0,\n" +
                "                            \"buckets\": [{\n" +
                "                                \"key\": \"mod=2,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=3,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=0,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=1,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=4,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }]\n" +
                "                        }\n" +
                "                    }, {\n" +
                "                        \"key\": \"test1\",\n" +
                "                        \"doc_count\": 16,\n" +
                "                        \"tagsStr\": {\n" +
                "                            \"doc_count_error_upper_bound\": 0,\n" +
                "                            \"sum_other_doc_count\": 0,\n" +
                "                            \"buckets\": [{\n" +
                "                                \"key\": \"mod=4,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=0,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=1,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=2,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=3,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }]\n" +
                "                        }\n" +
                "                    }]\n" +
                "                }\n" +
                "            }, {\n" +
                "                \"key\": \"10.10.0.1\",\n" +
                "                \"doc_count\": 50,\n" +
                "                \"metric\": {\n" +
                "                    \"doc_count_error_upper_bound\": 0,\n" +
                "                    \"sum_other_doc_count\": 0,\n" +
                "                    \"buckets\": [{\n" +
                "                        \"key\": \"test0\",\n" +
                "                        \"doc_count\": 17,\n" +
                "                        \"tagsStr\": {\n" +
                "                            \"doc_count_error_upper_bound\": 0,\n" +
                "                            \"sum_other_doc_count\": 0,\n" +
                "                            \"buckets\": [{\n" +
                "                                \"key\": \"mod=3,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=4,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=0,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=1,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=2,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }]\n" +
                "                        }\n" +
                "                    }, {\n" +
                "                        \"key\": \"test1\",\n" +
                "                        \"doc_count\": 17,\n" +
                "                        \"tagsStr\": {\n" +
                "                            \"doc_count_error_upper_bound\": 0,\n" +
                "                            \"sum_other_doc_count\": 0,\n" +
                "                            \"buckets\": [{\n" +
                "                                \"key\": \"mod=1,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=2,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=0,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=3,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=4,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }]\n" +
                "                        }\n" +
                "                    }, {\n" +
                "                        \"key\": \"test2\",\n" +
                "                        \"doc_count\": 16,\n" +
                "                        \"tagsStr\": {\n" +
                "                            \"doc_count_error_upper_bound\": 0,\n" +
                "                            \"sum_other_doc_count\": 0,\n" +
                "                            \"buckets\": [{\n" +
                "                                \"key\": \"mod=0,service=local,type=test\",\n" +
                "                                \"doc_count\": 4\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=1,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=2,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=3,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }, {\n" +
                "                                \"key\": \"mod=4,service=local,type=test\",\n" +
                "                                \"doc_count\": 3\n" +
                "                            }]\n" +
                "                        }\n" +
                "                    }]\n" +
                "                }\n" +
                "            }]\n" +
                "        }\n" +
                "    }\n" +
                "}";
        List<String> list = JsonPath.read(json, "$.aggregations.ip.buckets[*].key");
        System.out.println(list);
    }
}
