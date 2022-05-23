package cn.fastword.picture.handler;

public interface Values<K, V> {

    void addDatasetValue(K key, V value, String labelName);
}
