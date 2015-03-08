package remotetileproviders;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import com.supermap.services.components.commontypes.Point2D;
import com.supermap.services.components.commontypes.Rectangle2D;
import com.supermap.services.util.PrjCoordSysConversionTool;

/**
 * <p>
 * 天地图服务提供者
 * </p>
 * <table width="800">
 * <th>地图相关参数</th>
 * <tr>
 * <td width="100">级别</td>
 * <td>1-18级</td>
 * </tr>
 * <tr>
 * <td width="100">投影</td>
 * <td>China Geodetic Coordinate System 2000</td>
 * </tr>
 * <tr>
 * <td width="100">切片原点</td>
 * <td>-180, 90</td>
 * </tr>
 * <tr>
 * <td width="100">全图范围</td>
 * <td>-180, -90, 180, 90</td>
 * </tr>
 * <tr>
 * <td width="100">比例尺</td>
 * <td>3.3803271432053105E-9, 6.760654286410621E-9, 1.3521308572821242E-8,
 * 2.7042617145642484E-8, 5.408523429128497E-8, 1.0817046858256994E-7,
 * 2.1634093716513987E-7, 4.3268187433027975E-7, 8.653637486605595E-7,
 * 1.730727497321119E-6, 3.461454994642238E-6, 6.922909989284476E-6,
 * 1.3845819978568952E-5, 2.7691639957137904E-5, 5.538327991427581E-5,
 * 1.1076655982855162E-4, 2.2153311965710323E-4, 4.4306623931420646E-4</td>
 * </tr>
 * <tr>
 * <td width="100">X轴</td>
 * <td>正方向向右</td>
 * </tr>
 * <tr>
 * <td width="100">Y轴</td>
 * <td>正方向向下</td>
 * </tr>
 * <tr>
 * <td width="100">参见：<a
 * href=" http://www.tianditu.com/guide/index.html">天地图</a></td>
 * </tr>
 * </table>
 */
public class TiandituMapProvider extends ProviderBase {

