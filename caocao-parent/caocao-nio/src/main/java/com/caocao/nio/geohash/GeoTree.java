package com.caocao.nio.geohash;

public class GeoTree {
    private Object[] leafs = new Object[4];

    public GeoTree() {
    }

    final public Object getLeaf(int index) {
        return leafs[index];
    }

    final public void setLeaf(Object obj, int index) {
        leafs[index] = obj;
    }

}
