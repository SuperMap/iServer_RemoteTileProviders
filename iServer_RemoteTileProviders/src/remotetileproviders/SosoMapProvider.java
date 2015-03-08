package remotetileproviders;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import com.supermap.services.components.commontypes.Point2D;
import com.supermap.services.components.commontypes.Rectangle2D;
import com.supermap.services.util.PrjCoordSysConversionTool;

/**
 * <p>
 * Soso地图服务提供者
 * </p>
 * <table width="800">
 * <th>地图相关参数</th>
 *  <tr><td width="100">级别</td><td>4-18级</td></tr>
 *  <tr><td width="100">投影</td><td>WGS84 Web Mercator</td></tr>
 *  <tr><td width="100">切片原点</td><td>-20037508.342789244, 20037508.342789091</td></tr>
 *  <tr><td width="100">全图范围</td><td>-20037508.342789244, -20037508.34278914, 20037508.342789244, 20037508.342789091</td></tr>
 *  <tr><td width="100">比例尺</td><td>2.7042617145642484E-8, 5.408523429128497E-8, 1.0817046858256994E-7, 2.1634093716513987E-7, 4.3268187433027975E-7,
                8.653637486605595E-7, 1.730727497321119E-6, 3.461454994642238E-6, 6.922909989284476E-6, 1.3845819978568952E-5, 2.7691639957137904E-5,
                5.538327991427581E-5, 1.1076655982855162E-4, 2.2153311965710323E-4, 4.4306623931420646E-4</td></tr>
    <tr><td width="100">X轴</td><td>正方向向右</td></tr>
    <tr><td width="100">Y轴</td><td>正方向向上</td></tr>
 */
public class SosoMapProvider extends ProviderBase {

    /**
     * <p>
     * 获取地图参数对象集合。
     * </p>
     * @return 地图参数对象集合。
     */
    @Override
    public List<RemoteTileMapParameter> remoteTileMapParameters() {
        /**
         * 构造一个地图参数对象，设置地图参数
         * 需要设置地图参数包括有：地图名mapName、地图切图原点origin、地图全图范围bounds、地图的投影prjCoordSys、地图比例尺集合、地图分辨率集合、构造在线瓦片的url地址
         */
        final RemoteTileMapParameter mapParameter = new RemoteTileMapParameter();
        mapParameter.mapName = "SosoMap";
        mapParameter.origin = new Point2D(-20037508.342789244, 20037508.342789091);
        mapParameter.bounds = new Rectangle2D(-20037508.342789244, -20037508.34278914, 20037508.342789244, 20037508.342789091);
        mapParameter.prjCoordSys = PrjCoordSysConversionTool.getPrjCoordSys(3857);

        /**
         * 比例尺由小到大排列，分辨率由大到小排列。
         */
        mapParameter.scales = new double[] { 2.7042617145642484E-8, 5.408523429128497E-8, 1.0817046858256994E-7, 2.1634093716513987E-7, 4.3268187433027975E-7,
                8.653637486605595E-7, 1.730727497321119E-6, 3.461454994642238E-6, 6.922909989284476E-6, 1.3845819978568952E-5, 2.7691639957137904E-5,
                5.538327991427581E-5, 1.1076655982855162E-4, 2.2153311965710323E-4, 4.4306623931420646E-4 };
        mapParameter.resolutions = new double[] { 9783.93962050256, 4891.96981025128, 2445.98490512564, 1222.99245256282, 611.49622628141, 305.748113140705,
                152.8740565703525, 76.43702828517625, 38.21851414258813, 19.109257071294063, 9.554628535647032, 4.777314267823516, 2.388657133911758,
                1.194328566955879, 0.5971642834779395 };

        /**
         * 构造在线地图瓦片url,一般需要涉及到的变量有分辨率或比例尺等级、瓦片的行列号。
         */
        mapParameter.remoteTileUrl = new RemoteTileUrl() {
            @Override
            public String getUrl(TileImagePrameter tileParameter) {
                // double resolution = tileParameter.resolution;
                // Rectangle2D tileBounds = tileParameter.viewBounds();

                /**
                 * supermap默认的坐标系为X轴正方向向右,Y轴正方向向下。如果第三方在线地图的默认坐标系和supermap默认的坐标系不同的话,那么瓦片行列号可能涉及到转换。
                 * 默认的地图显示等级是从0开始,如果第三方地图显示等级为第4级开始,那么应该在0的基础上加4。
                 */
                int level = ArrayUtils.indexOf(mapParameter.scales, tileParameter.mapParameter.scale, 1E-9) + 4;
                String sosoUrl = String.format("http://rt2.map.gtimg.com/realtimerender?z=%d&x=%d&y=%d&type=vector&style=0", level, tileParameter.x,
                        (int) Math.pow(2, level) - tileParameter.y - 1);
                return sosoUrl;
            }
        };
        return Arrays.asList(new RemoteTileMapParameter[] { mapParameter });
    }

}
