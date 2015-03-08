package remotetileproviders;

import com.supermap.services.components.commontypes.Point2D;
import com.supermap.services.components.commontypes.PrjCoordSys;

import com.supermap.services.components.commontypes.Rectangle2D;

/**
 * <p>
 * 在线地图参数
 * </p>
 */
public class RemoteTileMapParameter {
	/**
	 * <p>
	 * 地图名。
	 * </p>
	 */
	public String mapName;
	/**
	 * <p>
	 * 切片原点。
	 * </p>
	 */
	public Point2D origin;
	/**
	 * <p>
	 * 全图范围。
	 * </p>
	 */
	public Rectangle2D bounds;
	/**
	 * <p>
	 * 地图投影。
	 * </p>
	 */
	public PrjCoordSys prjCoordSys;

	/**
	 * <p>
	 * 分辨率集合。
	 * </p>
	 */
	public double[] resolutions;
	/**
	 * <p>
	 * 比例尺集合。
	 * </p>
	 */
	public double[] scales;
	/**
	 * 建议比例尺和分辨率都要设置，如果只设置其中一个参数，
	 * 默认通过TileTool中提供的转换方法resolutionToScale或scaleToResolution转换得到另一个参数。
	 */

	/**
	 * <p>
	 * 在线瓦片url。
	 * </p>
	 */
	public RemoteTileUrl remoteTileUrl;

}