	/**
	 * <p>
	 * 获取地图参数对象集合。
	 * </p>
	 * 
	 * @return 地图参数对象集合。
	 */
	@Override
	public List<RemoteTileMapParameter> remoteTileMapParameters() {
		/**
		 * 构造一个地图参数对象，设置地图参数
		 * 需要设置地图参数包括有：地图名mapName、地图切图原点origin、bounds、地图的投影prjCoordSys
		 * 、地图比例尺集合、地图分辨率集合、构造在线瓦片的url地址
		 */
		final RemoteTileMapParameter mapParameter1 = new RemoteTileMapParameter();
		mapParameter1.mapName = "BaseMap";
		mapParameter1.origin = new Point2D(-180, 90);
		mapParameter1.bounds = new Rectangle2D(-180, -90, 180, 90);
		mapParameter1.prjCoordSys = PrjCoordSysConversionTool
				.getPrjCoordSys(4490);

		/**
		 * 比例尺由小到大排列，分辨率由大到小排列。
		 */
		mapParameter1.scales = new double[] { 3.3803271432053105E-9,
				6.760654286410621E-9, 1.3521308572821242E-8,
				2.7042617145642484E-8, 5.408523429128497E-8,
				1.0817046858256994E-7, 2.1634093716513987E-7,
				4.3268187433027975E-7, 8.653637486605595E-7,
				1.730727497321119E-6, 3.461454994642238E-6,
				6.922909989284476E-6, 1.3845819978568952E-5,
				2.7691639957137904E-5, 5.538327991427581E-5,
				1.1076655982855162E-4, 2.2153311965710323E-4,
				4.4306623931420646E-4 };
		mapParameter1.resolutions = new double[] { 0.7031249999999999,
				0.35156249999999994, 0.17578124999999997, 0.08789062499999999,
				0.04394531249999999, 0.021972656249999997,
				0.010986328124999998, 0.005493164062499999,
				0.0027465820312499996, 0.0013732910156249998,
				6.866455078124999E-4, 3.4332275390624995E-4,
				1.7166137695312497E-4, 8.583068847656249E-5,
				4.291534423828124E-5, 2.145767211914062E-5,
				1.072883605957031E-5, 5.364418029785155E-6 };

		/**
		 * 构造在线地图瓦片url,一般需要涉及到的变量有分辨率或比例尺等级、瓦片的行列号。
		 */
		mapParameter1.remoteTileUrl = new RemoteTileUrl() {
			@Override
			public String getUrl(TileImagePrameter tileParameter) {
				// double resolution = tileParameter.resolution;
				// Rectangle2D tileBounds = tileParameter.viewBounds();

				/**
				 * supermap默认的坐标系为X轴正方向向右,Y轴正方向向下。
				 * 如果第三方在线地图的默认坐标系和supermap默认的坐标系不同的话,那么瓦片行列号可能涉及到转换。
				 * 默认的地图显示等级是从0开始,如果第三方地图显示等级为第4级,那么应该在0的基础上加4。
				 */
				int level = ArrayUtils.indexOf(mapParameter1.scales,
						tileParameter.mapParameter.scale, 1E-9) + 1;
				String tiandituUrl = String
						.format("http://t0.tianditu.com/vec_c/wmts?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&Layer=vec&Style=default&Format=png&TileMatrixSet=c&TileMatrix=%d&TileRow=%d&TileCol=%d",
								level, tileParameter.y, tileParameter.x);
				return tiandituUrl;
			}
		};

		final RemoteTileMapParameter mapParameter2 = new RemoteTileMapParameter();
		mapParameter2.mapName = "ChineseAnnotationMap";
		mapParameter2.origin = new Point2D(-180, 90);
		mapParameter2.bounds = new Rectangle2D(-180, -90, 180, 90);
		mapParameter2.prjCoordSys = PrjCoordSysConversionTool
				.getPrjCoordSys(4490);

		mapParameter2.scales = new double[] { 3.3803271432053105E-9,
				6.760654286410621E-9, 1.3521308572821242E-8,
				2.7042617145642484E-8, 5.408523429128497E-8,
				1.0817046858256994E-7, 2.1634093716513987E-7,
				4.3268187433027975E-7, 8.653637486605595E-7,
				1.730727497321119E-6, 3.461454994642238E-6,
				6.922909989284476E-6, 1.3845819978568952E-5,
				2.7691639957137904E-5, 5.538327991427581E-5,
				1.1076655982855162E-4, 2.2153311965710323E-4,
				4.4306623931420646E-4, 8.8613247862841292E-4 };

		mapParameter2.remoteTileUrl = new RemoteTileUrl() {
			@Override
			public String getUrl(TileImagePrameter tileParameter) {
				// double resolution = tileParameter.resolution;
				// Rectangle2D tileBounds = tileParameter.viewBounds();
				int level = ArrayUtils.indexOf(mapParameter2.scales,
						tileParameter.mapParameter.scale, 1E-9) + 1;
				String tiandituUrl = String
						.format("http://t0.tianditu.com/cva_c/wmts?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&Layer=cva&Style=default&Format=png&TileMatrixSet=c&TileMatrix=%d&TileRow=%d&TileCol=%d",
								level, tileParameter.y, tileParameter.x);
				return tiandituUrl;
			}
		};

		final RemoteTileMapParameter mapParameter3 = new RemoteTileMapParameter();
		mapParameter3.mapName = "EnglishAnnotationMap";
		mapParameter3.origin = new Point2D(-180, 90);
		mapParameter3.bounds = new Rectangle2D(-180, -90, 180, 90);
		mapParameter3.prjCoordSys = PrjCoordSysConversionTool
				.getPrjCoordSys(4490);
		mapParameter3.scales = new double[] { 3.3803271432053105E-9,
				6.760654286410621E-9, 1.3521308572821242E-8,
				2.7042617145642484E-8, 5.408523429128497E-8,
				1.0817046858256994E-7, 2.1634093716513987E-7,
				4.3268187433027975E-7, 8.653637486605595E-7,
				1.730727497321119E-6, };
		mapParameter3.remoteTileUrl = new RemoteTileUrl() {
			@Override
			public String getUrl(TileImagePrameter tileParameter) {
				// double resolution = tileParameter.resolution;
				// Rectangle2D tileBounds = tileParameter.viewBounds();
				int level = ArrayUtils.indexOf(mapParameter3.scales,
						tileParameter.mapParameter.scale, 1E-9) + 1;
				String tiandituUrl = String
						.format("http://t0.tianditu.com/eva_c/wmts?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&Layer=eva&Style=default&Format=png&TileMatrixSet=c&TileMatrix=%d&TileRow=%d&TileCol=%d",
								level, tileParameter.y, tileParameter.x);
				return tiandituUrl;
			}
		};
		return Arrays.asList(new RemoteTileMapParameter[] { mapParameter1,
				mapParameter2, mapParameter3 });
	}
}
