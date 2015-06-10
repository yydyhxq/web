package com.caocao.nio.geohash;

import java.util.HashSet;

public class GeoTreeSet {
	public GeoTree root = new GeoTree();

	public HashSet getEndSet(String indexPath){
		GeoTree geoTree = root;
		char[] value = indexPath.toCharArray();
		for(int i=0; i<value.length; i++){
			value[i] -= '1';
		}
		for(int i=0; i<GeoConfig.LEVEL; i++){
			GeoTree leaf = (GeoTree) geoTree.getLeaf(value[i]);
			if(null==leaf){
				synchronized (geoTree){
					if(null==geoTree.getLeaf(value[i])){
						leaf = new GeoTree();
						geoTree.setLeaf(leaf, value[i]);
					}else{
						leaf = (GeoTree) geoTree.getLeaf(value[i]);
					}
				}
			}
			geoTree = leaf;
		}

		HashSet endSet = (HashSet) geoTree.getLeaf(value[GeoConfig.LEVEL]);
		if(endSet==null){
			endSet = new HashSet();
		}

		return endSet;
	}


}
