package com.caocao.nio.geohash;

/**
 * Created by ilioili on 2015/5/21.
 */
public class GeoEncoder {

    public int[] getIndexPath(double lantitude, double longtitude){
        int[] path = new int[GeoConfig.LEVEL];
        //��ס�й��ľ�γ�ȴ��±߽�
        double lantitudeStart = GeoConfig.LANTITUDE_START;
        double lantitudeEnd = GeoConfig.LANTITUDE_END;
        double longtitudeStart = GeoConfig.LONGTITUDE_START;
        double longtitudeEnd = GeoConfig.LONGTITUDE_END;

        for(int i=0; i<GeoConfig.LEVEL; i++){
            if(longtitude*2>longtitudeStart+longtitudeEnd){//���ȣ��ң�
                if(lantitude*2>lantitudeEnd+lantitudeStart){//γ�ȣ��ϣ�
                    path[i] = 1;
                    longtitudeStart = (longtitudeStart+longtitudeEnd)/2;
                    lantitudeEnd = (lantitudeStart+lantitudeEnd)/2;
                }else{//γ�ȣ��£�
                    path[i] = 3;
                    longtitudeStart = (longtitudeStart+longtitudeEnd)/2;
                    lantitudeStart = (lantitudeStart+lantitudeEnd)/2;
                }
            }else{//���ȣ���
                if(lantitude*2>lantitudeEnd+lantitudeStart){//γ�ȣ��ϣ�
                    path[i] = 0;
                    longtitudeEnd = (longtitudeStart+longtitudeEnd)/2;
                    lantitudeEnd = (lantitudeStart+lantitudeEnd)/2;
                }else{//γ�ȣ��£�
                    path[i] = 2;
                    longtitudeEnd = (longtitudeStart+longtitudeEnd)/2;
                    lantitudeStart = (lantitudeStart+lantitudeEnd)/2;
                }
            }
        }
        return path;
    }
}
