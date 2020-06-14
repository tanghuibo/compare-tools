package io.tanghuibo.github.comparetools.service.impl;

import io.tanghuibo.github.comparetools.param.CompareParam;
import io.tanghuibo.github.comparetools.service.ComparePropertiesService;
import io.tanghuibo.github.comparetools.vo.CompareResult;
import io.tanghuibo.github.comparetools.vo.CompareResultBuilder;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tanghuibo
 * @date 2020/6/14下午9:57
 */
@Service
public class ComparePropertiesServiceImpl implements ComparePropertiesService {

    @Override
    public CompareResult<String, String> compare(CompareParam<String> compareParam) throws IOException {
        CompareResultBuilder<String, String> compareResultBuilder = new CompareResultBuilder<>();

        String oldData = compareParam.getOldData();
        String newData = compareParam.getNewData();

        Properties oldProperties = getPropertiesByString(oldData);
        Properties newProperties = getPropertiesByString(newData);

        Set<Map.Entry<Object, Object>> oldSet = oldProperties.entrySet();
        Set<Map.Entry<Object, Object>> newSet = newProperties.entrySet();

        List<Map.Entry<Object, Object>> oldList = oldSet.stream().sorted(Comparator.comparing(entry -> entry.getKey().toString())).collect(Collectors.toList());
        List<Map.Entry<Object, Object>> newList = newSet.stream().sorted(Comparator.comparing(entry -> entry.getKey().toString())).collect(Collectors.toList());

        Iterator<Map.Entry<Object, Object>> oldIterator = oldList.iterator();
        Iterator<Map.Entry<Object, Object>> newIterator = newList.iterator();

        Map.Entry<Object, Object> oldEntry = getNext(oldIterator);
        Map.Entry<Object, Object> newEntry = getNext(newIterator);

        while (oldEntry != null && newEntry != null) {

            String oldKey = String.valueOf(oldEntry.getKey());
            String oldValue = String.valueOf(oldEntry.getValue());
            String newKey = String.valueOf(newEntry.getKey());
            String newValue = String.valueOf(newEntry.getValue());

            int compareInt = oldKey.compareTo(newKey);

            if(compareInt == 0) {
                oldEntry = getNext(oldIterator);
                newEntry = getNext(newIterator);
                if(!Objects.equals(oldValue, newValue)) {
                    compareResultBuilder.insertDiff(oldKey, oldValue, newValue);
                }
                continue;
            }

            if(compareInt > 0) {
                newEntry = getNext(newIterator);
                compareResultBuilder.insertAdd(newKey, newValue);
                continue;
            }

            oldEntry = getNext(oldIterator);
            compareResultBuilder.insertRemove(oldKey, oldValue);

        }

        while(oldEntry != null) {
            String key = String.valueOf(oldEntry.getKey());
            String value = String.valueOf(oldEntry.getValue());
            compareResultBuilder.insertRemove(key, value);
            oldEntry = getNext(oldIterator);
        }
        while(newEntry != null) {
            String key = String.valueOf(newEntry.getKey());
            String value = String.valueOf(newEntry.getValue());
            compareResultBuilder.insertAdd(key, value);
            newEntry = getNext(newIterator);
        }

        return compareResultBuilder.build();
    }



    private <T> T getNext(Iterator<T> iterator) {
        return iterator.hasNext() ? iterator.next() : null;
    }

    private Properties getPropertiesByString(String propertiesStr) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new ByteArrayInputStream(propertiesStr.getBytes(Charset.defaultCharset()));
        properties.load(inputStream);
        return properties;
    }
}
