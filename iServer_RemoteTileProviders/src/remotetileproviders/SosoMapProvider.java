package remotetileproviders;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import com.supermap.services.components.commontypes.Point2D;
import com.supermap.services.components.commontypes.Rectangle2D;
import com.supermap.services.util.PrjCoordSysConversionTool;

/**
 * <p>
 * Soso��ͼ�����ṩ��
 * </p>
 * <table width="800">
 * <th>��ͼ��ز���</th>
 *  <tr><td width="100">����</td><td>4-18��</td></tr>
 *  <tr><td width="100">ͶӰ</td><td>WGS84 Web Mercator</td></tr>
 *  <tr><td width="100">��Ƭԭ��</td><td>-20037508.342789244, 20037508.342789091</td></tr>
 *  <tr><td width="100">ȫͼ��Χ</td><td>-20037508.342789244, -20037508.34278914, 20037508.342789244, 20037508.342789091</td></tr>
 *  <tr><td width="100">������</td><td>2.7042617145642484E-8, 5.408523429128497E-8, 1.0817046858256994E-7, 2.1634093716513987E-7, 4.3268187433027975E-7,
                8.653637486605595E-7, 1.730727497321119E-6, 3.461454994642238E-6, 6.922909989284476E-6, 1.3845819978568952E-5, 2.7691639957137904E-5,
                5.538327991427581E-5, 1.1076655982855162E-4, 2.2153311965710323E-4, 4.4306623931420646E-4</td></tr>
    <tr><td width="100">X��</td><td>����������</td></tr>
    <tr><td width="100">Y��</td><td>����������</td></tr>
 */
public class SosoMapProvider extends ProviderBase {

    /**
     * <p>
     * ��ȡ��ͼ�������󼯺ϡ�
     * </p>
     * @return ��ͼ�������󼯺ϡ�
     */
    @Override
    public List<RemoteTileMapParameter> remoteTileMapParameters() {
        /**
         * ����һ����ͼ�����������õ�ͼ����
         * ��Ҫ���õ�ͼ���������У���ͼ��mapName����ͼ��ͼԭ��origin����ͼȫͼ��Χbounds����ͼ��ͶӰprjCoordSys����ͼ�����߼��ϡ���ͼ�ֱ��ʼ��ϡ�����������Ƭ��url��ַ
         */
        final RemoteTileMapParameter mapParameter = new RemoteTileMapParameter();
        mapParameter.mapName = "SosoMap";
        mapParameter.origin = new Point2D(-20037508.342789244, 20037508.342789091);
        mapParameter.bounds = new Rectangle2D(-20037508.342789244, -20037508.34278914, 20037508.342789244, 20037508.342789091);
        mapParameter.prjCoordSys = PrjCoordSysConversionTool.getPrjCoordSys(3857);

        /**
         * ��������С�������У��ֱ����ɴ�С���С�
         */
        mapParameter.scales = new double[] { 2.7042617145642484E-8, 5.408523429128497E-8, 1.0817046858256994E-7, 2.1634093716513987E-7, 4.3268187433027975E-7,
                8.653637486605595E-7, 1.730727497321119E-6, 3.461454994642238E-6, 6.922909989284476E-6, 1.3845819978568952E-5, 2.7691639957137904E-5,
                5.538327991427581E-5, 1.1076655982855162E-4, 2.2153311965710323E-4, 4.4306623931420646E-4 };
        mapParameter.resolutions = new double[] { 9783.93962050256, 4891.96981025128, 2445.98490512564, 1222.99245256282, 611.49622628141, 305.748113140705,
                152.8740565703525, 76.43702828517625, 38.21851414258813, 19.109257071294063, 9.554628535647032, 4.777314267823516, 2.388657133911758,
                1.194328566955879, 0.5971642834779395 };

        /**
         * �������ߵ�ͼ��Ƭurl,һ����Ҫ�漰���ı����зֱ��ʻ�����ߵȼ�����Ƭ�����кš�
         */
        mapParameter.remoteTileUrl = new RemoteTileUrl() {
            @Override
            public String getUrl(TileImagePrameter tileParameter) {
                // double resolution = tileParameter.resolution;
                // Rectangle2D tileBounds = tileParameter.viewBounds();

                /**
                 * supermapĬ�ϵ�����ϵΪX������������,Y�����������¡�������������ߵ�ͼ��Ĭ������ϵ��supermapĬ�ϵ�����ϵ��ͬ�Ļ�,��ô��Ƭ���кſ����漰��ת����
                 * Ĭ�ϵĵ�ͼ��ʾ�ȼ��Ǵ�0��ʼ,�����������ͼ��ʾ�ȼ�Ϊ��4����ʼ,��ôӦ����0�Ļ����ϼ�4��
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
