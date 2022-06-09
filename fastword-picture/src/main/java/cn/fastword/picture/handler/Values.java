package cn.fastword.picture.handler;

public interface Values<K, V, S> {

    void addDatasetValue(K key, V value, S labelName);
}
