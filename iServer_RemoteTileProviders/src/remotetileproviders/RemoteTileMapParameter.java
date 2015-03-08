package remotetileproviders;

import com.supermap.services.components.commontypes.Point2D;
import com.supermap.services.components.commontypes.PrjCoordSys;

import com.supermap.services.components.commontypes.Rectangle2D;

/**
 * <p>
 * ���ߵ�ͼ����
 * </p>
 */
public class RemoteTileMapParameter {
	/**
	 * <p>
	 * ��ͼ����
	 * </p>
	 */
	public String mapName;
	/**
	 * <p>
	 * ��Ƭԭ�㡣
	 * </p>
	 */
	public Point2D origin;
	/**
	 * <p>
	 * ȫͼ��Χ��
	 * </p>
	 */
	public Rectangle2D bounds;
	/**
	 * <p>
	 * ��ͼͶӰ��
	 * </p>
	 */
	public PrjCoordSys prjCoordSys;

	/**
	 * <p>
	 * �ֱ��ʼ��ϡ�
	 * </p>
	 */
	public double[] resolutions;
	/**
	 * <p>
	 * �����߼��ϡ�
	 * </p>
	 */
	public double[] scales;
	/**
	 * ��������ߺͷֱ��ʶ�Ҫ���ã����ֻ��������һ��������
	 * Ĭ��ͨ��TileTool���ṩ��ת������resolutionToScale��scaleToResolutionת���õ���һ��������
	 */

	/**
	 * <p>
	 * ������Ƭurl��
	 * </p>
	 */
	public RemoteTileUrl remoteTileUrl;

}